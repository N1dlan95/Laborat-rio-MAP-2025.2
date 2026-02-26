package Model;

import Interfaces.VisitorIF;

public class VisitorMaximizar implements VisitorIF {
    @Override
    public double visitaCirculo(Circulo c) {
        c.setRaio(c.getRaio() * 2);

        System.out.println("O circulo foi maximizado, agora seu raio é: " + c.getRaio());

        return c.getRaio();
    }

    @Override
    public double visitaRetangulo(Retangulo r) {
        r.setAltura(r.getAltura() * 2);
        r.setLargura(r.getLargura() * 2);

        System.out.println("O retangulo foi maximizado, agora sua altura é: " + r.getAltura() + " e sua largura é: " + r.getLargura());

        return 0;
    }

    @Override
    public double visitaTriangulo(Triangulo t) {
        t.setAltura(t.getAltura() * 2);
        t.setBase(t.getBase() * 2);

        System.out.println("O triangulo foi maximizado, agora sua altura é: "+ t.getAltura() + " e sua base é: " + t.getBase());

        return 0;
    }

    @Override
    public double visitaTrapezio(Trapezio tz) {
        tz.setBaseMaior(tz.getBaseMaior() * 2);
        tz.setBaseMenor(tz.getBaseMenor() * 2);
        tz.setAltura(tz.getAltura() * 2);

        System.out.println("O trapézio foi maximizado, agora sua base maior é: " + tz.getBaseMaior() + " , sua base menor é: " + tz.getBaseMenor() + " e sua altura é: " + tz.getAltura());

        return 0;
    }
}
