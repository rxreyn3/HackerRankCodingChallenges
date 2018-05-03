import java.util.Objects;
import java.util.Scanner;

import org.apache.commons.lang3.builder.ToStringBuilder;

/*
 * Go through an array and print out all of the elements
 * Determine whether or not a string is a palindrome
 * Calculate a raised to the power of b
 * Extra credit: Try implementing the map function (the one that transforms arrays) without using loops
 */
public class RecursionPractice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfElements = scanner.nextInt();
		int[] numbers = new int[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			numbers[i] = scanner.nextInt();
		}
		scanner.close();
		printArrayInReverseOrder(numbers);
		System.out.println("Factorial of: " + numberOfElements + " : " + factorial(numberOfElements));
		CreateBinaryTree(numbers);
	}

	private static void printArrayInReverseOrder(int[] numbers) {
		printArrayInReverseOrder(numbers, numbers.length - 1);
	}

	private static void printArrayInReverseOrder(int[] numbers, int index) {
		if (index < 0)
			return;
		System.out.println(numbers[index]);
		printArrayInReverseOrder(numbers, index - 1);
	}

	private static int factorial(int n) {
		if (n <= 1)
			return 1;

		return n * factorial(n - 1);
	}

	private static void CreateBinaryTree(int[] numbers) {
		BinaryTreeNode root = new BinaryTreeNode(numbers[numbers.length / 2]);
		for (int i = 0; i < numbers.length; i++) {
			root.AddNode(new BinaryTreeNode(numbers[i]));
		}
		System.out.println(Objects.toString(root));
	}

	public static class BinaryTreeNode {
		int value;
		BinaryTreeNode left = null;
		BinaryTreeNode right = null;

		public BinaryTreeNode(int value) {
			this.value = value;
		}

		public void AddNode(BinaryTreeNode nodeToAdd) {
			if (nodeToAdd.value >= value) {
				if (right == null) {
					right = nodeToAdd;
				} else {
					right.AddNode(nodeToAdd);
				}
			} else {
				if (left == null) {
					left = nodeToAdd;
				} else {
					left.AddNode(nodeToAdd);
				}
			}
		}
		
		@Override
		public String toString() {
			return new ToStringBuilder(this).append("value", value).toString();
		}
	}
}