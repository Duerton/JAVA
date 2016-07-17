package Supermercado;

import Telas.TelaLogin;

public class main {

    public static void main(String[] args) {
        Estoque estoqueLocal = new Estoque();
        BD bd = new BD(estoqueLocal);
        Arquivo arquivo = new Arquivo();
        Threads[] threads = new Threads[3];
        
        for(int i = 0; i < 3; i++){
            threads[i] = new Threads(bd,estoqueLocal,arquivo);
            threads[i].run();
        }
        
        
        

    }

}
