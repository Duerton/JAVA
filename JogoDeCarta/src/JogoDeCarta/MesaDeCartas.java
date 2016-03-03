
package JogoDeCarta;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MesaDeCartas {
    private RegraGeral regraDoJogo = null;
    private List baralho1 = null;
    private List baralho2 = null;
    private int atri1;
    private int atri2;
    
    public MesaDeCartas (Regra regra){
        this.baralho1 = new Baralho();
        this.baralho2 = new Baralho();
    }
    
    public Resultado comparaAtributos(int x, int y){
           if (x > y)
               return Resultado.GANHOU;
           else if (x < y)
               return Resultado.PERDEU;
           else
               return Resultado.CONTINUA;
    }
    
    public int escolhaAtributo(String atr, Carta carta){
        switch(atr){
                case "forca":
                    return carta.getForca();
                case "inteligencia":
                    return carta.getInteligencia();    
                case "destreza":
                    return carta.getDestreza();
                case "sorte":
                    return carta.getSorte();
                default:
                    return 0;
            }
    }
    
    public void atualizarBaralho(List baralho, Carta carta1, Carta carta2){
        baralho.add(carta1);
        baralho.add(carta2);
    }
}
