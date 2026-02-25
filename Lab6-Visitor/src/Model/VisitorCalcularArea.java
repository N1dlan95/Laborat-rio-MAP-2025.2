package Model;
import Interfaces.VisitorIF;

public class VisitorCalcularArea implements VisitorIF {

  
    public double visitaCirculo(Circulo circulo) {
        return Math.PI * Math.pow(circulo.getRaio(), 2);
    }

    public double visitaRetangulo(Retangulo retangulo) {
        return retangulo.getLargura() * retangulo.getAltura();
    }

 
    public double visitaTriangulo(Triangulo triangulo) {
        double s = (triangulo.getLado1() + triangulo.getLado2() + triangulo.getLado3()) / 2;
        return Math.sqrt(s * (s - triangulo.getLado1()) * (s - triangulo.getLado2()) * (s - triangulo.getLado3()));
    }

    public double visitaTrapezio(Trapezio trapezio) {
        return ((trapezio.getBaseMaior() + trapezio.getBaseMenor()) / 2) * trapezio.getAltura();
    }

}
