package test;

import org.junit.jupiter.api.Test;
import src.FactoryMethods.SanduicheGourmet;
import src.ProdutosConcretos.*;


import static org.junit.jupiter.api.Assertions.*;

public class SanduicheGourmetTest {

    @Test
    public void montarSanduicheCompleto() {
        SanduicheGourmet sanduiche = new SanduicheGourmet();

        assertEquals("Esse sanduiche possui os seguintes ingredientes: pão bola, presunto de peru, queijo cheddar e ovo de capoeira", sanduiche.montar());
    }

    @Test
    public void montarSanduicheCompletoParcialmente(){
        SanduicheGourmet sanduiche = new SanduicheGourmet();
        assertEquals("pão bola",sanduiche.adicionarPao().toString());
        assertEquals("queijo cheddar",sanduiche.adicionarQueijo().toString());
        assertEquals("presunto de peru",sanduiche.adicionarPresunto().toString());
        assertEquals("ovo de capoeira",sanduiche.adicionarOvo().toString());


    }
}
