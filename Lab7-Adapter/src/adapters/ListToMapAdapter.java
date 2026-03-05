package adapters;

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;
import java.util.AbstractSet;
import java.util.Objects;
import java.util.NoSuchElementException;

public class ListToMapAdapter<V> implements Map<Integer, V> {

    private final List<V> list;

    public ListToMapAdapter(List<V> list) {
        this.list = Objects.requireNonNull(list, "list não pode ser null");
    }

    // Métodos principais do Map

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        Integer idx = toIndex(key);
        return idx != null && idx >= 0 && idx < list.size();
    }

    @Override
    public boolean containsValue(Object value) {
        return list.contains(value);
    }

    @Override
    public V get(Object key) {
        Integer idx = toIndex(key);
        if (idx == null || idx < 0 || idx >= list.size()) return null;
        return list.get(idx);
    }

    @Override
    public V put(Integer key, V value) {
        Objects.requireNonNull(key, "key não pode ser null");
        int idx = key;

        if (idx < 0) throw new IndexOutOfBoundsException("Índice negativo: " + idx);

        if (idx < list.size()) {
            return list.set(idx, value);
        }

        if (idx == list.size()) {
            list.add(value);
            return null;
        }

        throw new IndexOutOfBoundsException("Índice " + idx + " > size() " + list.size());
    }

    @Override
    public V remove(Object key) {
        Integer idx = toIndex(key);
        if (idx == null || idx < 0 || idx >= list.size()) return null;
        return list.remove((int) idx);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends V> m) {
        for (Entry<? extends Integer, ? extends V> e : m.entrySet()) {
            this.put(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return new AbstractSet<>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<>() {
                    private int i = 0;
                    private int last = -1;

                    @Override
                    public boolean hasNext() {
                        return i < list.size();
                    }

                    @Override
                    public Integer next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        last = i;
                        return i++;
                    }

                    @Override
                    public void remove() {
                        if (last < 0) throw new IllegalStateException();
                        list.remove(last);
                        i = last;
                        last = -1;
                    }
                };
            }

            @Override
            public int size() {
                return list.size();
            }

            @Override
            public boolean contains(Object o) {
                return containsKey(o);
            }

            @Override
            public boolean remove(Object o) {
                Integer idx = toIndex(o);
                if (idx == null || idx < 0 || idx >= list.size()) return false;
                list.remove((int) idx);
                return true;
            }

            @Override
            public void clear() {
                list.clear();
            }
        };
    }

    @Override
    public Collection<V> values() {
        // A própria lista já é uma Collection;
        return list;
    }

    @Override
    public Set<Entry<Integer, V>> entrySet() {
        return new AbstractSet<>() {
            @Override
            public Iterator<Entry<Integer, V>> iterator() {
                return new Iterator<>() {
                    private int i = 0;
                    private int last = -1;

                    @Override
                    public boolean hasNext() {
                        return i < list.size();
                    }

                    @Override
                    public Entry<Integer, V> next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        last = i;
                        int currentIndex = i++;

                        return new SimpleEntry<Integer, V>(currentIndex, list.get(currentIndex)) {
                            @Override
                            public V setValue(V value) {
                                V old = list.set(currentIndex, value);
                                super.setValue(value);
                                return old;
                            }

                            @Override
                            public V getValue() {
                                // mantém sempre sincronizado com a lista
                                return list.get(currentIndex);
                            }
                        };
                    }

                    @Override
                    public void remove() {
                        if (last < 0) throw new IllegalStateException();
                        list.remove(last);
                        i = last;
                        last = -1;
                    }
                };
            }

            @Override
            public int size() {
                return list.size();
            }

            @Override
            public void clear() {
                list.clear();
            }

            @Override
            public boolean contains(Object o) {
                if (!(o instanceof Entry<?, ?> e)) return false;
                Integer k = toIndex(e.getKey());
                if (k == null || k < 0 || k >= list.size()) return false;
                return Objects.equals(list.get(k), e.getValue());
            }
        };
    }

    // equals/hashCode do Map
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Map<?, ?> other)) return false;
        if (other.size() != this.size()) return false;

        for (int i = 0; i < list.size(); i++) {
            Object ov = other.get(i);
            if (!Objects.equals(list.get(i), ov)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int h = 0;
        for (int i = 0; i < list.size(); i++) {
            h += Objects.hashCode(i) ^ Objects.hashCode(list.get(i));
        }
        return h;
    }

    private Integer toIndex(Object key) {
        return (key instanceof Integer) ? (Integer) key : null;
    }
}