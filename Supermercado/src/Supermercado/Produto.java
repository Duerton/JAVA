package Supermercado;

public abstract class Produto {

    protected static int codProd;
    protected float valorProd;


    Produto(int codigo, float valor) {
        Produto.codProd = codigo;
        this.valorProd = valor;
    }

    public float getValorProd() {
        return this.valorProd;
    }

    public void setValorProd(float valor) {
        this.valorProd = valor;
    }

}
