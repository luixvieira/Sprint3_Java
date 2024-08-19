package service;

import dao.ProntuarioDAO;
import model.Prontuario;

public class ProntuarioService {

    private ProntuarioDAO prontuarioDAO;

    public ProntuarioService() {
        this.prontuarioDAO = new ProntuarioDAO();
    }

    // Método para adicionar um prontuário
    public void adicionarProntuario(Prontuario prontuario) {
        prontuarioDAO.inserirProntuario(prontuario);
        System.out.println("Prontuário adicionado com sucesso.");
    }

    // Método para exibir as informações de um prontuário por ID
    public void exibirProntuario(int id) {
        Prontuario prontuario = prontuarioDAO.buscarProntuarioPorId(id);
        if (prontuario != null) {
            prontuario.exibirInformacoes();
        } else {
            System.out.println("Prontuário não encontrado.");
        }
    }

    // Método para atualizar um prontuário
    public void atualizarProntuario(Prontuario prontuario) {
        prontuarioDAO.atualizarProntuario(prontuario);
        System.out.println("Prontuário atualizado com sucesso.");
    }

    // Método para remover um prontuário por ID
    public void removerProntuario(int id) {
        prontuarioDAO.deletarProntuario(id);
        System.out.println("Prontuário removido com sucesso.");
    }

    // Método para obter o ID de um prontuário
    public int obterIdProntuario(Prontuario prontuario) {
        return prontuario.getId();
    }
}
