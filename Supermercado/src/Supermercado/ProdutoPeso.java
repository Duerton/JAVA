package Supermercado;

public class ProdutoPeso extends Produto {

    private float quantProdPeso;

    ProdutoPeso(int codigo, float valor) {
        super(codigo, valor);
    }

    public float contQuantProd() {
        return this.quantProdPeso;
    }

    public void inserirQuantProd(float quant) {
        this.quantProdPeso += quant;
    }

    public int retirarQuantProd(float quant) {
        if ((this.quantProdPeso - quant) < 0.0f) {
            return 0;
        } else {
            return 1;
        }
    }
}
