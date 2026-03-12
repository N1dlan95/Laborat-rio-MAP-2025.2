package view;

import event.AssentoEvent;
import event.AssentoListener;
import model.Assento;
import model.StatusAssento;

/**
 * Painel central da rodoviária — Observer.
 * Exibe a grade de poltronas colorida:
 *   Verde   = Disponível
 *   Amarelo = Reservado
 *   Vermelho = Vendido
 */
public class PainelDeControle implements AssentoListener {

    private static final String ANSI_RESET  = "\u001B[0m";
    private static final String ANSI_GREEN  = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED    = "\u001B[31m";
    private static final int COLUNAS = 4;

    @Override
    public void assentoAtualizado(AssentoEvent event) {
        Assento alterado = event.getAssentoAlterado();
        System.out.println("\n===== PAINEL CENTRAL DA RODOVIÁRIA =====");
        System.out.println("  Assento " + alterado.getNumIdentificador()
                + " atualizado → " + alterado.getStatus());
        System.out.println();

        Assento[] poltronas = event.getTodasPoltronas();
        for (int i = 0; i < poltronas.length; i++) {
            String cor = getColor(poltronas[i].getStatus());
            System.out.printf("%s[%2d]%s ", cor, poltronas[i].getNumIdentificador(), ANSI_RESET);
            if ((i + 1) % COLUNAS == 0) System.out.println();
        }
        System.out.println();
        System.out.println(ANSI_GREEN + "\u25A0" + ANSI_RESET + " Disponível  "
                + ANSI_YELLOW + "\u25A0" + ANSI_RESET + " Reservado  "
                + ANSI_RED    + "\u25A0" + ANSI_RESET + " Vendido");
        System.out.println("========================================");
    }

    private String getColor(StatusAssento status) {
        return switch (status) {
            case Disponivel -> ANSI_GREEN;
            case Reservado  -> ANSI_YELLOW;
            case Vendido    -> ANSI_RED;
        };
    }
}
