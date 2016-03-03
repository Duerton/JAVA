package Locadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Locacao {

    public static void main(String[] args) {
        Acervo acervo = new Acervo();
        Cadastro cadastro = new Cadastro();
        boolean verifica = true;

        while (verifica) {
            System.out.println("Infome a opção desejada");
            System.out.println("1- Cadastrar Midia");
            System.out.println("2- Cadastrar Usuario");
            System.out.println("3- Locacao");
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println("Informe o nome");
                String nome = sc.next();
                System.out.println("Infome data de lancamento");
                int data = sc.nextInt();
                System.out.println("Informe a quantidade de midias");
                int quant = sc.nextInt();
                acervo.cadastrarFilme(nome, data, quant);

            } else if (opcao == 2) {
                System.out.println("Informe o nome");
                String nome = sc.next();
                Usuario usuario = new Usuario(nome);
                cadastro.cadastrarUsuario(usuario);
                System.out.println("Seu numero de usuário é: " + cadastro.getNumCadastro());

            } else if (opcao == 3) {
                System.out.println("Informe o numero do cadastro");
                int num = sc.nextInt();
                if (cadastro.verificarCadastro(num)) {
                    System.out.println("Informe o nome da midia");
                    String nome = sc.next();
                    Midia midia = acervo.buscarAcervo(nome);
                    if (midia != null) {
                        if (acervo.retirarAcervo(nome, midia)) {
                            System.out.println("Midia alugada");
                        } else {
                            System.out.println("Não há mais midia no estoque");
                        }
                    }else
                        System.out.println("Midia não encontrada");
                }else
                    System.out.println("Cadastro não encontrado");
            } else {
                System.out.println("Esta não é uma opção válida");
            }

            System.out.println("Digite 0 para finalizar, ou qualquer outra tecla para continuar");
            try {
                int num = sc.nextInt();
                if (num == 0) {
                    verifica = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("");
            }

        }

    }

}
