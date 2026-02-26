package Model;

import Interfaces.VisitorIF;

public class VisitorDesenhar implements VisitorIF {

    public double visitaCirculo(Circulo c){
       System.out.println("Desenhando um circulo de raio: " + c.getRaio());

       return 0;
    }

    public double visitaRetangulo(Retangulo r){
        System.out.println("Desenhando um retangulo de altura: " + r.getAltura() + " e de largura: " + r.getLargura());

        return 0;
    }

    public double visitaTriangulo(Triangulo t){
        System.out.println("Desenhando Triângulo base " + t.getBase() + " altura " + t.getAltura());

        return 0;
    }

    public double visitaTrapezio(Trapezio tz){
        System.out.println("Desenhando Trapézio bases " + tz.getBaseMaior() + " e " + tz.getBaseMenor());

        return 0;
    }
}