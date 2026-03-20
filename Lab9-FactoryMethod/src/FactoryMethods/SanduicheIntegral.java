package src.FactoryMethods;

import src.ProdutosAbstratos.Pao;
import src.ProdutosAbstratos.Presunto;
import src.ProdutosAbstratos.Queijo;
import src.ProdutosConcretos.PaoIntegral;
import src.ProdutosConcretos.PresuntoPeru;
import src.ProdutosConcretos.QueijoPrato;

public class SanduicheIntegral implements Sanduiche{
    private Pao pao;
    private Presunto presunto;
    private Queijo queijo;

    public Pao adicionarPao() {
        this.pao =  new PaoIntegral();

        return this.pao;
    }


    public Presunto adicionarPresunto() {
        this.presunto =  new PresuntoPeru();

        return this.presunto;
    }


    public Queijo adicionarQueijo() {
        this.queijo = new QueijoPrato();

        return this.queijo;
    }

    @Override
    public String montar() {
        this.adicionarPao();
        this.adicionarPresunto();
        this.adicionarQueijo();

        return"Esse sanduiche possui os seguintes ingredientes: " + this.pao.toString() + ", " + this.presunto.toString() + " e "+
                this.queijo.toString();
    }
}
