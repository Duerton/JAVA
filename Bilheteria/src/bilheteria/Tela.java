/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilheteria;

import java.util.Scanner;

public class Tela {

    public void cadastrarCliente(BD bd) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        String nome = teclado.nextLine();
        System.out.println("Informe a idade: ");
        byte idade = teclado.nextByte();
        String login = "";
        boolean teste = true;
        while (teste) {
            System.out.println("Informe o login");
            login = teclado.next();
            if (!bd.confereLogin(login)) {
                teste = false;
            } else {
                System.out.println("Login já existente, informe um outro login");
            }
        }
        System.out.println("Informe a senha");
        String senha = teclado.next();
        Cliente cliente = new Cliente(nome, idade, login, senha);
        bd.inserirCliente(login, cliente);
    }

    public boolean loginCliente(Cliente cliente) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe a senha");
        String senha = teclado.next();
        if (cliente.confereSenha(senha)) {
            System.out.println("Senha incorreta");
        } else {
            return true;
        }
        return false;
    }

    public void visualizacaoCliente(Cliente cliente,BD bd) {
        boolean teste = true;
        while (teste) {
            System.out.println("Escolha uma opção");
            System.out.println("1- Detalhes da conta");
            System.out.println("2- Ingressos adquiridos");
            System.out.println("3- Comprar ingresso");
            System.out.println("4- Tela incial");
            Scanner teclado = new Scanner(System.in);
            int opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Escolha uma opção");
                    System.out.println("1- Alterar nome");
                    System.out.println("2- Alterar senha");
                    opcao = teclado.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("Informe a alteração do nome");
                            String nome = teclado.next();
                            cliente.alterarNome(nome);
                            break;
                        case 2:
                            System.out.println("Informe a alteração da senha");
                            String senha = teclado.next();
                            cliente.alterarNome(senha);
                            break;
                        default:
                            System.out.println("Opcao inválida");
                            break;
                    }
                    break;
                case 2:
                    cliente.visualizarEspetaculosComprados();
                    break;
                case 3:
                    System.out.println("Informe o numero de registro do espetaculo que deseja comprar ingresso: ");
                    int numespetaculo = teclado.nextInt();
                    System.out.println("Informe a quantidade de ingressos a serem comprados: ");
                    int quantingresso = teclado.nextInt();
                    cliente.verificarQuantIngresso(quantingresso, bd);
                    break;
                default:
                    teste = false;
                    break;
            }
        }
    }
}
