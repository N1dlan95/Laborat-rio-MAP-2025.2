package Model;

import Interfaces.VisitorIF;

public class VisitorMaximizarFigura implements VisitorIF {

    public double visitaCirculo(Circulo circulo) {
        return circulo.getRaio() * 2;
    }

    public double visitaRetangulo(Retangulo retangulo) {
        return 0.0;
        //implementar corretamente
    }

    public double visitaTriangulo(Triangulo triangulo) {
        return 2.5;//implementar a lógica para maximizar o triângulo, considerando a base e a altura.
    }

    public double visitaTrapezio(Trapezio trapezio) {
        trapezio.setBaseMaior(trapezio.getBaseMaior() * 2);
        trapezio.setBaseMenor(trapezio.getBaseMenor() * 2);
        trapezio.setLado1(trapezio.getLado1() * 2);
        trapezio.setLado2(trapezio.getLado2() * 2);

        return 0.0;
    }//oque deveria retornar aqui?

}
