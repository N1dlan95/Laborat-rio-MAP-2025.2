package aplicacao.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import aplicacao.model.EquilateralTriangle;
import org.junit.jupiter.api.Test;

public class EquilateralTriangleTest {

    EquilateralTriangle trianguloSemParametro1;
    EquilateralTriangle trianguloSemParametro2;

    EquilateralTriangle trianguloParametroIgual1;
    EquilateralTriangle trianguloParametroIgual2;

    EquilateralTriangle trianguloParametroDiferente1;
    EquilateralTriangle trianguloParametroDiferente2;



    @BeforeEach
    public void setUp(){
        trianguloSemParametro1 = EquilateralTriangle.getInstance();
        trianguloSemParametro2 = EquilateralTriangle.getInstance();

        trianguloParametroIgual1 = EquilateralTriangle.getInstance(2);
        trianguloParametroIgual2 = EquilateralTriangle.getInstance(2);

        trianguloParametroDiferente1 = EquilateralTriangle.getInstance(5);
        trianguloParametroDiferente2 = EquilateralTriangle.getInstance(7);
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
