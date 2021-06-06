import java.util.ArrayList;
import java.util.Scanner;

public class Atividade02 {
	private static ArrayList<ContaCorrente> contasCorrentes;

	public static void main(String[] args) {
		byte operacao;
		Scanner scanner = new Scanner(System.in);

		String titular;
		int numeroConta;
		int numeroAgencia;
		String banco;
		ContaCorrente conta;
		float valor;
		contasCorrentes = new ArrayList<ContaCorrente>();

		do {
			System.out.println("\n");
			System.out.println("<<<<<<<<< Caixa >>>>>>>>");
			System.out.println("1 - Criar uma nova conta");
			System.out.println("2 - Exibir o saldo, ou extrato, de uma conta");
			System.out.println("3 - Sacar um valor de uma conta");
			System.out.println("4 - Depositar um valor em uma conta");
			System.out.println("5 - Transferir valores de uma conta para outra");
			System.out.println("6 - Sair");

			System.out.println("Informe a opção: ");
			operacao = scanner.nextByte();

			System.out.println("\n");

			switch (operacao) {
				case 1:
					System.out.println("<<<<< Criar uma nova conta >>>>>");
					System.out.println("\n");

					System.out.println("Informe o titular:");
					titular = scanner.next();

					System.out.println("Informe o número da conta:");
					numeroConta = scanner.nextInt();

					System.out.println("Informe o número da agência:");
					numeroAgencia = scanner.nextInt();

					System.out.println("Informe o banco:");
					banco = scanner.next();

					conta = new ContaCorrente(titular, numeroConta, numeroAgencia, banco);
					contasCorrentes.add(conta);

					System.out.println("\n");
					conta.extrato();
					break;
				case 2:
					System.out.println("<<<<< Exibir o saldo, ou extrato, de uma conta >>>>>");
					System.out.println("\n");

					System.out.println("Informe o número da conta:");
					numeroConta = scanner.nextInt();

					conta = getContaByNumeroConta(numeroConta);

					if (conta != null) {
						conta.extrato();
					} else {
						System.out.println("Não conseguimos localizar uma conta com esse número " + numeroConta);
					}

					break;
				case 3:
					System.out.println("<<<<< Sacar um valor de uma conta >>>>>");
					System.out.println("\n");

					System.out.println("Informe o número da conta:");
					numeroConta = scanner.nextInt();

					conta = getContaByNumeroConta(numeroConta);

					if (conta != null) {
						System.out.println("Informe o valor do saque:");
						valor = scanner.nextFloat();
						conta.sacar(valor);
					} else {
						System.out.println("Não conseguimos localizar uma conta com esse número " + numeroConta);
					}
					break;
				case 4:
					System.out.println("<<<<< Depositar um valor em uma conta >>>>>");
					System.out.println("\n");

					System.out.println("Informe o número da conta:");
					numeroConta = scanner.nextInt();

					conta = getContaByNumeroConta(numeroConta);

					if (conta != null) {
						System.out.println("Informe o valor do deposito:");
						valor = scanner.nextFloat();
						conta.depositar(valor);
					} else {
						System.out.println("Não conseguimos localizar uma conta com esse número " + numeroConta);
					}
					break;
				case 5:
					System.out.println("<<<<< Transferir valores de uma conta para outra >>>>>");
					System.out.println("\n");

					System.out.println("Informe o número da conta origem:");
					int numeroContaOrigem = scanner.nextInt();

					ContaCorrente contaOrigem = getContaByNumeroConta(numeroContaOrigem);

					if (contaOrigem == null) {
						System.out.println(
								"Não conseguimos localizar a conta origem, com esse número " + numeroContaOrigem);
						break;
					}

					System.out.println("Informe o número da conta destino:");
					int numeroContaDestino = scanner.nextInt();
					ContaCorrente contaDestino = getContaByNumeroConta(numeroContaDestino);

					if (contaDestino == null) {
						System.out.println(
								"Não conseguimos localizar a conta destino, com esse número " + numeroContaDestino);
						break;
					}

					System.out.println("Informe o valor do deposito:");
					valor = scanner.nextFloat();

					Boolean isTransactionValid = false;

					if (contaOrigem.sacar(valor)) {
						isTransactionValid = contaDestino.depositar(valor);
					}

					if (isTransactionValid) {
						System.out.println("Transferência efetuada com sucesso");
					} else {
						System.out.println("Transferência não efetuada");

					}
					break;
				default:
					break;
			}

		} while (operacao != 6);

		scanner.close();
	}

	public static ContaCorrente getContaByNumeroConta(int numeroConta) {
		for (ContaCorrente conta : contasCorrentes) {
			if (conta.getNumeroConta() == numeroConta) {
				return conta;
			}
		}

		return null;
	}

}