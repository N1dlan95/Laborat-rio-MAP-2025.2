package Model;

import Interfaces.VisitorIF;

public class VisitorPerimetro implements VisitorIF {
    @Override
    public double visitaCirculo(Circulo c) {
        return 2 * 3.14 * c.getRaio();
    }

    @Override
    public double visitaRetangulo(Retangulo r) {
        return 2 * (r.getAltura() + r.getLargura());
    }

    @Override
    public double visitaTriangulo(Triangulo t) {
        return t.getBase() + t.getAltura() + Math.sqrt(Math.pow(t.getBase(),2)+ Math.pow(t.getAltura(),2));
    }

    @Override
    public double visitaTrapezio(Trapezio tz) {
        return tz.getBaseMaior() + tz.getBaseMenor() + 2 * tz.getAltura();
    }
}
