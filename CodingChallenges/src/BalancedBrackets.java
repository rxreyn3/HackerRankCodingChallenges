import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	public static char[][] TOKENS = { { '{', '}' }, { '[', ']' }, { '(', ')' } };

	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : expression.toCharArray()) {
			if (isOpenTerm(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty() || !matches(stack.pop(), c)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private static boolean matches(Character openTerm, char closeTerm) {
		for (char[] array : TOKENS) {
			if (array[0] == openTerm) {
				return array[1] == closeTerm;
			}
		}
		return false;
	}

	private static boolean isOpenTerm(char c) {
		for (char[] array : TOKENS) {
			if (array[0] == c) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
	}
}
