package service;

import model.Cliente;

public class ClienteService {
    public void exibirDados(Cliente cliente) {
        System.out.println(cliente.getNome() + " tem " + cliente.getIdade() + " anos.");
    }
}
