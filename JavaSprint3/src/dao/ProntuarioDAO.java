package dao;

import model.Prontuario;
import util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProntuarioDAO {

    // Método para inserir um prontuário no banco de dados
    public void inserirProntuario(Prontuario prontuario) {
        String sql = "INSERT INTO prontuarios (historico, dataUltimaManutencao) VALUES (?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, prontuario.getHistorico());
            stmt.setString(2, prontuario.getDataUltimaManutencao());

            stmt.executeUpdate();
            System.out.println("Prontuário inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir prontuário: " + e.getMessage());
        }
    }

    // Método para buscar um prontuário por ID
    public Prontuario buscarProntuarioPorId(int id) {
        String sql = "SELECT * FROM prontuarios WHERE id = ?";
        Prontuario prontuario = null;

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                prontuario = new Prontuario();
                prontuario.setId(rs.getInt("id"));
                prontuario.setHistorico(rs.getString("historico"));
                prontuario.setDataUltimaManutencao(rs.getString("dataUltimaManutencao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar prontuário: " + e.getMessage());
        }
        return prontuario;
    }

    // Método para atualizar um prontuário no banco de dados
    public void atualizarProntuario(Prontuario prontuario) {
        String sql = "UPDATE prontuarios SET historico = ?, dataUltimaManutencao = ? WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, prontuario.getHistorico());
            stmt.setString(2, prontuario.getDataUltimaManutencao());
            stmt.setInt(3, prontuario.getId());

            stmt.executeUpdate();
            System.out.println("Prontuário atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar prontuário: " + e.getMessage());
        }
    }

    // Método para deletar um prontuário do banco de dados
    public void deletarProntuario(int id) {
        String sql = "DELETE FROM prontuarios WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Prontuário excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir prontuário: " + e.getMessage());
        }
    }
}
