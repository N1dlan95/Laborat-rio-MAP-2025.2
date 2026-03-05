import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Adapter: adapta uma List<E> para ser usada como MapIF<Integer, E>.
 *
 * Regra:
 * - key (Integer) = índice da lista
 * - value (E) = elemento naquela posição
 */
public class ListToMapAdapter<E> implements MapIF<Integer, E> {

    private final List<E> list; // Adaptee

    public ListToMapAdapter(List<E> list) {
        this.list = Objects.requireNonNull(list, "list não pode ser null");
    }

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
    public E get(Object key) {
        Integer idx = toIndex(key);
        if (idx == null || idx < 0 || idx >= list.size()) return null;
        return list.get(idx);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * put:
     * - se 0 <= key < size -> substitui (set) e retorna antigo
     * - se key == size -> adiciona no final (add) e retorna null
     * - senão -> IndexOutOfBoundsException - aqui a exceção lançada
     */
    @Override
    public E put(Integer key, E value) {
        Objects.requireNonNull(key, "key não pode ser null");
        int idx = key;

        if (idx < 0) {
            throw new IndexOutOfBoundsException("Índice negativo: " + idx);
        }

        if (idx < list.size()) {
            return list.set(idx, value);
        }

        if (idx == list.size()) {
            list.add(value);
            return null;
        }

        throw new IndexOutOfBoundsException(
                "Índice " + idx + " maior que size() " + list.size()
        );
    }

    @Override
    public E remove(Object key) {
        Integer idx = toIndex(key);
        if (idx == null || idx < 0 || idx >= list.size()) return null;
        return list.remove((int) idx);
    }

    @Override
    public int size() {
        return list.size();
    }

    /**
     * values:
     * Como a List já é uma Collection, pode retornar direto.
     */
    @Override
    public Collection<E> values() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapIF<?, ?> other)) return false;
        if (this.size() != other.size()) return false;

        for (int i = 0; i < list.size(); i++) {
            Object vOther = other.get(i); // chave = índice
            if (!Objects.equals(list.get(i), vOther)) return false;
        }
        return true;
    }

    private Integer toIndex(Object key) {
        return (key instanceof Integer) ? (Integer) key : null;
    }
}