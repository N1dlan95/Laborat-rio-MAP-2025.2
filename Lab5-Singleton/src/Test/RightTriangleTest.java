package aplicacao.Test;

import aplicacao.model.RightTriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RightTriangleTest {

    RightTriangle trianguloSemParametro1;
    RightTriangle trianguloSemParametro2;

    RightTriangle trianguloParametroIgual1;
    RightTriangle trianguloParametroIgual2;

    RightTriangle trianguloParametroDiferente1;
    RightTriangle trianguloParametroDiferente2;



    @BeforeEach
    public void setUp(){
        trianguloSemParametro1 = RightTriangle.getInstance();
        trianguloSemParametro2 = RightTriangle.getInstance();

        trianguloParametroIgual1 = RightTriangle.getInstance(2, 5, 7);
        trianguloParametroIgual2 = RightTriangle.getInstance(2, 5, 7);

        trianguloParametroDiferente1 = RightTriangle.getInstance(5, 4, 3);
        trianguloParametroDiferente2 = RightTriangle.getInstance(7, 3, 4);
    }


    @Test
    public void verificarIgualdadeDeInstanciasSemParametro(){
        Assertions.assertEquals(trianguloSemParametro1, trianguloSemParametro2);
    }

    @Test
    public void verificarIgualdadeDeInstanciasComParametrosIguais(){
        Assertions.assertEquals(trianguloParametroIgual1, trianguloParametroIgual2);
    }

    @Test
    public void verificarIgualdadeDeInstanciasComParametrosDiferentes(){
        Assertions.assertEquals(trianguloParametroDiferente1, trianguloParametroDiferente2);
    }

    @Test
    public void verificarIgualdadeDeAreaTrianguloSemParametro(){
        Assertions.assertEquals(trianguloSemParametro1,trianguloSemParametro2);
    }

    @Test
    public void verificarIgualdadeDeAreaTrianguloParametrosIguais(){
        Assertions.assertEquals(trianguloParametroIgual1, trianguloParametroIgual2);
    }

    @Test
    public void verificarIgualdadeDeAreaTrianguloParametrosDiferentes(){
        Assertions.assertEquals(trianguloParametroDiferente1, trianguloParametroDiferente2);
    }
}
