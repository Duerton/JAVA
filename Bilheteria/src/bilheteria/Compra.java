package bilheteria;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Compra {

    private static int totalIDCompra;
    private final int IDCompra;
    private final Espetaculo espetaculo;
    private final Cliente cliente;
    private final int quantidade;
    private final Date data;

    public Compra(Espetaculo espetaculo, Cliente cliente, int quantidade, Date data) {
        this.espetaculo = espetaculo;
        this.cliente = cliente;
        this.quantidade = quantidade;
        Compra.totalIDCompra++;
        this.IDCompra = totalIDCompra;
        this.data = data;
    }

    public boolean ligarCartao(String nomecartao, String numcartao, String validade, String codigo) {
        CartaoDeCredito cartao = new CartaoDeCredito();
        if(cartao.conferirDadosCartao(nomecartao, numcartao, validade, codigo)){
            return true;
        }
        return false;        
    }

    public Espetaculo getEspetaculo() {
        return this.espetaculo;
    }

    public int getQuantidade() {
        return this.quantidade;
    }
    
    public Integer getIDCompra(){
        return this.IDCompra;
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
        System.out.println("Valor do ingresso: R$" + espetaculo.getValorIngresso());
        System.out.println("###################");
        System.out.println("Quantidade de ingressos comprados: " + this.quantidade);
        System.out.println("Valor de cada ingresso: R$" + espetaculo.getValorIngresso());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataS = sdf.format(this.data);
        System.out.println("Data do Espetaculo: " + dataS);
        System.out.println("Total: R$" + (this.quantidade * espetaculo.getValorIngresso()));
        System.out.println("###################");
    }
}
