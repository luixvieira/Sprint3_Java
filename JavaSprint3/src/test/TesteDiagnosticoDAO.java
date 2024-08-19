package test;

import dao.DiagnosticoDAO;
import model.Diagnostico;

public class TesteDiagnosticoDAO {
    public static void main(String[] args) {
        DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();

        // Criar um novo diagnóstico
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setDescricao("Diagnóstico inicial");
        diagnostico.setRecomendacao("Tomar medicamento X");

        // Inserir o diagnóstico no banco de dados
        diagnosticoDAO.inserirDiagnostico(diagnostico);

        // Buscar o diagnóstico inserido
        Diagnostico diagnosticoBuscado = diagnosticoDAO.buscarDiagnosticoPorId(1); // Supondo que o ID seja 1
        if (diagnosticoBuscado != null) {
            diagnosticoBuscado.setId(1); // Definindo o ID no objeto
            System.out.println("Diagnóstico encontrado: " + diagnosticoBuscado.getDescricao());
        }

        // Atualizar o diagnóstico
        diagnostico.setId(1); // Supondo que o ID seja 1
        diagnostico.setDescricao("Diagnóstico atualizado");
        diagnosticoDAO.atualizarDiagnostico(diagnostico);

        // Deletar o diagnóstico
        diagnosticoDAO.deletarDiagnostico(1);
    }
}
