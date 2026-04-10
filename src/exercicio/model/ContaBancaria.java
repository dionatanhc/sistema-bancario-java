package exercicio.model;

import exercicio.util.BancoUtils;

public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String nome) {
        this.titular = nome;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        if (BancoUtils.valorValido(valor)) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (BancoUtils.valorValido(valor) && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void exibirDados() {
        System.out.println("Nome: " + titular + " | Saldo: " + saldo);
    }
}
