package Model;
import Interfaces.VisitorIF;

public class VisitorDesenhar implements VisitorIF {

    public double visitaCirculo(Circulo circulo) {
        System.out.println("Desenhando um círculo com raio: " + circulo.getRaio());
        return 0;
    }

    public double visitaRetangulo(Retangulo retangulo) {
        System.out.println("Desenhando um retângulo com largura: " + retangulo.getLargura() + " e altura: " + retangulo.getAltura());
        return 0;
    }

    public double visitaTriangulo(Triangulo triangulo) {
        System.out.println("Desenhando um triângulo com lados: " + triangulo.getLado1() + ", " + triangulo.getLado2() + ", " + triangulo.getLado3());
        return 0;
    }

    public double visitaTrapezio(Trapezio trapezio) {
        System.out.println("Desenhando um trapézio com base maior: " + trapezio.getBaseMaior() + ", base menor: " + trapezio.getBaseMenor() + ", lado 1: " + trapezio.getLado1() + ", lado 2: " + trapezio.getLado2());
        return 0;
    }

}
