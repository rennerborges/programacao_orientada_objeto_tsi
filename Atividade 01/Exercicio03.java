import java.util.Scanner;
import java.util.Locale;

public class Exercicio03
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

		System.out.println("Informe um número:");
		int repeticoes = scanner.nextInt();

		int soma = 0;
		int a = 0;
		int b = 1;

		for (int i = 0; i < repeticoes; i++){
			a= b;
			b= soma;
			soma = a+b;
		}

		System.out.println("O resultado é " + soma);
	}
}
