import java.util.Scanner;

public class Duplicados {
	public static void main(String[] args) {
		boolean saida = true;
		Scanner entrada = new Scanner(System.in);
		String[] valores = entrada.nextLine().split(" ");
		
		for (int i = 0; i < valores.length; i++) {
			for (int j = 0; j < valores.length; j++) {
				if (i != j && valores[i].equals(valores[j])) {
					System.out.println(saida);
					saida = false;
					break;
				}
			}
			if (!saida) {
				break;
			}
		}
		
		if (saida) {
			saida = false;
			System.out.println(saida);
		}
		
	}
}
