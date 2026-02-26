package Interfaces;

import Model.Circulo;
import Model.Retangulo;
import Model.Trapezio;
import Model.Triangulo;

public interface VisitorIF {

    double visitaCirculo(Circulo c);
    double visitaRetangulo(Retangulo r);
    double visitaTriangulo(Triangulo t);
    double visitaTrapezio(Trapezio tz);

}