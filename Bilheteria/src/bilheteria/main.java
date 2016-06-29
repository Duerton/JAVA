package bilheteria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        BD bd = new BD();
        Tela telas = new Tela();

        Espetaculo espetaculo1 = new Espetaculo("Matriz", "Cinema", "Niteroi", "Na esquina", "Futurista", 20.00f, 200, "10/11/2015", "15/06/2016");
        Espetaculo espetaculo2 = new Espetaculo("O relógio", "Teatro", "Rio de Janeiro", "Outra esquina", "Drama", 25.00f, 150, "14/03/2016", "20/06/2016");
        Espetaculo espetaculo3 = new Espetaculo("Rei Leão", "Show", "Sao Goncalo", "Outra esquina", "Animação", 15.00f, 200, "12/02/2016", "15/06/2017");
        bd.inserirEspetaculos(espetaculo1);
        bd.inserirEspetaculos(espetaculo2);
        bd.inserirEspetaculos(espetaculo3);

        Cliente auxiliar = new Cliente("duerton", 30, "duerton", "root");
        bd.inserirCliente("duerton", auxiliar);

        boolean teste = true;
        while (teste) {
            try {
                telas.telaInicial(bd);
                teste = false;
            } catch (InputMismatchException e) {
                System.out.println("Opcao inválida");
            }
        }

    }
}
