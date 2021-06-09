import java.util.ArrayList;

public class ContaCorrente {

	private Pessoa Pessoa;
	private int numeroConta;
	private int numeroAgencia;
	private float saldo;
	private String banco;
	private ArrayList<String> historico;

	public ContaCorrente(Pessoa pessoa, int numeroConta, int numeroAgencia, String banco) {
		this.Pessoa = pessoa;
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
		this.banco = banco;
		this.historico = new ArrayList<String>();
		this.saldo = 0;

		this.historico.add("Conta criada com sucesso");

	}

	public int getNumeroConta() {
		return this.numeroConta;
	}

	public boolean sacar(float valor) {
		if (this.isValidAction(this.saldo, valor)) {
			this.saldo -= valor;
			this.historico.add("Saque com sucesso no valor de R$ " + valor);
			return true;
		} else {
			this.historico.add("Saque não efetuado no valor de R$ " + valor);
			return false;
		}
	}

	public boolean depositar(float valor) {
		if (valor < 0) {
			this.historico.add("Deposito não efetuado no valo de R$ " + valor);
			return false;
		}
		this.saldo += valor;
		this.historico.add("Deposito recebido com sucesso no valor de R$ " + valor);
		return true;
	}

	public boolean transferir(ContaCorrente conta, float valor) {

		if (conta.numeroConta == this.numeroConta) {
			this.historico.add("Transferencia não efetuada, não é possivel transferir para você mesmo.");
			return false;
		}

		if (sacar(valor)) {
			if(conta.depositar(valor)){
				this.historico.add("Transferência efetuada com sucesso");
				return true;
			}
		}

		this.historico.add("Transferência não efetuada");
		return false;
	}

	public void extrato() {
		System.out.println("<<<<< Extrato >>>>>");
		System.out.println("\n");
		System.out.println("Titular: " + this.Pessoa.getNomeCompleto());
		System.out.println("Número conta: " + this.numeroConta);
		System.out.println("Número agência: " + this.numeroAgencia);
		System.out.println("Banco: " + this.banco);
		System.out.println("Histórico: " + this.historico);
		System.out.println("Saldo: R$ " + this.saldo);

		this.historico.add("Extrato exibido com sucesso");
	}

	private boolean isValidAction(float saldo, float valorTransacao) {
		float restante = saldo - valorTransacao;
		return restante >= 0 && valorTransacao > 0;
	}

	public String getLastTransacion(){
		int lastIndex = this.historico.size() -1;
		return this.historico.get(lastIndex);
	}

}
