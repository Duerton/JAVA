package Locadora;

import java.util.HashMap;
import java.util.Map;

public class Acervo {

    private Map<String, Midia> acervo = new HashMap();

    public Midia incluirAcervo(String nome, Midia midia) {
        return this.acervo.put(nome, midia);
    }

    public boolean retirarAcervo(String nome,Midia midia) {
        if (midia.getQuantidade() == 0) {
            return false;
        }
        midia.setQuantidade(-1);
        return true;
    }

    public Midia buscarAcervo(String nome) {
        return this.acervo.get(nome);
    }

    public Midia cadastrarFilme(String nome, int ano, int quant) {
        Midia filme = new Filme();
        filme.setNome(nome);
        filme.setAnoLancamento(ano);
        filme.setQuantidade(quant);
        this.incluirAcervo(nome, filme);
        return filme;
    }

    public Midia cadastrarJogos(String nome, int ano, int quant) {
        Midia jogo = new Jogos();
        jogo.setNome(nome);
        jogo.setAnoLancamento(ano);
        jogo.setQuantidade(quant);
        this.incluirAcervo(nome, jogo);
        return jogo;
    }
}
