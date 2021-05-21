public class Atividade02
{
	public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente();

		conta.depositar(50);
		System.out.println("Saldo: R$ " + conta.saldo);
		conta.sacar(150);
		System.out.println("Saldo: R$ " + conta.saldo);
		conta.transferir("Marcel", 12345678, 3210, 60, "Santander");
		System.out.println("Saldo: R$ " + conta.saldo);
	}
}

class ContaCorrente {

	String titular;
	int numeroConta;
	int numeroAgencia;
	float saldo;
	String banco;

	void sacar(float valor){
		if(this.isValidAction(this.saldo, valor)){
			this.saldo -= valor;
			this.alert("Sucesso","Saque realizado com sucesso, seu saldo atual R$ " + this.saldo);
		}else{
			this.alert("Alerta","Não foi possivel realizar o saque pois sua conta não possui o valor de R$ " + valor + ", seu saldo atual é de R$ " + this.saldo + ", seu saldo atual é de R$ " + this.saldo);
		}
	}

	void depositar(float valor){
		this.saldo += valor;
		this.alert("Sucesso","Deposito realizado com sucesso, seu saldo atual: R$ " + this.saldo);
	}

	void transferir(String titular, int numeroConta, int numeroAgencia, float valor, String banco){
		if(this.isValidAction(this.saldo, valor)){
			this.saldo -= valor;
			this.alert("Sucesso"," Transferencia com o valor de R$ " + valor + " realizada com sucesso,\n para a conta de número " + numeroConta + " e agência " + numeroAgencia + " com o titular " + titular + " pertencente ao banco " + banco + ".\n Seu saldo atual é de R$ " + this.saldo);
		}else{
			this.alert("Alerta","Não foi possivel realizar a transferencia pois sua conta não possui o valor de valor R$ " + valor + ", seu saldo atual é de R$ " + this.saldo);
		}
	}

	boolean isValidAction(float saldo, float valorTransacao){
		float restante = saldo - valorTransacao;
		return restante >= 0;
	}

	void alert(String titulo, String motivo){
		System.out.println("----------------"+ titulo +"---------------");
		System.out.println(motivo);
		System.out.println("------------------------------------");
	}
}
