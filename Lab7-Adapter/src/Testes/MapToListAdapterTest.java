package Testes;

import adapters.MapToListAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapToListAdapterTest {

    Map<Integer, Integer> map;
    MapToListAdapter<Integer> listAdapter;

    @BeforeEach
    public void setUp(){
        this.map = new HashMap<>();
        this.listAdapter = new MapToListAdapter<>(map);

    }


    @Test
    public void addListAdapterTest(){
        Assertions.assertTrue(listAdapter.add(2));
    }

    @Test
    public void containsListAdapterTestReturnTrue(){
        this.listAdapter.add(2);

        Assertions.assertTrue(this.listAdapter.contains(2));
    }

    @Test
    public void containsListAdapterTestReturnFalse(){
        Assertions.assertFalse(listAdapter.contains(3));
    }

//    @Test
//    public void equalsListAdapterTestReturnTrue(){
//
//    }

    @Test
    public void equalsListAdapterTestReturnFalse(){
        Map<Integer, Integer> map2 = new HashMap<>();
        MapToListAdapter<Integer> listAdapter2 = new MapToListAdapter<>(map2);

        Assertions.assertNotEquals(listAdapter2, listAdapter);
    }

    @Test
    public void getListAdapterTestSucess(){
        this.listAdapter.add(1);

        Assertions.assertEquals(1, this.listAdapter.get(0));
    }

    @Test
    public void getListAdapterTestError(){
        Assertions.assertNotEquals(1, this.listAdapter.get(0));
    }

    @Test
    public void isEmptyListAdapterTestReturnTrue(){
        Assertions.assertTrue(this.listAdapter.isEmpty());
    }

    @Test
    public void isEmptyListAdapterTestReturnFalse(){
        this.listAdapter.add(1);

        Assertions.assertFalse(this.listAdapter.isEmpty());
    }

    @Test
    public void iteratorListAdapterTestThrowsException(){
        Assertions.assertThrows(UnsupportedOperationException.class, () ->  this.listAdapter.iterator());
    }

    @Test
    public void sizeListAdapterTestSucess(){
        Assertions.assertEquals(0, this.listAdapter.size());
    }

    @Test
    public void sizeListAdapterTestError(){
        this.listAdapter.add(1);

        Assertions.assertNotEquals(0, this.listAdapter.size());
    }

    @Test
    public void toArrayListAdapterTestError(){
        Integer[] meusNumeros = {1, 2};

        this.listAdapter.add(1);
        this.listAdapter.add(2);

        Assertions.assertNotEquals(meusNumeros, this.listAdapter.toArray());
    }

}
