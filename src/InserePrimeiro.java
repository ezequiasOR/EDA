import java.util.Arrays;
import java.util.Scanner;

public class InserePrimeiro {

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

	public static void inserePrimeiro(int[] array) {
		int i = 0;
		while (i < array.length - 1 && array[i + 1] < array[i]) {
			swap(array, i, i + 1);
			i++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] valores = sc.nextLine().split(" ");
		int[] array = converteInt(valores);
		inserePrimeiro(array);
		System.out.println(Arrays.toString(array));
		sc.close();
	}
}
