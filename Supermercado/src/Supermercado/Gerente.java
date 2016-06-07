package Supermercado;

public class Gerente extends Pessoa {

    private final int idGer;
    
    Gerente(String nome, int id){
        super(nome);
        this.idGer = id;
    }

    public int getID() {
        return this.idGer;
    }

}
