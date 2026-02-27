package testes;

import Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisitorMaximizadorTest {

    Circulo c;
    Retangulo r;
    Triangulo t;
    Trapezio tz;

    VisitorMaximizar visitorMaximizar;

    @BeforeEach
    public void setUp(){
        c = new Circulo(5);
        r = new Retangulo(4,6);
        t = new Triangulo(3,4);
        tz = new Trapezio(10,6,4);

        visitorMaximizar = new VisitorMaximizar();
    }

    @Test
    public void visitaMaximizarCirculoTeste(){
        double raioAntigo = c.getRaio();

        c.aceitaVisita(visitorMaximizar);

        Assertions.assertNotEquals(raioAntigo, c.getRaio());
    }

    @Test
    public void visitaMaximizarRetanguloTeste(){
        double alturaAntiga = r.getAltura();
        double larguraAntiga = r.getLargura();

        r.aceitaVisita(visitorMaximizar);

        Assertions.assertNotEquals(alturaAntiga, r.getAltura());
        Assertions.assertNotEquals(larguraAntiga, r.getLargura());
    }

    @Test
    public void visitaMaximizarTrianguloTeste(){
        double baseAntiga = t.getBase();
        double alturaAntiga = t.getAltura();

        t.aceitaVisita(visitorMaximizar);

        Assertions.assertNotEquals(baseAntiga, t.getBase());
        Assertions.assertNotEquals(alturaAntiga, t.getAltura());
    }

    @Test
    public void visitaMaximizarTrapezioTeste(){
        double baseMaiorAntiga = tz.getBaseMaior();
        double baseMenorAntiga = tz.getBaseMenor();
        double alturaAntiga = tz.getAltura();

        tz.aceitaVisita(visitorMaximizar);

        Assertions.assertNotEquals(baseMaiorAntiga, tz.getBaseMaior());
        Assertions.assertNotEquals(baseMenorAntiga, tz.getBaseMenor());
        Assertions.assertNotEquals(alturaAntiga, tz.getAltura());
    }
}
