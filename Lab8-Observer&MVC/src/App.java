
import controller.guicheController;
import model.Onibus;
import view.PainelDeControle;
import view.Quiosque;

public class App {
    public static void main(String[] args) {

        // MODEL
        Onibus onibus = new Onibus();

        // VIEWS (Observers)
        PainelDeControle painel = new PainelDeControle();
        Quiosque quiosque = new Quiosque("Quiosque 1");

        // Registrar observers
        onibus.addAssentoListener(painel);
        onibus.addAssentoListener(quiosque);

        // CONTROLLER
        guicheController guiche = new guicheController(onibus);

        System.out.println("---- SIMULAÇÃO DA RODOVIÁRIA ----");

        guiche.reservarAssento(5); //aqui vai reservar o assento 5 (amarelo)
        guiche.comprarAssento(10); //aqui vai comprar o assento 10 (vermelho)
        guiche.comprarAssento(5); //aqui vai comprar o assento 5 (vermelho)

        System.out.println("\n---- FIM DA SIMULAÇÃO ----");
    }
}