import java.util.ArrayList;
public class Atividade02
{
	public static void main(String[] args) {
        ContaCorrente contaRenner = new ContaCorrente();
		ContaCorrente contaMarcel = new ContaCorrente();

		contaRenner.titular = "Renner Borges";
		contaRenner.numeroConta = 3801654;
		contaRenner.numeroAgencia = 5874;
		contaRenner.banco = "NuBank";

		contaMarcel.titular = "Marcel";
		contaMarcel.numeroConta = 1035421;
		contaMarcel.numeroAgencia = 2340;
		contaMarcel.banco = "Bradesco";

		contaRenner.depositar(250);
		contaRenner.sacar(150);
		contaRenner.transferir(contaMarcel, 100);
		contaRenner.transferir(contaRenner, 100);




		System.out.println("-----------------------Renner-----------------------");
		contaRenner.consultarSaldo();
		System.out.println("Historico: " + contaRenner.historico);
		System.out.println("\n-----------------------Marcel-----------------------");
		contaMarcel.consultarSaldo();
		System.out.println("Historico: " + contaMarcel.historico);



	}
}

class ContaCorrente {

	String titular;
	int numeroConta;
	int numeroAgencia;
	private float saldo;
	String banco;
	ArrayList<String> historico = new ArrayList<String>();

	void sacar(float valor){
		if(this.isValidAction(this.saldo, valor)){
			this.saldo -= valor;
			this.alert("Sucesso","Saque realizado com sucesso, seu saldo atual R$ " + this.saldo);
			this.historico.add("Saque com sucesso no valor de R$ " + valor);
		}else{
			this.alert("Alerta","Não foi possivel realizar o saque pois sua conta não possui o valor de R$ " + valor + ", seu saldo atual é de R$ " + this.saldo);
			this.historico.add("Saque não efetuado no valor de R$ " + valor);
		}
	}

	void depositar(float valor){
		this.saldo += valor;
		this.alert("Sucesso","Deposito realizado com sucesso, seu saldo atual: R$ " + this.saldo);
		this.historico.add("Deposito com sucesso no valor de R$ " + valor);
	}

	void transferir(ContaCorrente conta,float valor){
		if(conta.titular == this.titular){
			this.alert("Alerta","Não é possivel transferir para você mesmo!");
			this.historico.add("Transferencia não efetuada para " + conta.titular + " no valor de R$ " + valor);
			return;
		}

		if(this.isValidAction(this.saldo, valor)){
			this.saldo -= valor;
			conta.saldo += valor;
			this.historico.add("Transferencia com sucesso para "+ conta.titular +" no valor de R$ " + valor);
			conta.historico.add("Transferencia recebida de " + this.titular + " no valor de R$" + valor);

			this.alert("Sucesso"," Transferencia com o valor de R$ " + valor + " realizada com sucesso,\n para a conta de número " + conta.numeroConta + " e agência " + conta.numeroAgencia + " com o titular " + conta.titular + " pertencente ao banco " + conta.banco + ".\n Seu saldo atual é de R$ " + this.saldo);
		}else{
			this.alert("Alerta","Não foi possivel realizar a transferencia pois sua conta não possui o valor de valor R$ " + valor + ", seu saldo atual é de R$ " + this.saldo);
			this.historico.add("Transferencia não efetuada para " + this.titular + " no valor de R$ " + valor);
		}
	}

	void consultarSaldo(){
		System.out.println("Saldo: R$" + this.saldo);
	}

	boolean isValidAction(float saldo, float valorTransacao){
		float restante = saldo - valorTransacao;
		return restante >= 0;
	}

	void alert(String titulo, String motivo){
		System.out.println("\n----------------"+ titulo +"---------------");
		System.out.println(motivo);
		System.out.println("------------------------------------\n");
	}
}
