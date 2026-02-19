package aplicacao.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import aplicacao.model.Quadrado;
import org.junit.jupiter.api.Test;

public class QuadradoTest {

    Quadrado q1;
    Quadrado q2;

    Quadrado q3;
    Quadrado q4;

    Quadrado q5;
    Quadrado q6;
    @BeforeEach
    public void setUp(){
        q1 = Quadrado.getInstance();
        q2 = Quadrado.getInstance();

        q3 = Quadrado.getInstance(2);
        q4 = Quadrado.getInstance(2);

        q5 = Quadrado.getInstance(3);
        q6 = Quadrado.getInstance(7);
    }

    @Test
    public void verificarDiferencaDeInstanciasQuadradosSemParametro(){
        Assertions.assertNotEquals(q1,q2);
    }

    @Test
    public void verificarDiferencaDeInstanciasQuadradosParametrosIguais(){
        Assertions.assertNotEquals(q3,q4);
    }

    @Test
    public void verificarDiferencaDeInstancaisQuadradosParametrosDiferentes(){
        Assertions.assertNotEquals(q5,q6);
    }

    @Test
    public void verificarIgualdadeDePerimetrosQuadradoSemParametro(){
        Assertions.assertEquals(q1.getPerimetro(), q2.getPerimetro());
    }

    @Test
    public void verificarIgualdadeDePerimetrosQuadradoParametrosIguais(){
        Assertions.assertEquals(q3.getPerimetro(), q4.getPerimetro());
    }

    @Test
    public void verificarDiferencaDePerimetrosQuadradoParametroDiferentes(){
        Assertions.assertNotEquals(q5.getPerimetro(), q6.getPerimetro());
    }

    @Test
    public void verificarIgualdadeDeAreaQuadradosSemParametro(){
        Assertions.assertEquals(q1.getArea(), q2.getArea());
    }

    @Test
    public void verificarIgualdadeDeAreaQuadradosParametroIguais(){
        Assertions.assertEquals(q3.getArea(), q4.getArea());
    }

    @Test
    public void verificarDiferencaDeAreaQuadradosParametroDiferentes(){
        Assertions.assertNotEquals(q5.getArea(), q6.getArea());
    }
}
