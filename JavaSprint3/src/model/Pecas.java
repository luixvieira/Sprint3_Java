package model;

public class Pecas {
    private int id;
    private String nomePeca;
    private String fabricante;
    private double preco;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método para exibir detalhes da peça
    public void exibirDetalhes() {
        System.out.println("ID: " + id);
        System.out.println("Nome da Peça: " + nomePeca);
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Preço: R$ " + preco);
    }
}
