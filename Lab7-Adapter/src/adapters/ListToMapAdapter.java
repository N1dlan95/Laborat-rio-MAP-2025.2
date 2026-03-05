package adapters;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListToMapAdapter<K,V> implements Map<K,V> {
    private List<K> list;

    public ListToMapAdapter(List<K> list) {
        this.list = list;
    }

    @Override
    public void clear() {        // Implementation to clear the map
    }

    @Override
    public boolean containsKey(Object key) {
        // Implementation to check if the key exists in the map
        return false; // Placeholder return statement
    }

    @Override
    public boolean containsValue(Object value) {
        // Implementation to check if the value exists in the map
        return false; // Placeholder return statement
    }
    @Override
    public boolean equals(Object o) {
        // Implementation to compare this map with another object
        return false; // Placeholder return statement
    }
    @Override
    public V get(Object key) {
        // Implementation to retrieve value based on the key
        return null; // Placeholder return statement
    }
    @Override
    public boolean isEmpty() {
        // Implementation to check if the map is empty
        return false; // Placeholder return statement
    }

    @Override
    public V put(Object key, Object value) {
        // Implementation to add key-value pair to the map
        return null; // Placeholder return statement
    }



    @Override
    public V remove(Object key) {
        // Implementation to remove a key-value pair from the map
        return null; // Placeholder return statement
    }

    @Override
    public int size() {
        // Implementation to return the size of the map
        return 0; // Placeholder return statement
    }

    @Override
    public Collection<V> values() {
        // Implementation to return a collection of values in the map
        return null; // Placeholder return statement
    }




    // Other methods from the Map interface can be implemented similarly
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putAll'");
    }

    @Override
    public Set<K> keySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keySet'");
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entrySet'");
    }


}
