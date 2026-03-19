package src.FactoryMethods;

import src.ProdutosAbstratos.Ovo;
import src.ProdutosAbstratos.Pao;
import src.ProdutosAbstratos.Presunto;
import src.ProdutosAbstratos.Queijo;
import src.ProdutosConcretos.*;

public class SanduicheCompleto implements  Sanduiche{
    private Pao pao;
    private Presunto presunto;
    private Queijo queijo;
    private Ovo ovo;
    private Tomate tomate;

    public Pao adicionarPao() {
        this.pao =  new PaoFrances();

        return this.pao;
    }

    public Presunto adicionarPresunto() {
        this.presunto = new PresuntoFrango();

        return this.presunto;
    }

    public Queijo adicionarQueijo() {
        this.queijo = new QueijoMussarela();

        return this.queijo;
    }

    public Tomate adicionarTomate(){
        this.tomate = new Tomate();

        return this.tomate;
    }

    public Ovo adicionarOvo(){
        this.ovo = new OvoGranja();

        return this.ovo;
    }

    @Override
    public void montar(){
        this.adicionarPao();
        this.adicionarPresunto();
        this.adicionarQueijo();
        this.adicionarOvo();
        this.adicionarTomate();

        System.out.println("Esse sanduíche possui os seguintes ingredientes: " + this.pao.toString() + ", " + this.queijo.toString() + ", " + this.presunto.toString()
        + ", " + this.ovo.toString() + " e " + this.tomate.toString());
    }
}
