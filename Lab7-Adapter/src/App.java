import adapters.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class App {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> meuMapa = new HashMap<>();
        Map<Integer, Integer> meuMapaTeste = new HashMap<>();
        List<Integer> minhaLista = new ArrayList<Integer>();
        List<Integer> minhaListaTeste = new ArrayList<Integer>();

        meuMapa.put(0, 10);
        minhaLista.add(10);

        
        List<Integer> minhaListaAdaptada = new MapToListAdapter<>(meuMapa);
        Map<Integer, Integer> meuMapaAdaptado = new ListToMapAdapter<>(minhaLista);


        meuMapa.put(1, 15);
        meuMapa.put(2, 20);
        meuMapa.remove(2);
        System.out.println("O tamanho do map é: " + meuMapa.size());
        System.out.println("O map esta vazio?: " + meuMapa.isEmpty());
        System.out.println("O valor para a chave 1 é: " + meuMapa.get(1));
        System.out.println("O map contem o valor 15?: " + meuMapa.containsValue(15));
        System.out.println("O map contem a cahve 0?: " + meuMapa.containsKey(0));

        meuMapaAdaptado.put(1, 15);
        meuMapaAdaptado.put(2, 20);
        meuMapaAdaptado.remove(2);
        System.out.println("O tamanho do map é: " + meuMapaAdaptado.size());
        System.out.println("O map esta vazio?: " + meuMapaAdaptado.isEmpty());
        System.out.println("O valor para a chave 1 é: " + meuMapaAdaptado.get(1));
        System.out.println("O map contem o valor 15?: " + meuMapaAdaptado.containsValue(15));
        System.out.println("O map contem a cahve 0?: " + meuMapaAdaptado.containsKey(0));
        
 
        Collection<Integer> valoresAdaptados = meuMapaAdaptado.values();

        System.out.println("Os valores do mapa são os mesmos do mapa adaptado?"+ meuMapa.equals(valoresAdaptados));


        System.out.println("Os valores do map são:[");
        for (int i=0; i<meuMapa.size(); i++) {
            System.out.print(meuMapa.get(i) + ", ");
        }
        System.out.println("]");



        System.out.println("Os valores do map adaptado são:[");
        for (int i=0; i<meuMapaAdaptado.size(); i++) {
            System.out.print(meuMapaAdaptado.get(i) + ", ");
        }
        System.out.println("]");
//------------------------------------------------------------------------
        System.out.println("\n------------------TESTES COM O lista DE TESTE------------------\n");
        minhaLista.add( 15);
        minhaLista.add( 20);
        minhaLista.remove(2);
        System.out.println("O tamanho do map é: " + minhaLista.size());
        System.out.println("O map esta vazio?: " + minhaLista.isEmpty());
        System.out.println("O valor para a chave 1 é: " + minhaLista.get(1));
        System.out.println("O map contem o valor 15?: " + minhaLista.contains(15));
        Object[] listateste = minhaLista.toArray();

        minhaListaAdaptada.add(15);
        minhaListaAdaptada.add(20);
        minhaListaAdaptada.remove(2);
        System.out.println("O tamanho do map é: " + minhaListaAdaptada.size());
        System.out.println("O map esta vazio?: " + minhaListaAdaptada.isEmpty());
        System.out.println("O valor para a chave 1 é: " + minhaListaAdaptada.get(1));
        System.out.println("O map contem o valor 15?: " + minhaListaAdaptada.contains(15));

        System.out.println("Os valores do mapa são os mesmos do mapa adaptado?"+ minhaLista.equals(valoresAdaptados));


        System.out.println("Os valores do map são:[");
        for (int i=0; i<minhaLista.size(); i++) {
            System.out.print(minhaLista.get(i) + ", ");
        }
        System.out.println("]");



        System.out.println("Os valores do map adaptado são:[");
        for (int i=0; i<minhaListaAdaptada.size(); i++) {
            System.out.print(minhaListaAdaptada.get(i) + ", ");
        }
        System.out.println("]");
        

    }


}
