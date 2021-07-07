import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Atividade02 {
	private static ArrayList<ContaEspecial> contasCorrentes;

	public static void main(String[] args) {
		byte operacao;
		Scanner scanner = new Scanner(System.in);

		int numeroConta;
		int numeroAgencia;
		String banco;
		ContaEspecial conta;
		float valor;
		String nome;
		String sobrenome;
		BigInteger cpf;
		int anoNascimento;
		PessoaFisica Pessoa;
		contasCorrentes = new ArrayList<ContaEspecial>();

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

					System.out.println("Informe seu nome:");
					nome = scanner.next();

					System.out.println("Informe seu sobrenome:");
					sobrenome = scanner.next();

					System.out.println("Informe seu CPF:");
					cpf = scanner.nextBigInteger();

					System.out.println("Informe seu ano de nascimento:");
					anoNascimento = scanner.nextInt();

					System.out.println("Informe o número da conta:");
					numeroConta = scanner.nextInt();

					System.out.println("Informe o número da agência:");
					numeroAgencia = scanner.nextInt();

					System.out.println("Informe o banco:");
					banco = scanner.next();

					Pessoa = new PessoaFisica(nome, sobrenome, cpf, anoNascimento);

					conta = new ContaEspecial(Pessoa, numeroConta, numeroAgencia, banco, 100);
					contasCorrentes.add(conta);

					System.out.println("\n");
					conta.extrato();
					System.out.println(conta.getLastTransacion());
					break;
				case 2:
					System.out.println("<<<<< Exibir o saldo, ou extrato, de uma conta >>>>>");
					System.out.println("\n");

					System.out.println("Informe o número da conta:");
					numeroConta = scanner.nextInt();

					conta = getContaByNumeroConta(numeroConta);

					if (conta != null) {
						conta.extrato();
						System.out.println(conta.getLastTransacion());
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
						System.out.println(conta.getLastTransacion());
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
						System.out.println(conta.getLastTransacion());

					} else {
						System.out.println("Não conseguimos localizar uma conta com esse número " + numeroConta);
					}
					break;
				case 5:
					System.out.println("<<<<< Transferir valores de uma conta para outra >>>>>");
					System.out.println("\n");

					System.out.println("Informe o número da conta origem:");
					int numeroContaOrigem = scanner.nextInt();

					Conta contaOrigem = getContaByNumeroConta(numeroContaOrigem);

					if (contaOrigem == null) {
						System.out.println(
								"Não conseguimos localizar a conta origem, com esse número " + numeroContaOrigem);
						break;
					}

					System.out.println("Informe o número da conta destino:");
					int numeroContaDestino = scanner.nextInt();
					Conta contaDestino = getContaByNumeroConta(numeroContaDestino);

					if (contaDestino == null) {
						System.out.println(
								"Não conseguimos localizar a conta destino, com esse número " + numeroContaDestino);
						break;
					}

					System.out.println("Informe o valor do deposito:");
					valor = scanner.nextFloat();

					contaOrigem.transferir(contaDestino, valor);
					System.out.println(contaOrigem.getLastTransacion());

					break;
				default:
					break;
			}

		} while (operacao != 6);

		scanner.close();
	}

	public static ContaEspecial getContaByNumeroConta(int numeroConta) {
		for (ContaEspecial conta : contasCorrentes) {
			if (conta.getNumeroConta() == numeroConta) {
				return conta;
			}
		}

		return null;
	}

}