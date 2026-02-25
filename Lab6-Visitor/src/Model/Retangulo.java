package Model;
import Interfaces.*;

public class Retangulo implements FigurasConcretas {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }

    public void aceitaVisitantes(VisitorIF visitante) {
        visitante.visitaRetangulo(this);
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
