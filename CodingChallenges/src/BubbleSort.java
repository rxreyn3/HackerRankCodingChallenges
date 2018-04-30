import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	private static void sortArray(int[] unsortedArray) {

		int totalSwaps = 0;
		boolean sorted = false;
		int unsortedSize = unsortedArray.length - 1;
		while (!sorted) {
			sorted = true;
			System.out.println("Starting pass.");
			for (int i = 0; i < unsortedSize; i++) {
				if (unsortedArray[i] > unsortedArray[i + 1]) {
					swap(unsortedArray, i, i + 1);
					totalSwaps++;
					sorted = false;
				}
			}
			unsortedSize--;
		}
		System.out.println(String.format("Array is sorted in %d swaps.", totalSwaps));
		System.out.println(String.format("First Element: %d", unsortedArray[0]));
		System.out.println(String.format("Last Element: %d", unsortedArray[unsortedArray.length - 1]));
	}

	private static void swap(int[] unsortedArray, int left, int right) {
		int temp = unsortedArray[left];
		unsortedArray[left] = unsortedArray[right];
		unsortedArray[right] = temp;
		System.out.println(Arrays.toString(unsortedArray));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfElements = in.nextInt();
		int[] unsortedArray = new int[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			unsortedArray[i] = in.nextInt();
		}
		in.close();

		long startTime = System.nanoTime();
		sortArray(unsortedArray);
		long difference = System.nanoTime() - startTime;
		System.out.println("Total execution time: " + String.format("%d ms", difference));
	}

}
