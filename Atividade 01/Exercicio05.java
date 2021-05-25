import java.util.Scanner;
import java.util.Locale;

public class Exercicio05
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

		int valorInformado = 0;
		int quantidadeNumeros = 0;
		float media = 0;
		int soma = 0;
		int maior = 0;
		int menor = 0;

		do {
			System.out.println("Informe um número:");
			valorInformado = scanner.nextInt();
			if(valorInformado == -1){
				break;
			}
			soma += valorInformado;
			quantidadeNumeros++;

			if(valorInformado > maior){
				maior = valorInformado;
			}

			if(valorInformado < menor || menor == 0){
				menor = valorInformado;
			}

		} while(valorInformado != -1);

		media = soma/quantidadeNumeros;

		System.out.println("\n");
		System.out.println("Resultado da sua utilização");
		System.out.println("-------------------------------");
		System.out.println("Quantidade de números: " + quantidadeNumeros);
		System.out.println("Maior: " + maior);
		System.out.println("Menor: " + menor);
		System.out.println("Soma: " + soma);
		System.out.println("Média: " + media);

		scanner.close();
	}
}
