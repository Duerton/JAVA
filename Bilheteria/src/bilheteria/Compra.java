package bilheteria;

public class Compra {

    private static int totalIDCompra;
    private final int IDCompra;
    private final String numcartao;
    private final Espetaculo espetaculo;
    private final Cliente cliente;
    private final int quantidade;

    public Compra(String numcartao, Espetaculo espetaculo, Cliente cliente, int quantidade) {
        this.numcartao = numcartao;
        this.espetaculo = espetaculo;
        this.cliente = cliente;
        this.quantidade = quantidade;
        Compra.totalIDCompra++;
        this.IDCompra = totalIDCompra;
    }

    public boolean inserirDadosCartao(String nomeCartao, int numCartao, int validade, int codigo) {
        return true;
    }

    public Espetaculo getEspetaculo() {
        return this.espetaculo;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void imprimeCompra() {
        System.out.println("Compra número: " + IDCompra);
        System.out.println("###################");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("###################");
        System.out.println("Registro do Espetaculo: " + espetaculo.getIDEspetaculo());
        System.out.println("Titulo: " + espetaculo.getTitulo());
        System.out.println("Descrição: " + espetaculo.getDescricao());
        System.out.println("Titulo: " + espetaculo.getTipo());
        System.out.println("Cidade: " + espetaculo.getCidade());
        System.out.println("Endereco: " + espetaculo.getEndereco());
        System.out.println("###################");
        System.out.println("Quantidade de ingressos comprados: " + this.quantidade);
        System.out.println("Valor de cada ingresso: " + espetaculo.getValorIngresso());
        System.out.println("Total: " + (this.quantidade * espetaculo.getValorIngresso()));
        System.out.println("###################");
    }
}
