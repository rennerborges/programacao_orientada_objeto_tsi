import java.util.Scanner;
import java.util.Locale;

public class Exercicio04
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
		byte valorMaximo = 10;
		byte valores[] = new byte[valorMaximo];
		byte valoresInvertidos[] = new byte[valorMaximo];

		for(byte i =0; i < valorMaximo; i++){

			System.out.println("Informe um número:");
			byte valor = scanner.nextByte();

			int indexInvertido = (valorMaximo-1)-i;
			valores[i] = valor;
			valoresInvertidos[indexInvertido] = valor;
		}

		System.out.println("Vetor original:");
		for(byte valor : valores){
			System.out.printf("%d ", valor);
		}

		System.out.println("\n");

		System.out.println("Vetor invertido:");
		for(byte valor : valoresInvertidos){
			System.out.printf("%d ", valor);
		}

		System.out.println("\n");

	}
}
