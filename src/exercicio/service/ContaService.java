package exercicio.service;

import exercicio.model.ContaBancaria;
import exercicio.util.BancoUtils;
import exercicio.util.Mensagens;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ContaService {
    //guardar os dados
    Map<Integer, ContaBancaria> contas = new HashMap<>();
    //gerar nº aleatório da conta
    Random random = new Random();

    public int criarConta(String titular) {
        //10000 está garantindo que o nº da conta tenha 5 dígitos
        //independente do nº que for gerado no random será somado 10000 a ele
        int numDaConta = 10000 + random.nextInt(90000);
        contas.put(numDaConta, new ContaBancaria(titular));
        return numDaConta;
    }

    public boolean depositar(int numeroConta, double valor) {
        ContaBancaria conta = contas.get(numeroConta);

        if (conta == null) {
            return false;
        }

        if (!BancoUtils.valorValido(valor)) {
            throw new IllegalArgumentException(Mensagens.VALOR_INVALIDO);
        }

        conta.depositar(valor);
        return true;
    }

    public String sacar(int numeroConta, double valor) {
        ContaBancaria conta = contas.get(numeroConta);

        if (conta == null) {
            return Mensagens.CONTA_NAO_ENCONTRADA;
        }

        if (!BancoUtils.valorValido(valor)) {
            return Mensagens.SALDO_INSUFICIENTE;
        }

        boolean sucesso = conta.sacar(valor);
        if (!sucesso) {
            return Mensagens.VALOR_INVALIDO;
        }

        return Mensagens.SUCESSO_SAQUE;
    }

    public Double consultarSaldo(int numeroConta) {
        ContaBancaria conta = contas.get(numeroConta);
        if (conta == null) {
            return null;
        }

        return conta.consultarSaldo();
    }

    public ContaBancaria buscarConta(int numeroConta) {
        return contas.get(numeroConta);
    }
}
