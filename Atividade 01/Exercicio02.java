import java.util.Scanner;
import java.util.Locale;

public class Exercicio02
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

		System.out.println("Informe o valor a ser sacado:");
		float valorSaque = scanner.nextFloat();
		float valorRestante = valorSaque;

		byte notas[] = { 50, 10, 5, 1 };
		int quantidadeNotasTotal[] = new int[4];
		byte indexNota = 0;

		while(valorRestante > 0){
			byte nota = notas[indexNota];
			int quantidadeNotas = (int)valorRestante / nota;

			if(quantidadeNotas != 0){
				quantidadeNotasTotal[indexNota] = quantidadeNotas;
				valorRestante -= nota * quantidadeNotas;
			}else{
				indexNota++;
			}
		}

		System.out.println("--------------------");
		System.out.println("Resumo da operação");
		System.out.println("--------------------");
		System.out.println("Valor sacado: R$:" + valorSaque);
		System.out.println("");
		System.out.println("Notas retiradas:");
		System.out.println("");

		for(int i =0; i < notas.length; i++){
			byte nota = notas[i];
			int quantidadeNotas = quantidadeNotasTotal[i];
			System.out.println( quantidadeNotas + " de R$: " + nota + ",00");
		}
	}
}
