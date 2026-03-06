package adapters;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MapToListAdapter<V> implements List<V> {
    private Map<Integer, V> map;
    
    public MapToListAdapter(Map<Integer, V> map) {
        this.map = map;
    }
    
    @Override
    public boolean add(Object V) {
        int index = this.size();
        this.map.put(index, (V) V);
        return true;
    }
    


    @Override
    public void clear() {
        map.clear();
    }

    
    @Override
    public boolean contains(Object o) {
        return map.containsValue(o);
    }

    @Override
    public boolean equals(Object o) {
        return map.equals(o);
    }

    @Override
    public V get(int index) {
        return (V) map.get(index);
    }
    
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
    
    @Override
    public Iterator<V> iterator() {
        throw new UnsupportedOperationException("Não ha suporte para o retorno de um iterator");
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public int size() {
        return map.size();
    }


    @Override
    public Object[] toArray() {
        return map.keySet().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return map.keySet().toArray(a);

    }


    // Other methods from the List interface can be implemented similarly

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends V> c) {
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends V> c) {
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    


    @Override
    public V set(int index, V element) {
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public V remove(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public ListIterator<V> listIterator() {
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<V> listIterator(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<V> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

    @Override
    public void add(int index, V element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}