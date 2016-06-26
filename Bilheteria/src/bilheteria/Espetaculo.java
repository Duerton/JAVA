package bilheteria;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Espetaculo {

    private String título, tipo, cidade, endereco, descricao;
    private static int totalID;
    private final int IDEspetaculo;
    private Date dataEstreia, dataFim;
    private int quantTotalAssentos, quantAssentosDisponiveis;
    private float valoringresso;

    public Espetaculo(String titulo, String tipo, String cidade, String endereco, String descricao, float valoringresso, int quantTotalAssentos, String dataestreia, String datafim) {
        this.título = titulo;
        this.cidade = cidade;
        this.descricao = descricao;
        this.endereco = endereco;
        this.tipo = tipo;
        this.valoringresso = valoringresso;
        Espetaculo.totalID++;
        this.IDEspetaculo = totalID;
        this.quantTotalAssentos = quantTotalAssentos;
        quantAssentosDisponiveis = quantTotalAssentos;
        this.dataEstreia = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataEstreia = sdf.parse(dataestreia);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.dataFim = new Date();
        try {
            this.dataFim = sdf.parse(datafim);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public boolean verificarDisponibilidadeAssentos() {
        if (this.quantAssentosDisponiveis > 0) {
            return true;
        }
        return false;
    }

    public int getQuantAssentosDisponiveis() {
        return quantAssentosDisponiveis;
    }

    public void atualizarQuantAssentos(int quant) {
        this.quantAssentosDisponiveis = this.quantAssentosDisponiveis - quant;
    }

    public String getTitulo() {
        return this.título;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getTipo() {
        return this.tipo;
    }

    public float getValorIngresso() {
        return this.valoringresso;
    }

    public int getIDEspetaculo() {
        return this.IDEspetaculo;
    }

    public String getDataEstreia() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.dataEstreia);

    }

    public String getDataFim() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.dataFim);
    }
    
    public boolean verificarExibicao(Date data){
        if((this.dataEstreia.before(data)) && (this.dataFim.after(data))){
            return true;
        }
        return false;
    }

    public void imprimeEspetaculo() {
        System.out.println("Registro: " + this.getIDEspetaculo());
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Titulo: " + this.getTipo());
        System.out.println("Cidade: " + this.getCidade());
        System.out.println("Endereco: " + this.getEndereco());
        System.out.println("Valor do ingresso: R$" + this.getValorIngresso());
        System.out.println("Data de Estreia: " + this.getDataEstreia());
        System.out.println("Data da última exibição " + this.getDataFim());
        System.out.println("###################");
        System.out.println(" ");
    }
}
