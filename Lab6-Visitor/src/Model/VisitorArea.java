package Model;

import Interfaces.VisitorIF;

public class VisitorArea implements VisitorIF {

    public double visitaCirculo(Circulo c){
        return 3.14 * c.getRaio() * c.getRaio();
    }

    public double visitaRetangulo(Retangulo r){
        return r.getAltura() * r.getLargura();
    }

    public double visitaTriangulo(Triangulo t){
        return (t.getBase() * t.getAltura()) / 2;
    }

    public double visitaTrapezio(Trapezio tz){
        return ((tz.getBaseMaior() + tz.getBaseMenor()) * tz.getAltura()) / 2;
    }
}
