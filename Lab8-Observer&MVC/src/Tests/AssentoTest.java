package Tests;

import controller.guicheController;
import jdk.jshell.Snippet;
import model.Assento;
import model.Onibus;
import model.StatusAssento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssentoTest {

   private Assento assento;

    @BeforeEach
    public void setUp(){
        assento = new Assento(4);
    }

    @Test
    public void AssentoDisponivelTeste(){

        Assertions.assertEquals(StatusAssento.Disponivel, assento.getStatus());

    }
    
    @Test
    public void AssentoReservadoTeste(){
       assento.setStatus(StatusAssento.Reservado);
       
       Assertions.assertEquals(StatusAssento.Reservado, assento.getStatus());
    }
    
    @Test
    public void AssentoVendidoTeste(){
       assento.setStatus(StatusAssento.Vendido);
       
       Assertions.assertEquals(StatusAssento.Vendido, assento.getStatus());
    }
    
    @Test
    public void getNumeroAssentoTeste(){
        
        Assertions.assertEquals(4, assento.getNumIdentificador());
    }
    

}
