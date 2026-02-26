package testes;

import Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisitorAreaTest {

    Circulo c;
    Retangulo r;
    Triangulo t;
    Trapezio tz;

    VisitorArea visitorArea;

    double areaCirculo;
    double areaRetangulo;
    double areaTriangulo;
    double areaTrapezio;

    @BeforeEach
    public void setUp(){
        c = new Circulo(5);
        r = new Retangulo(4,6);
        t = new Triangulo(3,4);
        tz = new Trapezio(10,6,4);

        visitorArea = new VisitorArea();

        areaCirculo = 3.14 * (c.getRaio() * c.getRaio());
        areaRetangulo = r.getAltura() * r.getLargura();
        areaTriangulo = (t.getBase() * t.getAltura()) / 2;
        areaTrapezio = ((tz.getBaseMaior() + tz.getBaseMenor()) * tz.getAltura()) / 2;
    }

    @Test
    public void visitorAreaCirculoTeste(){
        Assertions.assertEquals(c.aceitaVisita(visitorArea), areaCirculo);
    }

    @Test
    public void visitorAreaRetanguloTeste(){
        Assertions.assertEquals(r.aceitaVisita(visitorArea), areaRetangulo);
    }

    @Test
    public void visitorAreaTrianguloTest(){
        Assertions.assertEquals(t.aceitaVisita(visitorArea), areaTriangulo);
    }

    @Test
    public void visitorAreaTrapezioTeste(){
        Assertions.assertEquals(tz.aceitaVisita(visitorArea), areaTrapezio);
    }

}
