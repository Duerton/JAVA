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

    public void visualizarTodosEspetaculos() {
        for (Espetaculo espetaculo : bdEspetaculo) {
            espetaculo.imprimeEspetaculo();
        }
    }

    public void visualizarEspetaculos(ArrayList<Espetaculo> selecaoEspetaculos) {
        for (Espetaculo espetaculo : selecaoEspetaculos) {
            espetaculo.imprimeEspetaculo();
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

    public ArrayList buscarFilmesCidade(String cidade) {
        ArrayList<Espetaculo> cidadeEspetaculo = new ArrayList();
        for (Espetaculo espetaculo : bdEspetaculo) {
            if (espetaculo.getCidade().equals(cidade)) {
                cidadeEspetaculo.add(espetaculo);
            }
        }
        if (cidadeEspetaculo.isEmpty()) {
            return null;
        } else {
            return cidadeEspetaculo;
        }
    }

    public ArrayList buscarFilmesData(Date data) {
        ArrayList<Espetaculo> dataEspetaculo = new ArrayList();
        for (Espetaculo espetaculo : bdEspetaculo) {
            if (espetaculo.verificarExibicao(data)) {
                dataEspetaculo.add(espetaculo);
            }
        }
        if (dataEspetaculo.isEmpty()) {
            return null;
        } else {
            return dataEspetaculo;
        }
    }
}
