package service;

import model.Formulario;
import java.util.ArrayList;
import java.util.List;

public class FormularioService {
    private List<Formulario> listaFormularios = new ArrayList<>();

    // Método para adicionar um formulário à lista
    public void adicionarFormulario(Formulario formulario) {
        listaFormularios.add(formulario);
        System.out.println("Formulário adicionado com sucesso.");
    }

    // Método para listar todos os formulários
    public void listarFormularios() {
        for (Formulario formulario : listaFormularios) {
            formulario.exibirDetalhes();
        }
    }

    // Método para buscar um formulário específico
    public Formulario buscarFormularioPorTipo(String tipoServico) {
        for (Formulario formulario : listaFormularios) {
            if (formulario.getTipoServico().equals(tipoServico)) {
                return formulario;
            }
        }
        return null;
    }
}
