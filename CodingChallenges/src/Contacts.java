import java.util.Scanner;

public class Contacts {
	public static class Node {

		private static int NUMBER_OF_CHARACTERS = 26;

		Node[] children = new Node[NUMBER_OF_CHARACTERS];

		int size = 0;

		private static int getCharIndex(char c) {
			int index = c - 'a';
			return index;
		}

		private Node getNode(char c) {
			return children[getCharIndex(c)];
		}

		private void setNode(char c, Node node) {
			children[getCharIndex(c)] = node;
		}

		public void add(String s) {
			add(s, 0);
		}

		private void add(String s, int index) {
			size++;
			if (index == s.length())
				return;
			char current = s.charAt(index);
			Node child = getNode(current);
			if (child == null) {
				child = new Node();
				setNode(current, child);
			}
			child.add(s, index + 1);
		}

		public int findCount(String s, int index) {
			if (index == s.length()) {
				return size;
			}
			Node child = getNode(s.charAt(index));
			if (child == null) {
				return 0;
			}
			return child.findCount(s, index + 1);
		}

	}

	public static void main(String[] args) {
		Node node = new Node();

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			if (op.equalsIgnoreCase("add")) {
				node.add(contact);
			} else {
				System.out.println(node.findCount(contact, 0));
			}
		}
	}
}
