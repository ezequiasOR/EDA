import java.util.Scanner;
import java.util.Stack;

public class InverteFrase {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		Scanner sc = new Scanner(System.in);
		String phrase = sc.nextLine();
		String word = "";
		
		for (int i = 0; i < phrase.length(); i++) {
			if (Character.isSpaceChar(phrase.charAt(i))) {
				stack.push(word);
				word = "";
			} else {
				word += phrase.charAt(i);
			}
		}
		stack.push(word);
		
		String inversePhrase = "";
		while (!stack.isEmpty()) {
			inversePhrase += stack.pop() + " ";
		}
		inversePhrase = inversePhrase.trim();
		
		System.out.println(inversePhrase);
		sc.close();
	}
}
