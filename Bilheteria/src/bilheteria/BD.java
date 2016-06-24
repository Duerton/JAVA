package bilheteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BD {

    private Map<String, Cliente> bdClientes = new HashMap();
    private Collection<Espetaculo> bdEspetaculo = new ArrayList();
    private Map<Integer, Compra> bdCompras = new HashMap();

    public boolean confereLogin(String login) {
        if (bdClientes.containsKey(login)) {
            return true;
        }
        return false;
    }

    public Cliente buscaCliente(String cliente) {
        return bdClientes.get(cliente);
    }

    public void inserirCliente(String login, Cliente cliente) {
        bdClientes.put(login, cliente);
    }

    public void visualizarEspetaculos() {
        for (Espetaculo espetaculo : bdEspetaculo) {
            System.out.println("Registro: " + espetaculo.getIDEspetaculo());
            System.out.println("Titulo: " + espetaculo.getTitulo());
            System.out.println("Descrição: " + espetaculo.getDescricao());
            System.out.println("Titulo: " + espetaculo.getTipo());
            System.out.println("Cidade: " + espetaculo.getCidade());
            System.out.println("Endereco: " + espetaculo.getEndereco());
            System.out.println("Valor do ingresso: " + espetaculo.getValorIngresso());
            System.out.println("Data de Estreia: " + espetaculo.getDataEstreia());
            System.out.println("###################");
            System.out.println(" ");
        }
    }

    public void inserirEspetaculos(Espetaculo espetaculo) {
        bdEspetaculo.add(espetaculo);
    }

    public Espetaculo getEspetaculo(int numespetaculo) {
        for (Espetaculo espetaculo : bdEspetaculo) {
            if (numespetaculo == espetaculo.getIDEspetaculo()) {
                return espetaculo;
            }
        }
        return null;
    }

    public void inserirCompra(Integer num, Compra compra) {
        this.bdCompras.put(num, compra);
    }

    public void retirarFilmesAntigos() {
        Date dataatual = new Date(System.currentTimeMillis());
        System.out.println(""+dataatual);
        /*for(Espetaculo espetaculo : bdEspetaculo){
            if(espetaculo.getDataFim().after(dataatual)){
                bdEspetaculo.remove(espetaculo);
            }
        }*/
    }

}
