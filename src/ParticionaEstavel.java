import java.util.Arrays;
import java.util.Scanner;

public class ParticionaEstavel {
	public static int[] converteInt(String[] valores) {
		int[] array = new int[valores.length];
		for (int i = 0; i < valores.length; i++) {
			array[i] = Integer.parseInt(valores[i]);
		}
		return array;
	}

	public static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	public static void particionaEstavel(int[] array) {
		int pivot = array[0];
		int indexMenorAtual = 0;

		for (int i = 1; i < array.length; i++) {
			if (array[i] <= pivot) {
				indexMenorAtual++;
				
				int k = i;
				while (k > indexMenorAtual) {
					swap(array, k, k - 1);
					k--;
				}
			}
		}
		int j = 1;
		while (j <= indexMenorAtual) {
			swap(array, j, j - 1);
			j++;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] valores = sc.nextLine().split(" ");
		int[] array = converteInt(valores);
		particionaEstavel(array);
		System.out.println(Arrays.toString(array));
		sc.close();
	}
}
