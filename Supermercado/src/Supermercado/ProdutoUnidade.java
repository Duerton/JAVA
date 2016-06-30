package Supermercado;

public class ProdutoUnidade extends Produto {

    private int quantProdUnid;

    public ProdutoUnidade(int codigo, float valor, String nome, String marca, String descricao) {
        super(codigo, valor, nome, marca, descricao);
    }

    public int contQuantProd() {
        return this.quantProdUnid;
    }

    public void inserirQuantProd(int quant) {
        this.quantProdUnid += quant;
    }

    public boolean retirarQuantProd(int quant) {
        if ((this.quantProdUnid - quant) < 0) {
            return false;
        } else {
            this.quantProdUnid -= quant;
            return true;
        }
    }
}
