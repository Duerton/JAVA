package Supermercado;

public class Funcionario extends Pessoa {

    private static int totalID;
    private final int idFunc;

    Funcionario (String nome, String login, String senha, int cargo) {
        super(nome,login,senha,cargo);
        Funcionario.totalID++;
        this.idFunc = totalID;
    }

    public int getIDFunc() {
        return this.idFunc;
    }
    

}
