package Model;

import Interfaces.ElementoIF;
import Interfaces.VisitorIF;

public class Triangulo implements ElementoIF {

    private double base, altura;

    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public double getBase(){ return base; }
    public double getAltura(){ return altura; }

    public void setBase(double base){ this.base = base; }
    public void setAltura(double altura){ this.altura = altura; }

    public double aceitaVisita(VisitorIF v){
        return v.visitaTriangulo(this);
    }
}