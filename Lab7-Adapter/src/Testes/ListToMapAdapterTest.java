package Testes;

import adapters.ListToMapAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListToMapAdapterTest {

    List<Integer> list;
    ListToMapAdapter<Integer> mapAdapter;

    @BeforeEach
    public void setUp(){
        this.list = new ArrayList<>();
        this.mapAdapter = new ListToMapAdapter<>(list);
    }


    @Test
    public void containsKeyMapAdapterTestSucess(){
        this.mapAdapter.put(0,1);

        Assertions.assertTrue(this.mapAdapter.containsKey(0));
    }

    @Test
    public void containsKeyMapAdapterTestError(){
        Assertions.assertFalse(this.mapAdapter.containsKey(0));
    }

    @Test
    public void containsValueMapAdapterTestSucess(){
        this.mapAdapter.put(0,1);

        Assertions.assertTrue(this.mapAdapter.containsValue(1));
    }

    @Test
    public void containsValueMapAdapterTestError(){
        Assertions.assertFalse(this.mapAdapter.containsValue(0));
    }

    @Test
    public void isEmptyMapAdapterTestReturnTrue(){
        Assertions.assertTrue(this.mapAdapter.isEmpty());
    }

    @Test
    public void isEmptyMapAdapterTestReturnFalse(){
        this.mapAdapter.put(0,1);

        Assertions.assertFalse(this.mapAdapter.isEmpty());
    }

    @Test
    public void putMapAdapterTestSucess(){
        Assertions.assertEquals(null, this.mapAdapter.put(0,1));
    }

    @Test
    public void putMapAdapterTestError(){
        Assertions.assertNotEquals(1, this.mapAdapter.put(0,1));
    }

    @Test
    public void putMapAdapterTestThrowsException(){

        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> this.mapAdapter.put(1,1));
    }

    @Test
    public void removeMapAdapterTestSucess(){
        this.mapAdapter.put(0,1);

        Assertions.assertEquals(1, this.mapAdapter.remove(1));
    }

    @Test
    public void sizeMapAdapterTestSucess(){
        this.mapAdapter.put(0,1);

        Assertions.assertEquals(1, this.mapAdapter.size());
    }

    @Test
    public void sizeMapAdapterTestError(){
        Assertions.assertNotEquals(1, this.mapAdapter.size());
    }


}
