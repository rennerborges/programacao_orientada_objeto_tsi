public class ContaCorrente extends Conta {

	public ContaCorrente(PessoaFisica pessoa, int numeroConta, int numeroAgencia, String banco) {
		super(pessoa, numeroConta, numeroAgencia, banco);
	}

	protected Boolean isValidAction(double saldo, double valorTransacao) {
		double restante = saldo - valorTransacao;
		return restante >= 0 && valorTransacao > 0;
	}

}
