package adapters;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ListToMapAdapter<V> implements Map<Integer, V> {

    private final List<V> list;

    public ListToMapAdapter(List<V> list) {
        this.list = Objects.requireNonNull(list, "list não pode ser null");
    }

    // Métodos principais do Map

    @Override
    public void clear() {
        list.clear();
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
    public V get(Object key) {
        Integer idx = toIndex(key);
        if (idx == null || idx < 0 || idx >= list.size()) return null;
        return list.get(idx);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
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
        Integer idx = list.indexOf(key);;
        if (idx < 0 || idx >= list.size()) return null;
        return list.remove((int) idx);
    }
    @Override
    public int size() {
        return list.size();
    }
    
    @Override
    public Collection<V> values() {
        // A própria lista já é uma Collection;
        return list;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends V> m) {
        for (Entry<? extends Integer, ? extends V> e : m.entrySet()) {
            this.put(e.getKey(), e.getValue());
        }
    }



    @Override
    public Set<Integer> keySet() {
        throw new UnsupportedOperationException("Unimplemented method 'keyset'");
    }


    @Override
    public Set<Entry<Integer, V>> entrySet() {
        throw new UnsupportedOperationException("Unimplemented method 'entrySet'");
    }

    // equals/hashCode do Map


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