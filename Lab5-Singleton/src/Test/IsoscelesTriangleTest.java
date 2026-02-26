package aplicacao.Test;

import aplicacao.model.IsoscelesTriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IsoscelesTriangleTest {

    IsoscelesTriangle trianguloSemParametro1;
    IsoscelesTriangle trianguloSemParametro2;

    IsoscelesTriangle trianguloParametroIgual1;
    IsoscelesTriangle trianguloParametroIgual2;

    IsoscelesTriangle trianguloParametroDiferente1;
    IsoscelesTriangle trianguloParametroDiferente2;



    @BeforeEach
    public void setUp(){
        trianguloSemParametro1 = IsoscelesTriangle.getInstance();
        trianguloSemParametro2 = IsoscelesTriangle.getInstance();

        trianguloParametroIgual1 = IsoscelesTriangle.getInstance(2, 5);
        trianguloParametroIgual2 = IsoscelesTriangle.getInstance(2, 5);

        trianguloParametroDiferente1 = IsoscelesTriangle.getInstance(5, 4);
        trianguloParametroDiferente2 = IsoscelesTriangle.getInstance(7, 3);
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
