
package Torneio;
public class Regra extends RegraGeral{
    
    public void pontuacaoJogo(Resultado resultado, Time time){
        if(resultado == Resultado.GANHOU)
            time.setPontos(3);
        else if(resultado == Resultado.EMPATOU)
            time.setPontos(1);
        else
            time.setPontos(0);
    }
}
