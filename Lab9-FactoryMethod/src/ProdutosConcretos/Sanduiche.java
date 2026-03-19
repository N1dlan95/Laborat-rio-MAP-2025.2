package src.ProdutosConcretos;

import src.ProdutosAbstratos.Ovo;
import src.ProdutosAbstratos.Pao;
import src.ProdutosAbstratos.Presunto;
import src.ProdutosAbstratos.Queijo;

public class Sanduiche {
    private Pao pao;
    private Queijo queijo;
    private Presunto presunto;
    private Ovo ovo;
    private Tomate tomate;

    public void setPao(Pao pao) {
        this.pao = pao;
    }

    public void setQueijo(Queijo queijo) {
        this.queijo = queijo;
    }

    public void setPresunto(Presunto presunto) {
        this.presunto = presunto;
    }

    public void setOvo(Ovo ovo) {
        this.ovo = ovo;
    }

    public void setTomate(Tomate tomate) {
        this.tomate = tomate;
    }

    @Override
    public String toString() {
        return "Sanduíche com " + pao +
                ", " + queijo +
                ", " + presunto +
                ", " + ovo +
                " e " + tomate + ".";
    }
}