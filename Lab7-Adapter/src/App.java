import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import adapters.*;
public class App {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> meuMapa = new HashMap<>();
        List<Integer> minhaLista = new MapToListAdapter<>(meuMapa);

        List<Integer> minhaLista2 = new ArrayList<Integer>();
        Map<Integer, Integer> meuMapa2 = new ListToMapAdapter<>(minhaLista2);



    }
}
