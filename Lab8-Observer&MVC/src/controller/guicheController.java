package controller;

import model.Onibus;

/**
 * Guichê da rodoviária — Controller (MVC).
 * Recebe as ações do atendente e delega ao modelo (Onibus).
 */
public class guicheController {

    private Onibus onibus;

    public guicheController(Onibus onibus) {
        this.onibus = onibus;
    }

    /** Reserva uma poltrona para um cliente. */
    public void reservarAssento(int numero) {
        onibus.reservarAssento(numero);
    }

    /** Concretiza a venda de uma passagem para uma poltrona. */
    public void comprarAssento(int numero) {
        onibus.venderAssento(numero);
    }
}
