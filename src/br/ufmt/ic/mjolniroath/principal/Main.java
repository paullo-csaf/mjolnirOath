package br.ufmt.ic.mjolniroath.principal;

import br.ufmt.ic.mjolniroath.util.InicializadorDB;

public class Main {
    public static void main(String[] args) {
        System.out.println("[QuantumVault] Iniciando testes de banco de dados...");
        InicializadorDB.criarTabelas();
    }
}
