
package Torneio;

public class Time implements Comparable<Time>{
    private String nome;
    private int pontos = 0;
    private int Totalgols = 0;
    
    public Time(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setTotalGols(int gols){
        this.Totalgols += gols;
    }
    
    public void setPontos(int pontos){
        this.pontos += pontos;
    }
    
     public int compareTo (Time time){
         if(this.pontos < time.pontos)
             return -1;
         if(this.pontos > time.pontos)
             return 1;
         return 0;
    }
}
