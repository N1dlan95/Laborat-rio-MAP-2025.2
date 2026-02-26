package Model;

import Interfaces.ElementoIF;
import Interfaces.VisitorIF;

public class Trapezio implements ElementoIF {

    private double baseMaior, baseMenor, altura;

    public Trapezio(double bMaior, double bMenor, double altura){
        this.baseMaior = bMaior;
        this.baseMenor = bMenor;
        this.altura = altura;
    }

    public double getBaseMaior(){ return baseMaior; }
    public double getBaseMenor(){ return baseMenor; }
    public double getAltura(){ return altura; }

    public void setBaseMaior(double b){ this.baseMaior = b; }
    public void setBaseMenor(double b){ this.baseMenor = b; }
    public void setAltura(double a){ this.altura = a; }

    public double aceitaVisita(VisitorIF v){
        return v.visitaTrapezio(this);
    }
}