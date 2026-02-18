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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.area = Math.PI*Math.pow(radius, 2);
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CirculoSingleton{");
        sb.append("radius=").append(radius);
        sb.append(", area=").append(area);
        sb.append('}');
        return sb.toString();
    }



    
}
