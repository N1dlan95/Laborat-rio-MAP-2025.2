package aplicacao.Test;

import aplicacao.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CircleSingletonTest {

    CirculoSingleton firstCircle;
    CirculoSingleton secondCircle;

    @BeforeEach
    public void setUp(){
        firstCircle = CirculoSingleton.getInstance(5);
        secondCircle = CirculoSingleton.getInstance(5);
    }

    @Test
    public void testeVerificarIgualdadeDeInstanciasSemParametro(){
        CirculoSingleton c1 = CirculoSingleton.getInstance();
        CirculoSingleton c2 = CirculoSingleton.getInstance();

        Assertions.assertEquals(c1,c2);
    }

    @Test
    public void testeVerificarIgualdadeDeInstanciasComParametroIguais(){

        Assertions.assertEquals(firstCircle, secondCircle);
    }

    @Test
    public void testeVerificarIgualdadeDeInstanciasComParametrosDiferentes(){
        CirculoSingleton c3 = CirculoSingleton.getInstance(2);
        CirculoSingleton c4 = CirculoSingleton.getInstance(5);

        Assertions.assertEquals(c3, c4);
    }

    @Test
    public void testeVerificarIgualdadeDeRaioComParametrosIguais(){
        Assertions.assertEquals(firstCircle.getRadius(), secondCircle.getRadius());
    }

    @Test
    public void testeVerificarIgualdadeDeRaioComParametrosDiferentes(){
        CirculoSingleton c3 = CirculoSingleton.getInstance(2);
        CirculoSingleton c4 = CirculoSingleton.getInstance(5);

        Assertions.assertEquals(c3.getRadius(), c4.getRadius());
    }

    @Test
    public void testeVerificarIgualdadeDeRaioSemParametro(){
        CirculoSingleton c1 = CirculoSingleton.getInstance();
        CirculoSingleton c2 = CirculoSingleton.getInstance();

        Assertions.assertEquals(c1.getRadius(), c2.getRadius());
    }

    @Test
    public void testeVerificarIgualdadeDeAreasComParametrosIguais(){
        Assertions.assertEquals(firstCircle.getArea(), secondCircle.getArea());
    }

    @Test
    public void testeVerificarIgualdadeDeAreasComParametrosDiferentes(){
        CirculoSingleton c3 = CirculoSingleton.getInstance(2);
        CirculoSingleton c4 = CirculoSingleton.getInstance(5);

        Assertions.assertEquals(c3.getArea(), c4.getArea());
    }

    @Test
    public void testeVerificarIgualdadeDeAreasSemParametro(){
        CirculoSingleton c1 = CirculoSingleton.getInstance();
        CirculoSingleton c2 = CirculoSingleton.getInstance();

        Assertions.assertEquals(c1.getArea(), c2.getArea());
    }

}
