package service;

import model.Veiculo;

public class VeiculoService {
    public void registrarVeiculo(Veiculo veiculo) {
        System.out.println("Veículo " + veiculo.getModelo() + " com placa " + veiculo.getPlaca() + " registrado.");
    }
}
