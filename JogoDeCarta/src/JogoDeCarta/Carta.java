
package JogoDeCarta;

public class Carta {
    private int forca;
    private int inteligencia;
    private int destreza;
    private int sorte;
    
    public int getForca() {
        return this.forca;
    }
    
    public int getInteligencia() {
        return this.inteligencia;
    }

    public int getDestreza() {
        return this.destreza;
    }

    public int getSorte() {
        return this.sorte;
    }
    
    public void setForca(int forca){
        this.forca = forca;
    }
    
    public void setInteligencia(int inteligencia){
        this.forca = inteligencia;
    }
    
    public void setDestreza(int destreza){
        this.forca = destreza;
    }
        
    public void setSorte(int sorte){
        this.forca = sorte;
    }
    
    public void atributosCarta(int forca, int inteligencia, int destreza, int sorte){
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.destreza = destreza;
        this.sorte = sorte;
    }
}
