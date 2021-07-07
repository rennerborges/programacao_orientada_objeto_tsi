public class ContaEmpresarial extends Conta {

	private double chequeEspecial;

	public ContaEmpresarial(PessoaJuridica pessoa, int numeroConta, int numeroAgencia, String banco,
			double chequeEspecial) {

		super(pessoa, numeroConta, numeroAgencia, banco);
		this.chequeEspecial = prepareChequeEspecial(chequeEspecial);
	}

	protected Boolean isValidAction(double saldo, double valorTransacao) {
		double restante = saldo - valorTransacao;

		return restante >= this.chequeEspecial && valorTransacao > 0;
	}

	private double prepareChequeEspecial(double valor) {
		if (valor <= 0) {
			return valor;
		}

		return valor * -1;
	}

}
