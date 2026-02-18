package model;

import interfaces.Triangle;

public class RightTriangle implements Triangle{
    private double sideA,sideB,sideC;
    private static RightTriangle instance;

        private RightTriangle(){

    }

    private RightTriangle(double valueA, double valueB, double valueC){
        if((valueA+valueB >= valueC) &&(valueA+valueC >= valueB) && (valueC+valueB >= valueA)){
            //Tratamento de exceção para caso não seja possivel criar um triangulo com os valores
        }
        this.sideA = valueA;
        this.sideB = valueB;
        this.sideC = valueC;
    }

    public static RightTriangle getInstance(){
        if(instance ==null){
            instance = new RightTriangle();

        }
        return instance;
    }

    public static RightTriangle getInstance(double valueA, double valueB, double valueC){
        if(instance ==null){
            instance = new RightTriangle(valueA, valueB, valueC);
        }
        return instance;
    }

    public double getArea(){
        double area;
        if(Math.sqrt( Math.pow(sideA, 2)+ Math.pow(sideB, 2))==sideC){
            area = (this.sideA * this.sideB)/2; //hipotenusa é o lado C(utiliza apenas os catetos)
        }
        else if(Math.sqrt( Math.pow(sideA, 2)+ Math.pow(sideC, 2))==sideB){
            area = (this.sideA * this.sideC)/2; //hipotenusa é o lado B(utiliza apenas os catetos)
        }else{
            area = (this.sideC * this.sideB)/2; //hipotenusa é o lado A(utiliza apenas os catetos)
        
        }
        return area;
    }

    
}
