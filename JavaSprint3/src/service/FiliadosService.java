package service;

import dao.FiliadosDAO;
import model.Filiados;

public class FiliadosService {

    private FiliadosDAO filiadosDAO;

    public FiliadosService() {
        this.filiadosDAO = new FiliadosDAO();
    }

    // Método para exibir informações de um filiado por ID
    public void exibirInformacoesFiliado(int id) {
        Filiados filiado = filiadosDAO.buscarFiliadoPorId(id);
        if (filiado != null) {
            filiado.exibirInformacoes();
        } else {
            System.out.println("Filiado não encontrado.");
        }
    }

    // Método para atualizar um filiado
    public void atualizarFiliado(Filiados filiado) {
        filiadosDAO.atualizarFiliado(filiado);
        System.out.println("Filiado atualizado com sucesso.");
    }

    // Método para adicionar um novo filiado
    public void adicionarFiliado(Filiados filiado) {
        filiadosDAO.inserirFiliado(filiado);
        System.out.println("Filiado adicionado com sucesso.");
    }

    // Método para remover um filiado por ID
    public void removerFiliado(int id) {
        filiadosDAO.deletarFiliado(id);
        System.out.println("Filiado removido com sucesso.");
    }
}
