public class Atividade02
{
	public static void main(String[] args) {
        ContaCorrente contaRenner = new ContaCorrente("Renner Borges", 3801654, 5874, "NuBank");
		ContaCorrente contaMarcel = new ContaCorrente("Marcel", 1035421, 2340, "Bradesco");

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