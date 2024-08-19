package test;

import dao.VeiculoDAO;
import model.Veiculo;

public class TesteVeiculoDAO {
    public static void main(String[] args) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();

        // Criar um novo veículo
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC-1234");
        veiculo.setModelo("Sedan");

        // Inserir o veículo no banco de dados
        veiculoDAO.inserirVeiculo(veiculo);

        // Buscar o veículo inserido
        Veiculo veiculoBuscado = veiculoDAO.buscarVeiculoPorId(1); // Supondo que o ID seja 1
        if (veiculoBuscado != null) {
            veiculoBuscado.setId(1); // Definindo o ID no objeto
            System.out.println("Veículo encontrado: " + veiculoBuscado.getModelo());
        }

        // Atualizar o veículo
        veiculo.setId(1); // Supondo que o ID seja 1
        veiculo.setModelo("Hatchback");
        veiculoDAO.atualizarVeiculo(veiculo);

        // Deletar o veículo
        veiculoDAO.deletarVeiculo(1);
    }
}
