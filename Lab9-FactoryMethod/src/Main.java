package src;

import src.FactoryMethods.Sanduiche;
import src.FactoryMethods.SanduicheCompleto;
import src.FactoryMethods.SanduicheGourmet;
import src.FactoryMethods.SanduicheIntegral;

public class Main {

    public static void main(String [] args){

        System.out.println("COMEÇANDO A MONTAS OS SANDUICHES ");


        Sanduiche sanduiche1 = new SanduicheCompleto();
        Sanduiche sanduiche2 = new SanduicheGourmet();
        Sanduiche sanduiche3 = new SanduicheIntegral();


        System.out.println(sanduiche1.montar());
        System.out.println(sanduiche2.montar());
        System.out.println(sanduiche3.montar());
    }
}
