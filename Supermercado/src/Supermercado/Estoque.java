package Supermercado;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    Map<Integer, Produto> estoque = new HashMap();

    public void inserirEstoque(Integer codProd, Produto produto) {
        estoque.put(codProd, produto);
    }

    public void retirarEstoque(Integer codProd) {
        estoque.remove(codProd);
    }

    public Produto buscarEstoque(Integer codProd) {
        return estoque.get(codProd);
    }
}
