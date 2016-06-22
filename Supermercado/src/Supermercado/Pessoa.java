package Supermercado;

public abstract class Pessoa {

    protected String nome;
    protected String login;
    protected String senha;
    protected int cargo;

    Pessoa(String nome, String login, String senha, int cargo) {
        this.nome = nome;
        this.cargo = cargo;
        this.senha = senha;
        this.login = login;
    }

    public String getNome() {
        return this.nome;
    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String nome) {
        this.login = nome;
    }

    public void setSenha(String nome) {
        this.senha = nome;
    }

}
