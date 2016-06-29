package Supermercado;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class BD {

    Map<String, Pessoa> listaFuncionarios = new HashMap();
    Map<Integer, Produto> estoque = new HashMap();
    
    //Métodos para produtos
    public void inserirProdutoUnidade(Integer codigo, float valor, String nome, String marca, String descricao) {
        Produto produto = new ProdutoUnidade(codigo, valor, nome, marca, descricao);
        this.estoque.put(codigo, produto);
    }
    
    public Produto buscarProduto(Integer codigo){
        return estoque.get(codigo);        
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
