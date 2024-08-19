package service;

import model.Pecas;
import java.util.ArrayList;
import java.util.List;

public class PecasService {
    private List<Pecas> listaPecas = new ArrayList<>();

    // Método para adicionar uma peça à lista
    public void adicionarPeca(Pecas peca) {
        listaPecas.add(peca);
        System.out.println("Peça " + peca.getNomePeca() + " adicionada com sucesso.");
    }

    // Método para listar todas as peças
    public void listarPecas() {
        for (Pecas peca : listaPecas) {
            peca.exibirDetalhes();
        }
    }

    // Método para buscar uma peça por nome
    public Pecas buscarPecaPorNome(String nomePeca) {
        for (Pecas peca : listaPecas) {
            if (peca.getNomePeca().equals(nomePeca)) {
                return peca;
            }
        }
        return null;
    }
}
