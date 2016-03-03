package JogoDeCarta;

import java.util.ArrayList;
import java.util.List;

public class Baralho extends ArrayList {
    
    public Baralho criarBaralho(){
        List novo = new ArrayList();
        return (Baralho) novo;
    }

    public void inserirBaralho(List baralho, Carta carta) {
        baralho.add(carta);
    }

    public void excluirDoBaralho(List baralho, Carta carta) {
        baralho.remove(0);
    }

    public void atualizarBaralho(List baralho, Carta carta1, Carta carta2) {
        baralho.add(carta1);
        baralho.add(carta2);
    }
}
