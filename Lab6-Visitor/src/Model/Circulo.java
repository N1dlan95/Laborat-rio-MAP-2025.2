package Model;
import Interfaces.*;

public class Circulo implements FigurasConcretas {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void aceitaVisitantes(VisitorIF visitante) {
        visitante.visitaCirculo(this);
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}
