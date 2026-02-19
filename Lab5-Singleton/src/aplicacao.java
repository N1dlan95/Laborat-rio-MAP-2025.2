package aplicacao;

import model.CirculoSingleton;
import model.EquilateralTriangle;
import model.IsoscelesTriangle;
import model.RightTriangle;
import model.Quadrado;

public class aplicacao {

    public static void main(String[] args) {

        System.out.println("------ CIRCULO ------");
        CirculoSingleton c1 = CirculoSingleton.getInstance(5);
        CirculoSingleton c2 = CirculoSingleton.getInstance(10); // não cria outro

        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);
        System.out.println("É a mesma instância? " + (c1 == c2));


        System.out.println("\n------ TRIANGULO EQUILATERO ------");
        EquilateralTriangle t1 = EquilateralTriangle.getInstance(6);
        EquilateralTriangle t2 = EquilateralTriangle.getInstance(10);

        System.out.println("Área: " + t1.getArea());
        System.out.println("É a mesma instância? " + (t1 == t2));


        System.out.println("\n------ TRIANGULO ISÓSCELES ------");
        IsoscelesTriangle iso1 = IsoscelesTriangle.getInstance(5, 6);
        IsoscelesTriangle iso2 = IsoscelesTriangle.getInstance(8, 10);

        System.out.println("Área: " + iso1.getArea());
        System.out.println("É a mesma instância? " + (iso1 == iso2));


        System.out.println("\n------ TRIANGULO RETÂNGULO ------");
        RightTriangle r1 = RightTriangle.getInstance(3, 4, 5);
        RightTriangle r2 = RightTriangle.getInstance(6, 8, 10);

        System.out.println("Área: " + r1.getArea());
        System.out.println("É a mesma instância? " + (r1 == r2));


        System.out.println("\n------ QUADRADOS (MÚLTIPLAS INSTÂNCIAS) ------");
        Quadrado q1 = Quadrado.getInstance(4);
        Quadrado q2 = Quadrado.getInstance(7);
        Quadrado q3 = Quadrado.getInstance(10);

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
        System.out.println("q1 == q2 ? " + (q1 == q2));
        System.out.println("q2 == q3 ? " + (q2 == q3));
        System.out.println("q1 == q3 ? " + (q1 == q3));
    }
}
