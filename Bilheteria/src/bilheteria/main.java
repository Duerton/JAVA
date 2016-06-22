package bilheteria;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        boolean teste = true;
        BD bd = new BD();
        Tela telas = new Tela();
        Scanner teclado = new Scanner(System.in);
        
        
        Espetaculo espetaculo1 = new Espetaculo("Matriz", "Ficçao", "Niterói", "Na esquina", "Futurista", 20.00f);
        Espetaculo espetaculo2 = new Espetaculo("Rei Leão", "Infantil", "São Gonçalo", "Outra esquina", "Animação", 15.00f);
        bd.inserirEspetaculos(espetaculo1);
        bd.inserirEspetaculos(espetaculo2);
        
        Cliente auxiliar = new Cliente("duerton", 30, "duerton", "root");
        bd.inserirCliente("duerton", auxiliar);
        
        
        while (teste) {
            System.out.println("Bem vindo a Bilheteria");
            System.out.println("Veja abaixo os espetáculos disponiveis");
            System.out.println("Para aquisição de ingresso é necessário estar logado");
            bd.visualizarEspetaculos();
            System.out.println("##########################");
            System.out.println("1- Novo cadastro");
            System.out.println("2- Logar");
            System.out.println("3- Sair");
            int entrada = teclado.nextInt();
            switch (entrada) {
                case 1:
                    telas.cadastrarCliente(bd);
                    break;
                case 2:
                    System.out.println("Informe o login");
                    String login = teclado.next();
                    if (bd.confereLogin(login)) {
                        Cliente cliente = bd.buscaCliente(login);
                        if (telas.loginCliente(cliente)) {
                            telas.visualizacaoCliente(cliente,bd);
                        }
                    } else {
                        System.out.println("Login inexistente");
                    }   break;
                case 3:
                    System.out.println("Até a próxima");
                    teste = false;
                    break;
                default:
                    System.out.println("Opcao inválida");
                    break;
            }
        }
    }
}
