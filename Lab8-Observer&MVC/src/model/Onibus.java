package model;

import event.AssentoEvent;
import event.AssentoListener;
import java.util.ArrayList;
import java.util.List;

public class Onibus {
    private Assento[] poltronas = new Assento[48];
    private List<AssentoListener> listeners = new ArrayList<>();

    public Onibus() {
        for (int i = 0; i < poltronas.length; i++) {
            poltronas[i] = new Assento(i + 1);
        }
    }

    // --- Gerenciamento de listeners (Source do Observer) ---

    public void addAssentoListener(AssentoListener listener) {
        listeners.add(listener);
    }

    public void removeAssentoListener(AssentoListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(Assento assentoAlterado) {
        AssentoEvent event = new AssentoEvent(this, assentoAlterado, poltronas);
        for (AssentoListener listener : listeners) {
            listener.assentoAtualizado(event);
        }
    }

    // --- Operações de negócio ---

    public void reservarAssento(int numero) {
        validarNumero(numero);
        Assento assento = poltronas[numero - 1];
        if (assento.getStatus() != StatusAssento.Disponivel) {
            System.out.println("  [!] Assento " + numero + " não está disponível para reserva (status: " + assento.getStatus() + ").");
            return;
        }
        assento.setStatus(StatusAssento.Reservado);
        notifyListeners(assento);
    }

    public void venderAssento(int numero) {
        validarNumero(numero);
        Assento assento = poltronas[numero - 1];
        if (assento.getStatus() == StatusAssento.Vendido) {
            System.out.println("  [!] Assento " + numero + " já está vendido.");
            return;
        }
        assento.setStatus(StatusAssento.Vendido);
        notifyListeners(assento);
    }

    private void validarNumero(int numero) {
        if (numero < 1 || numero > poltronas.length) {
            throw new IllegalArgumentException("Número de assento inválido: " + numero);
        }
    }

    public Assento[] getPoltronas() {
        return poltronas;
    }
}
