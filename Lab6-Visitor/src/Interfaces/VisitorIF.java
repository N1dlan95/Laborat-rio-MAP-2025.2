package Interfaces;

import Model.Circulo;
import Model.Retangulo;
import Model.Trapezio;
import Model.Triangulo;

public interface VisitorIF {

    void visitaCirculo(Circulo c);
    void visitaRetangulo(Retangulo r);
    void visitaTriangulo(Triangulo t);
    void visitaTrapezio(Trapezio tz);

}