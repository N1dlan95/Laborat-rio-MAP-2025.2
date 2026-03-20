package src.FactoryMethods;

import src.ProdutosAbstratos.Ovo;
import src.ProdutosAbstratos.Pao;
import src.ProdutosAbstratos.Presunto;
import src.ProdutosAbstratos.Queijo;
import src.ProdutosConcretos.OvoCapoeira;
import src.ProdutosConcretos.PaoBola;
import src.ProdutosConcretos.PresuntoPeru;
import src.ProdutosConcretos.QueijoCheddar;

public class SanduicheGourmet implements Sanduiche{

    private Pao pao;
    private Presunto presunto;
    private Queijo queijo;
    private Ovo ovo;

    public Pao adicionarPao() {
        this.pao = new PaoBola();

        return this.pao;
    }

    public Presunto adicionarPresunto() {
        this.presunto = new PresuntoPeru();

        return this.presunto;
    }

    public Queijo adicionarQueijo() {
        this.queijo = new QueijoCheddar();

        return this.queijo;
    }

    public Ovo adicionarOvo(){
        this.ovo = new OvoCapoeira();

        return this.ovo;
    }

    @Override
    public String montar() {
        this.adicionarPao();
        this.adicionarPresunto();
        this.adicionarQueijo();
        this.adicionarOvo();

        return "Esse sanduiche possui os seguintes ingredientes: " + this.pao.toString() + ", " + this.presunto.toString() +
                ", " + this.queijo.toString() + " e " + this.ovo.toString();
    }
}
