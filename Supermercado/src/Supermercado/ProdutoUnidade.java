package Supermercado;

public class ProdutoUnidade extends Produto {

    private int quantProdUnid;

    public ProdutoUnidade(int codigo, float valor) {
        super(codigo, valor);
    }

    public int contQuantProd() {
        return this.quantProdUnid;
    }

    public void inserirQuantProd(int quant) {
        this.quantProdUnid += quant;
    }

    public int retirarQuantProd(int quant) {
        if ((this.quantProdUnid - quant) < 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
