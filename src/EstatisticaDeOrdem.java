import java.util.Arrays;
import java.util.Scanner;

public class EstatisticaDeOrdem {
	public static int[] converteInt(String[] valores) {
		int[] array = new int[valores.length];
		for (int i = 0; i < valores.length; i++) {
			array[i] = Integer.parseInt(valores[i]);
		}
		return array;
	}

	public static void swap(int[] array, int i, int j) {
		int aux = array[j];
		array[j] = array[i];
		array[i] = aux;
	}

	private static int estatisticaDeOrdem(int[] array) {
		int primeiro = array[0];
		boolean achou = false;
		int i = 0;
		while (i < array.length && !achou) {

			int indexMin = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[indexMin]) {
					indexMin = j;
				}
			}
			swap(array, i, indexMin);

			if (primeiro == array[i]) {
				achou = true;
			}
			i++;
		}
		return i;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] valores = sc.nextLine().split(" ");
		int[] array = converteInt(valores);
		System.out.println(estatisticaDeOrdem(array));
		sc.close();
	}
}
