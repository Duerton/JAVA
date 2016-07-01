package Supermercado;

import java.text.DecimalFormat;

public abstract class Produto {

    protected static int codProd;
    protected float valorProd;
    private String nome;

    Produto(int codigo, float valor, String nome) {
        Produto.codProd = codigo;
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
    
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        return this.nome + " ......................................... R$" + df.format(this.valorProd);
    }

}
