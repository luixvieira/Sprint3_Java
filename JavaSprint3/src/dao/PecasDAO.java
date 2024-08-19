package dao;

import model.Pecas;
import util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PecasDAO {

    public void inserirPeca(Pecas peca) {
        String sql = "INSERT INTO pecas (nomePeca, fabricante, preco) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, peca.getNomePeca());
            stmt.setString(2, peca.getFabricante());
            stmt.setDouble(3, peca.getPreco());

            stmt.executeUpdate();
            System.out.println("Peça inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir peça: " + e.getMessage());
        }
    }

    public Pecas buscarPecaPorId(int id) {
        String sql = "SELECT * FROM pecas WHERE id = ?";
        Pecas peca = null;

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                peca = new Pecas();
                peca.setNomePeca(rs.getString("nomePeca"));
                peca.setFabricante(rs.getString("fabricante"));
                peca.setPreco(rs.getDouble("preco"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar peça: " + e.getMessage());
        }
        return peca;
    }

    public void atualizarPeca(Pecas peca) {
        String sql = "UPDATE pecas SET nomePeca = ?, fabricante = ?, preco = ? WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, peca.getNomePeca());
            stmt.setString(2, peca.getFabricante());
            stmt.setDouble(3, peca.getPreco());
            stmt.setInt(4, peca.getId());

            stmt.executeUpdate();
            System.out.println("Peça atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar peça: " + e.getMessage());
        }
    }

    public void deletarPeca(int id) {
        String sql = "DELETE FROM pecas WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Peça excluída com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir peça: " + e.getMessage());
        }
    }
}
