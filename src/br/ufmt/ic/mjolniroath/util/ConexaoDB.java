package br.ufmt.ic.mjolniroath.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    // Use "localhost" se o Docker estiver rodando no seu computador.
    // Se for um banco remoto, substitua "localhost" pelo IP do servidor.
    private static final String URL = "jdbc:postgresql://localhost:5432/quantumvault_db";
    private static final String USER = "admin_pqc";
    private static final String PASSWORD = "senha_segura";

    private static Connection conexao = null;

    private ConexaoDB() {}

    public static Connection getConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("[DB] Conexão com o PostgreSQL estabelecida com sucesso!");
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver JDBC do PostgreSQL não encontrado no classpath.", e);
            }
        }
        return conexao;
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("[DB] Conexão encerrada com sucesso.");
            } catch (SQLException e) {
                System.err.println("[ERRO DB] Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}