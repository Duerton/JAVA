package Supermercado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JButton;

public class main {

    public static void main(String[] args) {
        BD bd = new BD();
        TelaLogin telalogin = new TelaLogin();
        bd.inserirProdutoUnidade(001, 10.00f, "Feijão", "Combrasil", "Feijão Tipo 1");
        bd.cadastrarGerentePadrao();
        telalogin.montarTelaLogin(bd);

        /*boolean teste = true;
        Map<Integer, Funcionario> listaFuncionarios = new HashMap();
        Map<Integer, Gerente> listaGerente = new HashMap();
        Telas tela = new Telas();
        Scanner teclado = new Scanner(System.in);
        while (teste) {
            Funcionario funcionario = tela.cadastrarPessoa();
            listaFuncionarios.put(funcionario.getIDFunc(), funcionario);
            System.out.println("Funcionario " + funcionario.getNome() + " possui id: " + funcionario.getIDFunc());

            System.out.println("1 - Informe o id");
            Integer id = teclado.nextInt();
            if (listaGerente.containsKey(id)) {
                if (tela.loginPessoa(listaGerente.get(id))) {
                    //tela gerente
                }
            } else if (listaFuncionarios.containsKey(id)) {
                System.out.println("Informe o login");
                String login1 = teclado.next();
                System.out.println("Informe a senha");
                String senha = teclado.next();
                if (tela.loginPessoa(listaFuncionarios.get(id))) {
                    // tela funcionario
                }
            } else {
                System.out.println("Login inexistente");
            }
            /*System.out.println("1 - Cadastrar Funcionário");
            System.out.println("Informe o nome do Funcionario: ");
            String nome = teclado.next();            
            Funcionario funcionario = new Funcionario(nome);
            listaFuncionarios.put(funcionario.getIDFunc(),funcionario);
            System.out.println("Funcionario "+funcionario.getNome()+" possui id: "+funcionario.getIDFunc());
             

            System.out.println("");

            System.out.println("parar = 0");
            int para = teclado.nextInt();
            if (para == 0) {
                teste = false;
            }

        }
        /*System.out.println("2 - Cadastrar Gerente");
            System.out.println("3 - Inserir no estoque");
            System.out.println("4 - Efetuar venda");
            System.out.println("5 - Verificar Preço");
            System.out.println("6 - Relatórios");
            ;
            System.out.println("7 - Sair");
            
        


        System.out.println("");*/
    }

}
