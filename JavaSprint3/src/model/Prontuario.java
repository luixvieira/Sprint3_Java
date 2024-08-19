package model;

public class Prontuario {
    private int id;
    private String historico;
    private String dataUltimaManutencao;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getDataUltimaManutencao() {
        return dataUltimaManutencao;
    }

    public void setDataUltimaManutencao(String dataUltimaManutencao) {
        this.dataUltimaManutencao = dataUltimaManutencao;
    }

    // Método para exibir informações do prontuário
    public void exibirInformacoes() {
        System.out.println("ID: " + id);
        System.out.println("Histórico: " + historico);
        System.out.println("Data da Última Manutenção: " + dataUltimaManutencao);
    }
}
