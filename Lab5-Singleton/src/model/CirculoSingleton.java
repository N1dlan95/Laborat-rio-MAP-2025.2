package model;

public class CirculoSingleton {
    private static CirculoSingleton uniqueInstance = null;
    private double radius;
    private double area;


    private CirculoSingleton(){

    }

    private CirculoSingleton(double raio){
        this.radius = raio;
        this.area = Math.PI*Math.pow(raio, 2);

    }

    public static CirculoSingleton getInstance(){
        if(uniqueInstance ==null){
            uniqueInstance = new CirculoSingleton();
        }

        return uniqueInstance;
    }

public static CirculoSingleton getInstance(double raio){
        if(uniqueInstance ==null){
            uniqueInstance = new CirculoSingleton(raio);
        }

        return uniqueInstance;
    }
}
