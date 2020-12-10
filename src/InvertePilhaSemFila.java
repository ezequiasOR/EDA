import java.util.Scanner;
import java.util.Stack;

public class InvertePilhaSemFila {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		Scanner sc = new Scanner(System.in);
		int tamanhoPilha = sc.nextInt();
		
		for (int i = 0; i < tamanhoPilha; i++) {
			stack.push(sc.nextInt());
		}

		if (stack.isEmpty()) {
			System.out.println("");
		} else {
			String saida = "";
			saida = Integer.toString(stack.pop()) + saida;
			for (int i = tamanhoPilha; i > 1; i--) {
				String elemento = Integer.toString(stack.pop());
				saida = elemento + "\n" + saida;
			}
			System.out.println(saida);
		}
		sc.close();
	}
		
}
