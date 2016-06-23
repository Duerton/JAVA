package bilheteria;

import java.text.SimpleDateFormat;

public class Espetaculo {

    private String título, tipo, cidade, endereco, descricao;
    private static int totalID;
    private final int IDEspetaculo;
    private SimpleDateFormat data;
    private int quantTotalAssentos,quantAssentosDisponiveis;
    private float valoringresso;

    public Espetaculo(String titulo, String tipo, String cidade, String endereco, String descricao, float valoringresso, int quantTotalAssentos) {
        this.título = titulo;
        this.cidade = cidade;
        this.data = data;
        this.descricao = descricao;
        this.endereco = endereco;
        this.tipo = tipo;
        this.valoringresso = valoringresso;
        Espetaculo.totalID++;
        this.IDEspetaculo = totalID;
        this.quantTotalAssentos = quantTotalAssentos;
        quantAssentosDisponiveis = quantTotalAssentos;
    }
    
    public boolean verificarDisponibilidadeAssentos(){
        if(this.quantAssentosDisponiveis > 0){
            return true;
        }
        return false;
    }
    
    public int getQuantAssentosDisponiveis(){
        return quantAssentosDisponiveis;
    }
    
    public void atualizarQuantAssentos(int quant){
        this.quantAssentosDisponiveis = this.quantAssentosDisponiveis-quant;
    }

    public String getTitulo() {
        return this.título;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getTipo() {
        return this.tipo;
    }

    public float getValorIngresso() {
        return this.valoringresso;
    }

    public SimpleDateFormat getData() {
        return this.data;
    }

    public int getIDEspetaculo() {
        return this.IDEspetaculo;
    }
}
