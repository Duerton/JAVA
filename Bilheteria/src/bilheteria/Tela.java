/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilheteria;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tela {

    public void telaInicial(BD bd) throws InputMismatchException {
        boolean teste = true;
        Scanner teclado = new Scanner(System.in);
        while (teste) {
            System.out.println(" ");
            System.out.println("Bem vindo a Bilheteria!");
            System.out.println("Veja abaixo os espetáculos disponiveis.");
            System.out.println("Para aquisição de ingresso é necessário estar logado.");
            System.out.println(" ");
            System.out.println("##########################");
            bd.visualizarTodosEspetaculos();
            System.out.println("1- Novo cadastro");
            System.out.println("2- Logar");
            System.out.println("3- Verificar espetaculos por cidade");
            System.out.println("4- Verificar espetaculos por data");
            System.out.println("5- Sair");
            int entrada = teclado.nextInt();
            switch (entrada) {
                case 1:
                    try {
                        this.cadastrarCliente(bd);
                    } catch (InputMismatchException e) {
                        System.out.println("Valor inválido");
                    }
                    break;
                case 2:
                    System.out.println("Informe o login");
                    String login = teclado.next();
                    if (bd.confereLogin(login)) {
                        Cliente cliente = bd.buscaCliente(login);
                        if (this.loginCliente(cliente)) {
                            try {
                                this.visualizacaoCliente(cliente, bd);
                            } catch (InputMismatchException e) {
                                System.out.println("Valor Inválido");
                            }
                        }
                    } else {
                        System.out.println("Login inexistente");
                    }
                    break;
                case 3:
                    System.out.println("Informe a cidade que deseja consultar");
                    teclado.nextLine();
                    String cidade = teclado.nextLine();
                    ArrayList cidadeEspetaculos = bd.buscarFilmesCidade(cidade);
                    if (cidadeEspetaculos == null) {
                        System.out.println("Não há espetaculos para esta cidade no momento");
                    } else {
                        bd.visualizarEspetaculos(cidadeEspetaculos);
                    }
                    break;
                case 4:
                    System.out.println("Informe a data no formato dd/MM/aaaa que deseja consultar");
                    String dataS = teclado.next();
                    Date data = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        data = sdf.parse(dataS);
                        ArrayList dataEspetaculos = bd.buscarFilmesData(data);
                        if (dataEspetaculos == null) {
                            System.out.println("Não há espetaculos para esta data no momento");
                        } else {
                            bd.visualizarEspetaculos(dataEspetaculos);
                        }
                    } catch (ParseException ex) {
                        System.out.println("Data inválida");
                    }
                    break;
                case 5:
                    System.out.println("Até a próxima");
                    teste = false;
                    break;
                default:
                    System.out.println("Opcao inválida");
                    break;
            }
        }
    }

    public void cadastrarCliente(BD bd) throws InputMismatchException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        String nome = teclado.nextLine();
        System.out.println("Informe a idade: ");
        boolean teste = false;
        int idade = teclado.nextInt();

        String login = "";
        teste = true;
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

    public void visualizacaoCliente(Cliente cliente, BD bd) throws InputMismatchException {
        boolean teste = true;
        while (teste) {
            System.out.println(" ");
            System.out.println("Escolha a opção desejada");
            System.out.println("1- Detalhes da conta");
            System.out.println("2- Compras efetuadas");
            System.out.println("3- Comprar ingresso");
            System.out.println("4- Tela incial");
            System.out.println(" ");
            Scanner teclado = new Scanner(System.in);
            int opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Login: " + cliente.getLogin());
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
                    int numespetaculo;
                    numespetaculo = teclado.nextInt();
                    int quantpermitida;
                    Espetaculo espetaculo;
                    espetaculo = bd.getEspetaculo(numespetaculo);

                    try {
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

                                    System.out.println("Informe para qual data no formato dd/MM/aaaa que deseja os ingressos");
                                    String dataS = teclado.next();
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    Date dataescolhida = new Date();
                                    try {
                                        dataescolhida = sdf.parse(dataS);
                                        if (espetaculo.verificarExibicao(dataescolhida)) {
                                            if (this.telaCartaoDeCredito()) {
                                                Compra compra = new Compra(espetaculo, cliente, quantingresso,dataescolhida);
                                                espetaculo.atualizarQuantAssentos(quantingresso);
                                                bd.inserirCompra(compra.getIDCompra(), compra);
                                                cliente.inserirCompraCliente(compra);
                                                compra.imprimeCompra();
                                            } else {
                                                System.out.println("Dados do Cartao de credito inválidos");
                                            }
                                        } else{
                                            System.out.println("Evento não disponivel para essa data");
                                        }
                                    } catch (ParseException ex) {
                                        System.out.println("Data Inválida");
                                    }
                                }
                            } else {
                                System.out.println("Voce já comprou o limite máximo de ingressos permitido para este evento");
                            }
                        } else {
                            System.out.println("Não há mais assentos disponiveis para este evento");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Número de espetaculo inexistente");
                        break;
                    }
                    break;
                case 4:
                    teste = false;
                    break;
                default:
                    System.out.println("Opcao inválida");
                    break;
            }
        }
    }

    public boolean telaCartaoDeCredito() {
        Scanner teclado = new Scanner(System.in);
        CartaoDeCredito cartao = new CartaoDeCredito();
        System.out.println("Informe o nome exatamente como descrito no cartão de crédito");
        String nomecartao = teclado.nextLine();
        System.out.println("Informe o numero do cartão de crédito");
        String numcartao = teclado.next();
        System.out.println("Informe a validade do cartão de crédito");
        String validade = teclado.next();
        System.out.println("Informe o codigo do cartão de crédito");
        String codigo = teclado.next();
        if (cartao.conferirDadosCartao(nomecartao, numcartao, validade, codigo)) {
            return true;
        }
        return false;
    }
}
