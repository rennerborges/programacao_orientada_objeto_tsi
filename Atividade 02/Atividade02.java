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