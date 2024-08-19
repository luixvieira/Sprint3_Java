package test;

import dao.PecasDAO;
import model.Pecas;

public class TestePecasDAO {
    public static void main(String[] args) {
        PecasDAO pecasDAO = new PecasDAO();

        // Criar uma nova peça
        Pecas peca = new Pecas();
        peca.setNomePeca("Filtro de óleo");
        peca.setFabricante("Fabricante XYZ");
        peca.setPreco(49.99);

        // Inserir a peça no banco de dados
        pecasDAO.inserirPeca(peca);

        // Buscar a peça inserida
        Pecas pecaBuscada = pecasDAO.buscarPecaPorId(1); // Supondo que o ID seja 1
        if (pecaBuscada != null) {
            pecaBuscada.setId(1); // Definindo o ID no objeto
            System.out.println("Peça encontrada: " + pecaBuscada.getNomePeca());
        }

        // Atualizar a peça
        peca.setId(1); // Supondo que o ID seja 1
        peca.setNomePeca("Filtro de ar");
        pecasDAO.atualizarPeca(peca);

        // Deletar a peça
        pecasDAO.deletarPeca(1);
    }
}
