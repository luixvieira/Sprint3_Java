package test;

import dao.MecanicoDAO;
import model.Mecanico;

public class TesteMecanicoDAO {
    public static void main(String[] args) {
        MecanicoDAO mecanicoDAO = new MecanicoDAO();

        // Criar um novo mecânico
        Mecanico mecanico = new Mecanico();
        mecanico.setNome("Carlos Souza");
        mecanico.setEspecialidade("Motor");
        mecanico.setExperiencia(10);

        // Inserir o mecânico no banco de dados
        mecanicoDAO.inserirMecanico(mecanico);

        // Buscar o mecânico inserido
        Mecanico mecanicoBuscado = mecanicoDAO.buscarMecanicoPorId(1); // Supondo que o ID seja 1
        if (mecanicoBuscado != null) {
            mecanicoBuscado.setId(1); // Definindo o ID no objeto
            System.out.println("Mecânico encontrado: " + mecanicoBuscado.getNome());
        }

        // Atualizar o mecânico
        mecanico.setId(1); // Supondo que o ID seja 1
        mecanico.setNome("Carlos Souza Jr.");
        mecanicoDAO.atualizarMecanico(mecanico);

        // Deletar o mecânico
        mecanicoDAO.deletarMecanico(1);
    }
}
