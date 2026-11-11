package br.ufmt.ic.mjolniroath.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializadorDB {

    public static void criarTabelas() {
        String sqlDDL = """
            -- 1. Tabela de Usuários
            CREATE TABLE IF NOT EXISTS tb_usuario (
                id BIGSERIAL PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                email VARCHAR(100) UNIQUE NOT NULL,
                hash_senha VARCHAR(255) NOT NULL,
                nivel_acesso VARCHAR(20) NOT NULL,
                data_criacao TIMESTAMP NOT NULL
            );

            -- 2. Tabela de Par de Chaves (PQC e Clássicas)
            CREATE TABLE IF NOT EXISTS tb_par_chaves (
                id BIGSERIAL PRIMARY KEY,
                usuario_id BIGINT REFERENCES tb_usuario(id) ON DELETE CASCADE,
                algoritmo VARCHAR(50) NOT NULL,
                chave_publica BYTEA NOT NULL,
                chave_privada_cifrada BYTEA NOT NULL,
                eh_pos_quantico BOOLEAN NOT NULL,
                data_criacao TIMESTAMP NOT NULL
            );

            -- 3. Tabela de Documentos
            CREATE TABLE IF NOT EXISTS tb_documento (
                id BIGSERIAL PRIMARY KEY,
                usuario_id BIGINT REFERENCES tb_usuario(id) ON DELETE CASCADE,
                titulo VARCHAR(150) NOT NULL,
                conteudo_cifrado BYTEA NOT NULL,
                hash_sha256 VARCHAR(64) NOT NULL,
                tamanho_bytes BIGINT NOT NULL,
                data_upload TIMESTAMP NOT NULL
            );

            -- 4. Tabela de Assinaturas Digitais PQC
            CREATE TABLE IF NOT EXISTS tb_assinatura_digital (
                id BIGSERIAL PRIMARY KEY,
                documento_id BIGINT REFERENCES tb_documento(id) ON DELETE CASCADE,
                par_chaves_id BIGINT REFERENCES tb_par_chaves(id) ON DELETE CASCADE,
                bytes_assinatura BYTEA NOT NULL,
                algoritmo_assinatura VARCHAR(50) NOT NULL,
                status_validacao VARCHAR(30) NOT NULL,
                data_assinatura TIMESTAMP NOT NULL
            );

            -- 5. Tabela de Log e Benchmark de Telemetria
            CREATE TABLE IF NOT EXISTS tb_log_auditoria (
                id BIGSERIAL PRIMARY KEY,
                usuario_id BIGINT REFERENCES tb_usuario(id) ON DELETE CASCADE,
                tipo_operacao VARCHAR(30) NOT NULL,
                algoritmo VARCHAR(50) NOT NULL,
                tempo_execucao_ms DOUBLE PRECISION NOT NULL,
                tamanho_saida_bytes BIGINT NOT NULL,
                data_hora TIMESTAMP NOT NULL
            );
        """;

        try (Connection conn = ConexaoDB.getConexao();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlDDL);
            System.out.println("[DB] As 5 tabelas foram criadas/verificadas com sucesso no PostgreSQL!");

        } catch (SQLException e) {
            System.err.println("[ERRO DB] Falha ao criar a estrutura de tabelas: " + e.getMessage());
        }
    }

    // Executável temporário para validar a criação das tabelas no banco
    public static void main(String[] args) {
        criarTabelas();
    }
}