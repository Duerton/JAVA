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

    public void visualizacaoCliente(Cliente cliente, BD bd) {
        boolean teste = true;
        while (teste) {
            System.out.println(" ");
            System.out.println("Escolha a opção desejada");
            System.out.println("1- Detalhes da conta");
            System.out.println("2- Ingressos adquiridos");
            System.out.println("3- Comprar ingresso");
            System.out.println("4- Tela incial");
            System.out.println(" ");
            Scanner teclado = new Scanner(System.in);
            int opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Nome: "+cliente.getNome());
                    System.out.println("Login: "+cliente.getLogin());
                    System.out.println("Escolha uma opção");
                    System.out.println("1- Alterar nome");
                    System.out.println("2- Alterar senha");
                    System.out.println("3- Voltar");
                    System.out.println(" ");
                    opcao = teclado.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("Informe o novo nome");
                            String nome = teclado.next();
                            cliente.alterarNome(nome);
                            break;
                        case 2:
                            System.out.println("Informe a nova senha");
                            String senha = teclado.next();
                            cliente.alterarSenha(senha);
                            break;
                        case 3:

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
                    System.out.print("Informe o numero de registro do espetaculo que deseja comprar ingresso: ");
                    int numespetaculo = teclado.nextInt();
                    int quantpermitida;
                    Espetaculo espetaculo = bd.getEspetaculo(numespetaculo);
                    if (espetaculo.verificarDisponibilidadeAssentos()) {
                        int quantdisponivel1 = espetaculo.getQuantAssentosDisponiveis();
                        System.out.println("Há " + quantdisponivel1 + " ingressos disponiveis");
                        int quantdisponivel2 = 4 - cliente.verificarQuantIngresso(espetaculo);
                        if (quantdisponivel1 <= quantdisponivel2) {
                            quantpermitida = quantdisponivel1;
                        } else {
                            quantpermitida = quantdisponivel2;
                        }
                        if (quantpermitida > 0) {
                            System.out.println("Voce pode comprar no máximo " + quantpermitida + " ingressos para este evento");

                            System.out.print("Informe a quantidade de ingressos a serem comprados: ");
                            int quantingresso = teclado.nextInt();
                            if (quantingresso > quantpermitida) {
                                System.out.println("Não é possivel efetuar a compra com este total de ingressos");
                            } else {
                                Compra compra = new Compra(espetaculo, cliente, quantingresso);
                                System.out.println("Informe o nome exatamente como descrito no cartão de crédito");
                                teclado.nextLine();
                                String nomecartao = teclado.nextLine();
                                System.out.println("Informe o numero do cartão de crédito");
                                int numcartao = teclado.nextInt();
                                System.out.println("Informe a validade do cartão de crédito");
                                int validade = teclado.nextInt();
                                System.out.println("Informe o codigo do cartão de crédito");
                                int codigo = teclado.nextInt();
                                if (compra.conferirDadosCartao(nomecartao, numcartao, validade, codigo)) {
                                    espetaculo.atualizarQuantAssentos(quantingresso);
                                    bd.inserirCompra(compra.getIDCompra(), compra);
                                    cliente.inserirCompraCliente(compra);
                                    compra.imprimeCompra();
                                }
                            }
                        } else {
                            System.out.println("Voce já comprou o limite máximo de ingressos permitido para este evento");
                        }
                    } else {
                        System.out.println("Não há mais assentos disponiveis para este evento");
                    }

                    break;
                default:
                    teste = false;
                    break;
            }
        }
    }
}
