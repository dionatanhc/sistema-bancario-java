package exercicio.view;

import exercicio.model.ContaBancaria;
import exercicio.service.ContaService;
import exercicio.util.Mensagens;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        //entrada de dados do usuário
        Scanner scanner = new Scanner(System.in);
        ContaService service = new ContaService();
        boolean sair = false;

        while (!sair) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Abertura de conta");
            System.out.println("2. Depósito");
            System.out.println("3. Saque");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Status da conta");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Abertura de Conta ---");
                    System.out.println("Digite seu nome: ");
                    String nomeTitular = scanner.nextLine();

                    int numDaConta = service.criarConta(nomeTitular);

                    System.out.println("\n=====================================");
                    System.out.println("Conta criada com sucesso!");
                    System.out.println("Titular: " + nomeTitular);
                    System.out.println("Número da conta: " + numDaConta);
                    System.out.println("=====================================\n");
                    break;
                case 2:
                    System.out.println("\n--- Depósito ---");
                    System.out.println("Nº da conta: ");
                    int contaDep = scanner.nextInt();
                    System.out.println("Valor: ");
                    double valorDep = scanner.nextDouble();

                    try {
                        boolean sucesso = service.depositar(contaDep, valorDep);

                        if (sucesso) {
                            System.out.println(Mensagens.SUCESSO_DEPOSITO);
                        } else {
                            System.out.println(Mensagens.CONTA_NAO_ENCONTRADA);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\n--- Saque ---");
                    System.out.println("Nº da conta: ");
                    int contaSaq = scanner.nextInt();
                    System.out.println("Valor: ");
                    double valorSaq = scanner.nextDouble();

                    String mensagem = service.sacar(contaSaq, valorSaq);
                    System.out.println(mensagem);
                    break;
                case 4:
                    System.out.println("\n--- Consulta de Saldo ---");
                    System.out.print("Nº da conta: ");
                    int contaSaldo = scanner.nextInt();

                    Double saldo = service.consultarSaldo(contaSaldo);

                    if (saldo != null) {
                        System.out.println("Saldo: " + saldo);
                    } else {
                        System.out.println(Mensagens.CONTA_NAO_ENCONTRADA);
                    }
                    break;
                case 5:
                    System.out.println("\n--- Status da Conta ---");
                    System.out.print("Nº da conta: ");
                    int contaStatus = scanner.nextInt();

                    ContaBancaria conta = service.buscarConta(contaStatus);

                    if (conta != null) {
                        conta.exibirDados();
                    } else {
                        System.out.println(Mensagens.CONTA_NAO_ENCONTRADA);
                    }

                    break;
                case 6:
                    System.out.println("\nSaindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
        scanner.close();
    }
}
