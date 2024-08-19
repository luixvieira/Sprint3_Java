package dao;

import model.Mecanico;
import util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MecanicoDAO {

    public void inserirMecanico(Mecanico mecanico) {
        String sql = "INSERT INTO mecanicos (nome, especialidade, experiencia) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, mecanico.getNome());
            stmt.setString(2, mecanico.getEspecialidade());
            stmt.setInt(3, mecanico.getExperiencia());

            stmt.executeUpdate();
            System.out.println("Mecânico inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir mecânico: " + e.getMessage());
        }
    }

    public Mecanico buscarMecanicoPorId(int id) {
        String sql = "SELECT * FROM mecanicos WHERE id = ?";
        Mecanico mecanico = null;

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                mecanico = new Mecanico();
                mecanico.setNome(rs.getString("nome"));
                mecanico.setEspecialidade(rs.getString("especialidade"));
                mecanico.setExperiencia(rs.getInt("experiencia"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar mecânico: " + e.getMessage());
        }
        return mecanico;
    }

    public void atualizarMecanico(Mecanico mecanico) {
        String sql = "UPDATE mecanicos SET nome = ?, especialidade = ?, experiencia = ? WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, mecanico.getNome());
            stmt.setString(2, mecanico.getEspecialidade());
            stmt.setInt(3, mecanico.getExperiencia());
            stmt.setInt(4, mecanico.getId());

            stmt.executeUpdate();
            System.out.println("Mecânico atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar mecânico: " + e.getMessage());
        }
    }

    public void deletarMecanico(int id) {
        String sql = "DELETE FROM mecanicos WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Mecânico excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir mecânico: " + e.getMessage());
        }
    }
}
