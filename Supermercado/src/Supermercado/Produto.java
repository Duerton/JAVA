package Supermercado;

public abstract class Produto {

    protected static int codProd;
    protected float valorProd;
    private String nome;
    private String marca;
    private String descricao;

    Produto(int codigo, float valor, String nome, String marca, String descricao) {
        Produto.codProd = codigo;
        this.valorProd = valor;
        this.nome = nome;
        this.marca = marca;
        this.descricao = descricao;
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

    public String getMarca() {
        return this.marca;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
