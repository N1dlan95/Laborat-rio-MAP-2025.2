package Model;

import Interfaces.VisitorIF;

public class VisitorArea implements VisitorIF {

    public void visitaCirculo(Circulo c){
        double area = 3.14 * c.getRaio() * c.getRaio();
        System.out.println("Área do círculo: " + area);
    }

    public void visitaRetangulo(Retangulo r){
        double area = r.getAltura() * r.getLargura();
        System.out.println("Área do retângulo: " + area);
    }

    public void visitaTriangulo(Triangulo t){
        double area = (t.getBase() * t.getAltura()) / 2;
        System.out.println("Área do triângulo: " + area);
    }

    public void visitaTrapezio(Trapezio tz){
        double area = ((tz.getBaseMaior() + tz.getBaseMenor()) * tz.getAltura()) / 2;
        System.out.println("Área do trapézio: " + area);
    }
}
