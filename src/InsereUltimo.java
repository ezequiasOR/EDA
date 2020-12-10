import java.util.Arrays;
import java.util.Scanner;

public class InsereUltimo {
	
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
	
	public static void insereUltimo(int[] array) {
		int i = array.length-1;
		while (i > 0 && array[i-1] > array[i]) {
			swap(array, i-1, i);
			i--;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] valores = sc.nextLine().split(" ");
		int[] array = converteInt(valores);
		insereUltimo(array);
		System.out.println(Arrays.toString(array));
		sc.close();
	}
}
