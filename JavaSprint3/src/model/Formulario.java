package model;

public class Formulario {
    private String tipoServico;
    private String descricaoProblema;
    private String data;

    // Getters e Setters
    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    // Método para exibir detalhes do formulário
    public void exibirDetalhes() {
        System.out.println("Tipo de Serviço: " + tipoServico);
        System.out.println("Descrição do Problema: " + descricaoProblema);
        System.out.println("Data: " + data);
    }
}
