package util;

import java.sql.Connection;

public class TesteDeConexao {
    public static void main(String[] args) {
        // Tenta obter uma conexão com o banco de dados
        Connection conexao = ConexaoDB.getConnection();

        if (conexao != null) {
            try {
                // Fecha a conexão
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
