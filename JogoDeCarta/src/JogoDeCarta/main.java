
package JogoDeCarta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main (String[]args){
        Regra regra = new Regra();
        MesaDeCartas mesadecartas = new MesaDeCartas(regra);
        List baralho1 = new ArrayList();
        List baralho2 = new ArrayList();
        Carta heroi1 = new Carta();
        Carta heroi2 = new Carta();
        Carta heroi3 = new Carta();
        Carta heroi4 = new Carta();
        heroi1.atributosCarta(1000,20,30,40);
        heroi2.atributosCarta(100,200,300,40000);
        heroi3.atributosCarta(10,2000,3000,4000);
        heroi4.atributosCarta(10000,20000,30000,400);

        baralho1.add(heroi1);
        baralho1.add(heroi2);
        baralho2.add(heroi3);
        baralho2.add(heroi4);
        
        boolean teste = true;
        int atributo1 = 0;
        int atributo2 = 0;
        
        while (teste){
            Scanner entrada = new Scanner(System.in);
            String escolha;
            System.out.println("Escolha um atributo");
            escolha = entrada.next();

            Carta carta1 = (Carta) baralho1.get(0);
            baralho1.remove(0);
            Carta carta2 = (Carta) baralho2.get(0);
            baralho2.remove(0);
            atributo1 = mesadecartas.escolhaAtributo(escolha, carta1);
            atributo2 = mesadecartas.escolhaAtributo(escolha, carta2);
            
            System.out.println("" +atributo1);
            System.out.println("" +atributo2);
            Resultado aux = mesadecartas.comparaAtributos(atributo1, atributo2);
            System.out.println("" + aux);
            
            if( aux == Resultado.GANHOU)
                mesadecartas.atualizarBaralho(baralho1, carta1, carta2);
            else if(aux == Resultado.PERDEU)
                mesadecartas.atualizarBaralho(baralho2, carta1, carta2);


            if(baralho1.isEmpty())
            {
                System.out.println("PC ganhou");
                teste = false;
                System.exit(0);
            }

            if(baralho2.isEmpty())
            {
                System.out.println("Voce ganhou");
                teste = false;
                System.exit(0);
            }
                                
        }    

    }

}

