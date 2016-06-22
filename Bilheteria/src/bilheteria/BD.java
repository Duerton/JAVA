package bilheteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BD {

    private Map<String, Cliente> bdClientes = new HashMap();
    private Collection<Espetaculo> bdEspetaculo = new HashSet();
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
            System.out.println("###################");
        }
    }

    public void inserirEspetaculos(Espetaculo espetaculo) {
        bdEspetaculo.add(espetaculo);
    }
    
    public Espetaculo getEspetaculo(){
        return 
    }

}
