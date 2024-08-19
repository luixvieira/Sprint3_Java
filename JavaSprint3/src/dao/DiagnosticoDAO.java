package dao;

import model.Diagnostico;
import util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosticoDAO {

    public void inserirDiagnostico(Diagnostico diagnostico) {
        String sql = "INSERT INTO diagnosticos (descricao, recomendacao) VALUES (?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, diagnostico.getDescricao());
            stmt.setString(2, diagnostico.getRecomendacao());

            stmt.executeUpdate();
            System.out.println("Diagnóstico inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir diagnóstico: " + e.getMessage());
        }
    }

    public Diagnostico buscarDiagnosticoPorId(int id) {
        String sql = "SELECT * FROM diagnosticos WHERE id = ?";
        Diagnostico diagnostico = null;

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                diagnostico = new Diagnostico();
                diagnostico.setDescricao(rs.getString("descricao"));
                diagnostico.setRecomendacao(rs.getString("recomendacao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar diagnóstico: " + e.getMessage());
        }
        return diagnostico;
    }

    public void atualizarDiagnostico(Diagnostico diagnostico) {
        String sql = "UPDATE diagnosticos SET descricao = ?, recomendacao = ? WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, diagnostico.getDescricao());
            stmt.setString(2, diagnostico.getRecomendacao());
            stmt.setInt(3, diagnostico.getId());

            stmt.executeUpdate();
            System.out.println("Diagnóstico atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar diagnóstico: " + e.getMessage());
        }
    }

    public void deletarDiagnostico(int id) {
        String sql = "DELETE FROM diagnosticos WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Diagnóstico excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir diagnóstico: " + e.getMessage());
        }
    }
}
