
package Torneio;

import java.util.Collections;
import java.util.List;


public class Tabela {
    List<Time> tabela;
    
    public void setTabela(List<Time> tabela){
        this.tabela = tabela;
    }
    
    public List<Time> organizaTabela(List<Time> tabela){
        Collections.sort(tabela);
        return this.tabela;
    }
    
    
}
