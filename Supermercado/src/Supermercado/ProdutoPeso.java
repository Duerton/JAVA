package Supermercado;

public class ProdutoPeso extends Produto {

    private float quantProdPeso;

    ProdutoPeso(int codigo, float valor, String nome, String marca, String descricao) {
        super(codigo, valor, nome, marca, descricao);
    }
    
    public float contQuantProd() {
        return this.quantProdPeso;
    }

    public void inserirQuantProd(float quant) {
        this.quantProdPeso += quant;
    }

    public boolean retirarQuantProd(float quant) {
        if ((this.quantProdPeso - quant) < 0.0f) {
            return false;
        } else {
            this.quantProdPeso -= quant;
            return true;
        }
    }
}
