package dao;

import model.Filiados;
import util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FiliadosDAO {

    public void inserirFiliado(Filiados filiado) {
        String sql = "INSERT INTO filiados (nome, endereco, telefone) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, filiado.getNome());
            stmt.setString(2, filiado.getEndereco());
            stmt.setString(3, filiado.getTelefone());

            stmt.executeUpdate();
            System.out.println("Filiado inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir filiado: " + e.getMessage());
        }
    }

    public Filiados buscarFiliadoPorId(int id) {
        String sql = "SELECT * FROM filiados WHERE id = ?";
        Filiados filiado = null;

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                filiado = new Filiados();
                filiado.setNome(rs.getString("nome"));
                filiado.setEndereco(rs.getString("endereco"));
                filiado.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar filiado: " + e.getMessage());
        }
        return filiado;
    }

    public void atualizarFiliado(Filiados filiado) {
        String sql = "UPDATE filiados SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, filiado.getNome());
            stmt.setString(2, filiado.getEndereco());
            stmt.setString(3, filiado.getTelefone());
            stmt.setInt(4, filiado.getId());

            stmt.executeUpdate();
            System.out.println("Filiado atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar filiado: " + e.getMessage());
        }
    }

    public void deletarFiliado(int id) {
        String sql = "DELETE FROM filiados WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Filiado excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir filiado: " + e.getMessage());
        }
    }
}
