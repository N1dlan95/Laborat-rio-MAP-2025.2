package aplicacao.model;
import java.util.ArrayList;


public class Quadrado {
    private double side;
    private static int numInstances;
    private static ArrayList<Quadrado> instances = new ArrayList<>();


    private Quadrado(){

    }

    private Quadrado(double value){
        this.side = value;
    }

    public static Quadrado getInstance(){

        System.out.println("this class have now"+ numInstances+1 + "Instances");
        instances.add(new Quadrado());
        numInstances+=1;
        return instances.get(numInstances - 1);
    }

    public static Quadrado getInstance(double value){

        System.out.println("this class have now"+ numInstances+1 + "Instances");
        instances.add(new Quadrado(value));
        numInstances+=1;
            return instances.get(numInstances - 1);
    }

    public void setSide(double value){
        this.side = value;
    }

    public double getArea(){
        return this.side*this.side;
    }

    public double getPerimetro(){
        return this.side * 4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quadrado{");
        sb.append("side=").append(side);
        sb.append('}');
        return sb.toString();
    }
    
}
