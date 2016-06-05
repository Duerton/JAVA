package Criptografia;

public class Criptografia {

    public char[] criptografar(char[] letras, int profundidade) {
        int count = letras.length, aux = count / profundidade, x = 0, resto = count % profundidade;
        if ((count % profundidade) != 0) {
            aux += 1;
            count += resto;
        }
        char[][] vetor = new char[profundidade][aux];
        char[] saida = new char[count * aux];
        for (int i = 0; i < aux; i++) {
            for (int j = 0; j < profundidade; j++) {
                if (x < letras.length) {
                    vetor[j][i] = letras[x++];
                } else {
                    vetor[j][i] = '|';
                }
            }
        }
        x = 0;
        for (int i = 0; i < profundidade; i++) {
            for (int j = 0; j < aux; j++) {
                saida[x] = vetor[i][j];
                x++;
            }
        }
        return saida;
    }

    public char[] decriptografar(char[] letras, int profundidade) {
        int count = letras.length, aux = count / profundidade, x = 0;

        char[][] vetor = new char[profundidade][aux];
        char[] saida = new char[count];
        for (int i = 0; i < profundidade; i++) {
            for (int j = 0; j < aux; j++) {
                vetor[i][j] = letras[x++];
            }
        }
        x = 0;
        for (int i = 0; i < aux; i++) {
            for (int j = 0; j < profundidade; j++) {
                saida[x] = vetor[j][i];
                x++;
            }
        }
        return saida;
    }

    public void impressao(char[] letras) {
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == '|') {
                System.out.print(' ');
            } else {
                System.out.print(letras[i]);
            }
        }
    }
}
