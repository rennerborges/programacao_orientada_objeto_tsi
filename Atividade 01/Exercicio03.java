import java.util.Scanner;
import java.util.Locale;

public class Exercicio03
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

		System.out.println("Informe um número:");
		int repeticoes = scanner.nextInt();

		System.out.println("Deseja ver as etapas?");
		boolean isViewTriangle = scanner.nextBoolean();

		int views[] = new int[repeticoes];

		int soma = 0;
		int a = 0;
		int b = 1;

		System.out.println("\n");
		for (int i = 0; i < repeticoes; i++){
			a= b;
			b= soma;
			soma = a+b;

			views[i] = soma;

			if(isViewTriangle == true){
				for(int view: views){
					if(view != 0){
						System.out.printf("%d", view);
					}
				}
				System.out.println("");
			}
		}

		if(isViewTriangle == true){
			System.out.println("\n");
		}

		System.out.println("O resultado é " + soma);
	}
}
