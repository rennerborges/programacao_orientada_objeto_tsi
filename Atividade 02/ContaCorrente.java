import java.util.ArrayList;

public class ContaCorrente {

	String titular;
	int numeroConta;
	int numeroAgencia;
	private float saldo;
	String banco;
	ArrayList<String> historico = new ArrayList<String>();

	boolean sacar(float valor){
		if(this.isValidAction(this.saldo, valor)){
			this.saldo -= valor;
			this.alert("Sucesso","Saque realizado com sucesso, seu saldo atual R$ " + this.saldo);
			this.historico.add("Saque com sucesso no valor de R$ " + valor);
			return true;
		}else{
			this.alert("Alerta","Não foi possivel realizar o saque pois sua conta não possui o valor de R$ " + valor + ", seu saldo atual é de R$ " + this.saldo);
			this.historico.add("Saque não efetuado no valor de R$ " + valor);
			return false;
		}
	}

	boolean depositar(float valor){
		if(valor < 0){
			this.alert("Alerta","Não é possivel depositar valores menores que zero.");
			this.historico.add("Deposito não efetuado no valo de R$ " + valor);
			return false;
		}
		this.saldo += valor;
		this.alert("Sucesso","Deposito recebido com sucesso, seu saldo atual: R$ " + this.saldo);
		this.historico.add("Deposito recebido com sucesso no valor de R$ " + valor);
		return true;
	}

	boolean transferir(ContaCorrente conta,float valor){

		if(conta.titular == this.titular){
			this.alert("Alerta","Não é possivel transferir para você mesmo!");
			this.historico.add("Transferencia não efetuada, não é possivel transferir para você mesmo.");
			return false;
		}

		if(sacar(valor)){
			this.alert("Sucesso"," Transferencia com o valor de R$ " + valor + " realizada com sucesso,\n para a conta de número " + conta.numeroConta + " e agência " + conta.numeroAgencia + " com o titular " + conta.titular + " pertencente ao banco " + conta.banco + ".\n Seu saldo atual é de R$ " + this.saldo);
			return conta.depositar(valor);
		}

		return false;
	}

	void consultarSaldo(){
		System.out.println("Saldo: R$" + this.saldo);
	}

	boolean isValidAction(float saldo, float valorTransacao){
		float restante = saldo - valorTransacao;
		return restante >= 0 && valorTransacao > 0;
	}

	void alert(String titulo, String motivo){
		System.out.println("\n----------------"+ titulo +"---------------");
		System.out.println(motivo);
		System.out.println("------------------------------------\n");
	}
}

