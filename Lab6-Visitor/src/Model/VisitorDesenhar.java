package Model;

import Interfaces.VisitorIF;

public class VisitorDesenhar implements VisitorIF {

    public void visitaCirculo(Circulo c){
        System.out.println("Desenhando Círculo de raio " + c.getRaio());
    }

    public void visitaRetangulo(Retangulo r){
        System.out.println("Desenhando Retângulo " + r.getLargura() + " x " + r.getAltura());
    }

    public void visitaTriangulo(Triangulo t){
        System.out.println("Desenhando Triângulo base " + t.getBase() + " altura " + t.getAltura());
    }

    public void visitaTrapezio(Trapezio tz){
        System.out.println("Desenhando Trapézio bases " + tz.getBaseMaior() + " e " + tz.getBaseMenor());
    }
}