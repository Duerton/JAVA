package Supermercado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class BD {

    private Map<String, Pessoa> listaFuncionarios = new HashMap();
    private Collection listaVendas = new ArrayList();
    
    //Map<Integer, Produto> estoque = new HashMap();
    public void salvarVenda(Venda venda){
        listaVendas.add(venda);
    }


    
    
    //métodos para Pessoas
    public void cadastrarPessoa(String nome, String login, String senha, int cargo) {
        Pessoa pessoa = new Funcionario(nome, login, senha, cargo);
        this.listaFuncionarios.put(login, pessoa);
    }

    public boolean confirmarLoginPessoa(Pessoa pessoa, String login, String senha) {
        if (login.equals(pessoa.login) && senha.equals(pessoa.senha)) {
            return true;
        }
        return false;
    }

    public boolean loginPessoa(String login, String senha) {
        Pessoa pessoa;
        if (listaFuncionarios.containsKey(login)) {
            pessoa = listaFuncionarios.get(login);
        } else {
            JOptionPane.showMessageDialog(null, "Login inexistente");
            return false;
        }
        if (pessoa.senha.equals(senha)) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Senha incorreta");
        return false;
    }

    public void cadastrarGerentePadrao() {
        Pessoa gerente = new Funcionario("Duerton", "duerton", "root", 1);
        gerente.setSenha("root");
        listaFuncionarios.put("Duerton", gerente);
    }

}
