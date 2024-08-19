package test;

import dao.ProntuarioDAO;
import model.Prontuario;

public class TesteProntuarioDAO {
    public static void main(String[] args) {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

        // Criar um novo prontuário
        Prontuario prontuario = new Prontuario();
        prontuario.setHistorico("Histórico inicial");
        prontuario.setDataUltimaManutencao("2024-08-15");

        // Inserir o prontuário no banco de dados
        prontuarioDAO.inserirProntuario(prontuario);

        // Buscar o prontuário inserido
        Prontuario prontuarioBuscado = prontuarioDAO.buscarProntuarioPorId(1); // Supondo que o ID seja 1
        if (prontuarioBuscado != null) {
            prontuarioBuscado.setId(1); // Definindo o ID no objeto
            System.out.println("Prontuário encontrado: " + prontuarioBuscado.getHistorico());
        }

        // Atualizar o prontuário
        prontuario.setId(1); // Supondo que o ID seja 1
        prontuario.setHistorico("Histórico atualizado");
        prontuarioDAO.atualizarProntuario(prontuario);

        // Deletar o prontuário
        prontuarioDAO.deletarProntuario(1);
    }
}
