package Tests;

import controller.guicheController;
import model.Assento;
import model.Onibus;
import model.StatusAssento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuicheControllerTeste {

    guicheController guicheController;

    Onibus onibus;

    Assento[] assentos;

    @BeforeEach
    public void setUp(){
        onibus = new Onibus();

        guicheController = new guicheController(onibus);

        assentos = onibus.getPoltronas();
    }


    @Test
    public void reservarAssentoTest(){
        guicheController.reservarAssento(1);

        Assertions.assertEquals(StatusAssento.Reservado, onibus.getPoltronas()[0].getStatus());
    }

    @Test
    public void comprarAssentoTest(){
        guicheController.comprarAssento(1);

        Assertions.assertEquals(StatusAssento.Vendido, onibus.getPoltronas()[0].getStatus());
    }

}
