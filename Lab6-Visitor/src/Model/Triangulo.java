package Model;
import Interfaces.*;

public class Triangulo implements FigurasConcretas {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }


    public void aceitaVisitantes(VisitorIF visitante) {
        visitante.visitaTriangulo(this);
    }

}
