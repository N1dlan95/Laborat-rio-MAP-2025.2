package test;

import org.junit.jupiter.api.Test;
import src.FactoryMethods.SanduicheIntegral;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SanduicheIntegralTest {

    @Test
    public void montarSanduicheCompleto() {
        SanduicheIntegral sanduiche = new SanduicheIntegral();

        assertEquals("Esse sanduiche possui os seguintes ingredientes: pão integral, presunto de peru e queijo prato", sanduiche.montar());
    }

    @Test
    public void montarSanduicheCompletoParcialmente(){
        SanduicheIntegral sanduiche = new SanduicheIntegral();
        assertEquals("pão integral",sanduiche.adicionarPao().toString());
        assertEquals("queijo prato",sanduiche.adicionarQueijo().toString());
        assertEquals("presunto de peru",sanduiche.adicionarPresunto().toString());


    }

}
