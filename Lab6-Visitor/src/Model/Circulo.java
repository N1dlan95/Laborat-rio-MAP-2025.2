package Model;

import Interfaces.ElementoIF;
import Interfaces.VisitorIF;

public class Circulo implements ElementoIF {

    private double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    public double getRaio(){
        return raio;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public double aceitaVisita(VisitorIF v){
         return v.visitaCirculo(this);
    }
}
