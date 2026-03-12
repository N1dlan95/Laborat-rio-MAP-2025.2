package view;

import event.AssentoEvent;
import event.AssentoListener;
import model.Assento;

/**
 * Quiosque espalhado pelo terminal — Observer.
 * Exibe a listagem numerada de cada poltrona e seu status.
 */
public class Quiosque implements AssentoListener {

    private String nome;

    public Quiosque(String nome) {
        this.nome = nome;
    }

    @Override
    public void assentoAtualizado(AssentoEvent event) {
        System.out.println("\n----- Quiosque: " + nome + " -----");
        System.out.printf("%-10s %-15s%n", "Assento", "Status");
        System.out.println("-".repeat(26));
        for (Assento a : event.getTodasPoltronas()) {
            System.out.printf("  %-8d %-15s%n", a.getNumIdentificador(), a.getStatus());
        }
        System.out.println("-".repeat(26));
    }
}
