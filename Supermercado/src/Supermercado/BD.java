package Supermercado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class BD {

    private Map<String, Funcionario> listaFuncionarios = new HashMap();
    private Collection listaVendas = new ArrayList();
    
    //Map<Integer, Produto> estoque = new HashMap();
    public void salvarVenda(Venda venda){
        listaVendas.add(venda);
    }


    
    
    //métodos para Pessoas
    public void cadastrarFuncionario(String nome, String login, String senha, int cargo) {
        Funcionario funcionario = new Funcionario(nome, login, senha, cargo);
        this.listaFuncionarios.put(login, funcionario);
    }
    
    public Funcionario getFuncionario(String login){
        return listaFuncionarios.get(login);
    }

    public boolean confirmarLoginFuncionario(String login) {
        if (listaFuncionarios.containsKey(login)) {
            return true;
        }
        return false;
    }

    public boolean loginFuncionario(String login, String senha) {
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
        Funcionario gerente = new Funcionario("Duerton", "duerton", "root", 1);
        gerente.setSenha("root");
        listaFuncionarios.put("Duerton", gerente);
    }

}
