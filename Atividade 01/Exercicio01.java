import java.util.Scanner;
import java.util.Locale;

public class Exercicio01
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

		System.out.println("Informe o valor da gasolina:");
		float gasolinaValor = scanner.nextFloat();

		System.out.println("Informe o valor do etanol:");
		float etanolValor = scanner.nextFloat();

		float calculo = etanolValor/gasolinaValor;

		System.out.println("O resultado foi " + calculo);

		if(calculo <= 0.7){
			System.out.println("Abasteça com etanol");
		}else{
			System.out.println("Abasteça com gasolina");
		}

		scanner.close();
	}
}
