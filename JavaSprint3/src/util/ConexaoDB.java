package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    // Configurações do banco de dados Oracle
    private static final String URL = "jdbc:oracle:thin:@//oracle.fiap.com.br:1521/ORCL";
    private static final String USER = "rm558935";
    private static final String PASSWORD = "310805";

    // Método para obter a conexão
    public static Connection getConnection() {
        try {
            // Tenta estabelecer a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado ao banco de dados!");
            return conexao;
        } catch (SQLException e) {
            // Em caso de erro, imprime a mensagem e retorna null
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
