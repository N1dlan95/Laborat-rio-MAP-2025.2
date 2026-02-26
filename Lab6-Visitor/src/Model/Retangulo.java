package Model;

import Interfaces.ElementoIF;
import Interfaces.VisitorIF;

public class Retangulo implements ElementoIF {

    private double largura, altura;

    public Retangulo(double largura, double altura){
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura(){ return largura; }
    public double getAltura(){ return altura; }

    public void setLargura(double largura){ this.largura = largura; }
    public void setAltura(double altura){ this.altura = altura; }

    public double aceitaVisita(VisitorIF v){
        return v.visitaRetangulo(this);
    }
}