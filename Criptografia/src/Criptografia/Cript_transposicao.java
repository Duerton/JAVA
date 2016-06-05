package Criptografia;

import java.util.Scanner;

public class Cript_transposicao {

    public static void main(String[] args) {
        boolean teste = true;
        Scanner teclado = new Scanner(System.in);
        while (teste) {
            System.out.println("Informe 1 para encriptar, 2 para decriptar, ou 0 para sair");
            int opcao = 0;
            try {
                opcao = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Opção não válida. Programa encerrado");
                opcao = 0;
            }
            if (opcao == 0) {
                break;
            } else if (opcao == 1 || opcao == 2) {
                Criptografia cript = new Criptografia();
                System.out.println("Informe a frase para criptografar ou decriptografar");
                String frase;
                teclado.nextLine();
                try {
                    frase = teclado.nextLine();
                } catch (Exception e) {
                    System.out.println("Opção não válida. Programa encerrado");
                    break;
                }
                System.out.println("Informe o valor para chave");
                int profundidade = 2;
                try {
                    profundidade = teclado.nextInt();
                } catch (Exception e) {
                    System.out.println("Opção não válida. Programa encerrado");
                    break;
                }
                char[] letras = frase.toCharArray();

                if (opcao == 1) {
                    letras = cript.criptografar(letras, profundidade);
                    for (int i = 0; i < letras.length; i++) {
                        if (letras[i] == ' ') {
                            System.out.print('|');
                        } else {
                            System.out.print(letras[i]);
                        }
                    }
                } else if (opcao == 2) {
                    letras = cript.decriptografar(letras, profundidade);
                    cript.impressao(letras);
                }
                System.out.println("");
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
