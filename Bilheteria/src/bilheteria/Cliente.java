package bilheteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Cliente {

    private String senha, login, nome;
    private int idade;
    private Collection<Compra> totalcompras = new HashSet();

    public Cliente(String nome, int idade, String login, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return this.login;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean confereSenha(String senha) {
        if (this.senha.equals(senha)) {
            return false;
        }
        return true;
    }

    public void alterarNome(String nome) {
        this.nome = nome;
    }

    public void alterarSenha(String senha) {
        this.senha = senha;
    }
    
    public int verificarQuantIngresso(int quant, BD bd){
        int quantidade = 0;
        for(Compra compra : totalcompras){
            if(compra.getEspetaculo().getIDEspetaculo()){
                quantidade += compra.getQuantidade();
            }
        }
        return quantidade;
    }

    public void visualizarEspetaculosComprados() {
        for (Compra compra : totalcompras) {
            System.out.println("Registro: " + compra.getEspetaculo().getIDEspetaculo());
            System.out.println("Titulo: " + compra.getEspetaculo().getTitulo());
            System.out.println("Descrição: " + compra.getEspetaculo().getDescricao());
            System.out.println("Titulo: " + compra.getEspetaculo().getTipo());
            System.out.println("Cidade: " + compra.getEspetaculo().getCidade());
            System.out.println("Endereco: " + compra.getEspetaculo().getEndereco());
            System.out.println("###################");
        }
    }
}
