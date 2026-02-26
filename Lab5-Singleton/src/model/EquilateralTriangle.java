package aplicacao.model;

import interfaces.Triangle;

//caso fosse fazer em uma unica classe com 3 atributos de instancia(equilatero, retangulo e isoceles)
//não teria como separar se um triangulo é isoceles ou reto. paia
//
public class EquilateralTriangle implements Triangle {
    private double side;
    private static EquilateralTriangle instance =null;


    private EquilateralTriangle(){

    }

    private EquilateralTriangle(double value){
        this.side = value;
    }

    public static EquilateralTriangle getInstance(){
        if(instance ==null){
            instance = new EquilateralTriangle();

        }
        return instance;
    }

    public static EquilateralTriangle getInstance(double value){
        if(instance ==null){
            instance = new EquilateralTriangle(value);

        }
        return instance;
    }

    public double getArea(){
        //primeiro descobrir a altura por pitagoras (aconselho pesquisa)
        // Hiponenusa² = (cateto/2)² + cateto(altura)²
        //hipotenusa² - (cateto/2)² = altura²
        //Math.sqrt(hipotenusa² - (cateto/2)²) = altura
        double altura =Math.sqrt( Math.pow(side, 2)- Math.pow(side/2, 2));
        double area = (this.side * altura)/2;
        return area;
    }
}
