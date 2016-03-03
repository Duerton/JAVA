
package Locadora;

public abstract class Midia {
    private String nome;
    private int anoLancamento;
    private int quantidade = 0;
    
    
    public String getNome(){
        return this.nome;
    }
    
    public int getAnoLancamento(){
        return this.anoLancamento;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setAnoLancamento(int ano){
        this.anoLancamento = ano;
    }
    
    public void setQuantidade(int quant){
        this.quantidade += quant;
    }

}
