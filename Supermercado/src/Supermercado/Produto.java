package Supermercado;

import java.text.DecimalFormat;

public abstract class Produto {

    protected static int codProd = 0;
    protected float valorProd;
    private String nome;

    Produto(float valor, String nome) {
        Produto.codProd++;
        this.valorProd = valor;
        this.nome = nome;
    }

    public float getValorProd() {
        return this.valorProd;
    }

    public void setValorProd(float valor) {
        this.valorProd = valor;
    }

    public String getNome() {
        return this.nome;
    }
   
    public int getCodigo(){
        return this.codProd;
    }


}
