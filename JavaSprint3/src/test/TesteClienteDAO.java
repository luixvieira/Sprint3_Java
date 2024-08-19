package test;

import dao.ClienteDAO;
import model.Cliente;

public class TesteClienteDAO {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        // Criar um novo cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Maria");
        cliente.setIdade(25);

        // Inserir o cliente no banco de dados
        clienteDAO.inserirCliente(cliente);

        // Buscar o cliente inserido
        Cliente clienteBuscado = clienteDAO.buscarClientePorId(1); // Supondo que o ID seja 1
        if (clienteBuscado != null) {
            System.out.println("Cliente encontrado: " + clienteBuscado.getNome());
        }

        // Atualizar o cliente
        cliente.setId(1); // Supondo que o ID seja 1
        cliente.setNome("Maria Silva");
        clienteDAO.atualizarCliente(cliente);

        // Deletar o cliente
        clienteDAO.deletarCliente(1);
    }
}
