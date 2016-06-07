package Supermercado;

public class Login {
    
    public void cadastrarPessoa(){
        
    }

    public boolean loginPessoa(Pessoa pessoa, String login, String senha) {
        if (login.equals(pessoa.login) && senha.equals(pessoa.senha)){
            return true;
        }
        return false;
    }

    public void loginFuncionarios(Funcionario funcionario) {

    }
}
