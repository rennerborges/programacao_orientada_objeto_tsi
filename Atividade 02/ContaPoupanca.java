public class ContaPoupanca extends Conta {

	public ContaPoupanca(PessoaFisica pessoa, int numeroConta, int numeroAgencia, String banco) {
		super(pessoa, numeroConta, numeroAgencia, banco);
	}

	public double rendimento() {
		double porcentagem = 0.05;
		double saldoAtual = super.getSaldo();
		double novoSaldo = saldoAtual + (saldoAtual * porcentagem);
		super.setSaldo(novoSaldo);
		return novoSaldo;
	}

	protected Boolean isValidAction(double saldo, double valorTransacao) {
		double restante = saldo - valorTransacao;
		return restante >= 0 && valorTransacao > 0;
	}

}
