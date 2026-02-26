package Model;

import Interfaces.ElementoIF;
import Interfaces.VisitorIF;

public class Circulo implements ElementoIF {

    double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    public double getRaio(){
        return raio;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public void aceitaVisita(VisitorIF v){
        v.visitaCirculo(this);
    }
}
