package service;

import model.Mecanico;
import java.util.ArrayList;
import java.util.List;

public class MecanicoService {

    private List<Mecanico> mecanicos = new ArrayList<>();

    public void visualizarPreDiagnostico() {
        System.out.println("== Pré-Diagnóstico ==");
        // Código para visualizar pré-diagnóstico
        for (Mecanico mecanico : mecanicos) {
            mecanico.exibirInformacoes();
        }
    }

    public void visualizarDiagnosticoVeiculo(int idProntuario) {
        // Código para visualizar diagnóstico do veículo
        System.out.println("Visualizando diagnóstico do veículo para o prontuário ID: " + idProntuario);
    }
}
