package test;

import dao.FiliadosDAO;
import model.Filiados;

public class TesteFiliadosDAO {
    public static void main(String[] args) {
        FiliadosDAO filiadosDAO = new FiliadosDAO();

        // Criar um novo filiado
        Filiados filiado = new Filiados();
        filiado.setNome("João da Silva");
        filiado.setEndereco("Rua A, 123");
        filiado.setTelefone("99999-9999");

        // Inserir o filiado no banco de dados
        filiadosDAO.inserirFiliado(filiado);

        // Buscar o filiado inserido
        Filiados filiadoBuscado = filiadosDAO.buscarFiliadoPorId(1); // Supondo que o ID seja 1
        if (filiadoBuscado != null) {
            filiadoBuscado.setId(1); // Definindo o ID no objeto
            System.out.println("Filiado encontrado: " + filiadoBuscado.getNome());
        }

        // Atualizar o filiado
        filiado.setId(1); // Supondo que o ID seja 1
        filiado.setNome("João da Silva Jr.");
        filiadosDAO.atualizarFiliado(filiado);

        // Deletar o filiado
        filiadosDAO.deletarFiliado(1);
    }
}
