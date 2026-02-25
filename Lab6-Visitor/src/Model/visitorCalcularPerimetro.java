package Model;
import Interfaces.VisitorIF;

public class visitorCalcularPerimetro implements VisitorIF {
    public double visitaCirculo(Circulo circulo) {
        return 2 * Math.PI * circulo.getRaio();
    }
    public double visitaRetangulo(Retangulo retangulo) {
        return 2 * (retangulo.getLargura() + retangulo.getAltura());
    }
    public double visitaTriangulo(Triangulo triangulo) {
        return triangulo.getLado1() + triangulo.getLado2() + triangulo.getLado3();
    }
    public double visitaTrapezio(Trapezio trapezio) {
        return trapezio.getBaseMaior() + trapezio.getBaseMenor() + trapezio.getLado1() + trapezio.getLado2();
    }

}
