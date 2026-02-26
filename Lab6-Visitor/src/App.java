import Interfaces.ElementoIF;
import Interfaces.VisitorIF;
import Model.*;


public class App {

    public static void main(String[] args) {

        ElementoIF c = new Circulo(5);
        ElementoIF r = new Retangulo(4,6);
        ElementoIF t = new Triangulo(3,4);
        ElementoIF tz = new Trapezio(10,6,4);

        VisitorIF desenhar = new VisitorDesenhar();
        VisitorIF area = new VisitorArea();
        VisitorIF perimetro = new VisitorPerimetro();
        VisitorIF maximizar = new VisitorMaximizar();

        ElementoIF[] figuras = {c,r,t,tz};

        for(ElementoIF f : figuras){
            f.aceitaVisita(desenhar);
            f.aceitaVisita(area);
            f.aceitaVisita(perimetro);
            f.aceitaVisita(maximizar);
            f.aceitaVisita(area);
            System.out.println("-----");
        }
    }
}