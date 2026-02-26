package testes;

import Interfaces.ElementoIF;
import Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisitorPerimetroTest {

    Circulo c;
    Retangulo r;
    Triangulo t;
    Trapezio tz;

    VisitorPerimetro visitorPerimetro;

    double perimetroCirculo;
    double perimetroRetangulo;
    double perimetroTriangulo;
    double perimetroTrapezio;


    @BeforeEach
    public void setUp(){

        c = new Circulo(5);
        r = new Retangulo(4,6);
        t = new Triangulo(3,4);
        tz = new Trapezio(10,6,4);
        visitorPerimetro = new VisitorPerimetro();

        perimetroCirculo = 2 * 3.14 * c.getRaio();
        perimetroRetangulo = 2 * (r.getAltura() + r.getLargura());
        perimetroTriangulo = t.getBase() + t.getAltura() + Math.sqrt(Math.pow(t.getBase(),2)+ Math.pow(t.getAltura(),2));
        perimetroTrapezio = tz.getBaseMaior() + tz.getBaseMenor() + 2 * tz.getAltura();

    }

    @Test
    public void visitaPerimetroCirculoTeste(){
        Assertions.assertEquals(c.aceitaVisita(visitorPerimetro),perimetroCirculo);
    }

    @Test
    public void visitaPerimetroRetangulo(){
        Assertions.assertEquals(r.aceitaVisita(visitorPerimetro), perimetroRetangulo);
    }

    @Test
    public void visitaPerimetroTriangulo(){
        Assertions.assertEquals(t.aceitaVisita(visitorPerimetro), perimetroTriangulo);
    }

    @Test
    public void visitaPerimetroTrapezio(){
        Assertions.assertEquals(tz.aceitaVisita(visitorPerimetro), perimetroTrapezio);
    }
}
