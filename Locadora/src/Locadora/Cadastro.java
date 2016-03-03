package Locadora;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cadastro {

    private static Integer numCadastro = 0;
    private Map<Integer, Usuario> cadastro = new HashMap();
    private Set<Midia> locacoes;

    public Integer getNumCadastro() {
        return Cadastro.numCadastro;
    }

    public void cadastrarUsuario(Usuario usuario) {
        Cadastro.numCadastro += 1;
        cadastro.put(numCadastro, usuario);
    }

    public boolean verificarCadastro(Integer num) {
        if (cadastro.containsKey(num)) {
            return true;
        }
        return false;
    }
    
    public void midiasLocadas(Midia midia){
        this.locacoes.add(midia);
    }
    
    public void midiasDevolvidas(Midia midia){
        this.locacoes.remove(midia);
    }

}
