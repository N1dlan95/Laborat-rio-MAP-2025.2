import controller.guicheController;
import model.Onibus;
import view.PainelDeControle;
import view.Quiosque;

public class App {
    public static void main(String[] args) {

        // --- Montagem do sistema (wiring MVC + Observer) ---
        Onibus onibus = new Onibus();                       // Model / Source

        PainelDeControle painel    = new PainelDeControle();  // View / Observer
        Quiosque quiosque1         = new Quiosque("Terminal A"); // View / Observer
        Quiosque quiosque2         = new Quiosque("Terminal B"); // View / Observer

        // Registra os observers no source (Onibus)
        onibus.addAssentoListener(painel);
        onibus.addAssentoListener(quiosque1);
        onibus.addAssentoListener(quiosque2);

        guicheController guiche = new guicheController(onibus); // Controller

        // --- Cenários de teste ---

        System.out.println("\n>>> Cenário 1: Cliente reserva o assento 5");
        guiche.reservarAssento(5);

        System.out.println("\n>>> Cenário 2: Cliente compra o assento 12");
        guiche.comprarAssento(12);

        System.out.println("\n>>> Cenário 3: Cliente compra o assento que já estava reservado (5)");
        guiche.comprarAssento(5);

        System.out.println("\n>>> Cenário 4: Tentativa de reservar assento já vendido (12)");
        guiche.reservarAssento(12);

        System.out.println("\n>>> Cenário 5: Cliente compra o assento 48 (último)");
        guiche.comprarAssento(48);
    }
}
