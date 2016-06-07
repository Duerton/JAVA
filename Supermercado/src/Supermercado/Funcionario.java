package Supermercado;

public class Funcionario extends Pessoa {

    private static int totalID;
    private final int idFunc;

    Funcionario (String nome) {
        super(nome);
        Funcionario.totalID++;
        this.idFunc = totalID;
    }

    public int getIDFunc() {
        return this.idFunc;
    }
    

}
