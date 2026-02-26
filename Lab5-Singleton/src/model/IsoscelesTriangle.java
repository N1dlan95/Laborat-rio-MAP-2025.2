package aplicacao.model;

import interfaces.Triangle;

public class IsoscelesTriangle implements Triangle{
    private double sideAB;
    private double sideC;
    private static IsoscelesTriangle instance =null;


    private IsoscelesTriangle(){

    }

    private IsoscelesTriangle(double valueAB, double valueC){//Tratamento de exceção AQUI
        if(valueAB*2 >= valueC){
            //Tratamento de exceção para caso não seja possivel criar um triangulo com os valores
        }
        this.sideAB = valueAB;
        this.sideC = valueC;
    }

    public static IsoscelesTriangle getInstance(){
        if(instance ==null){
            instance = new IsoscelesTriangle();

        }
        return instance;
    }

    public static IsoscelesTriangle getInstance(double valueAB, double valueC){
        if(instance ==null){
            instance = new IsoscelesTriangle(valueAB, valueC);

        }
        return instance;
    }

    public double getArea(){
        //primeiro descobrir a altura por pitagoras (aconselho pesquisa)
        // Hiponenusa² = (cateto/2)² + cateto(altura)²
        //hipotenusa² - (cateto/2)² = altura²
        //Math.sqrt(hipotenusa² - (cateto/2)²) = altura
        double altura =Math.sqrt( Math.pow(sideAB, 2)- Math.pow(sideC/2, 2));
        double area = (this.sideC * altura)/2;
        return area;
    }
}
