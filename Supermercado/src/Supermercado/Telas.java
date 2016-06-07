package Supermercado;

import java.util.Scanner;

public class Telas {

    public Funcionario cadastrarPessoa() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome do Funcionario: ");
        String nome = teclado.next();
        Funcionario funcionario = new Funcionario(nome);
        System.out.println("Informe o login");
        String login = teclado.next();
        funcionario.setLogin(login);
        System.out.println("Informe a senha");
        String senha = teclado.next();
        funcionario.setSenha(senha);
        return funcionario;
    }

    public boolean loginPessoa(Pessoa pessoa) {
        Scanner teclado = new Scanner (System.in);
        System.out.println("Informe o login");
        String login = teclado.next();
        System.out.println("Informe a senha");
        String senha = teclado.next();
        if (!login.equals(pessoa.login)) {
            System.out.println("Login inexistente");
        } else if (!senha.equals(pessoa.senha)) {
            System.out.println("Senha incorreta");
        } else {
            return true;
        }
        return false;
    }

}
