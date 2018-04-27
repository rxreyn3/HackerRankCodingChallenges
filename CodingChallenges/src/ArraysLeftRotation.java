import java.util.Scanner;

public class ArraysLeftRotation {

	public static int[] rotateArray(int[] arr, int numberOfRotations) {
		// Because the constraints state d < n, we need not concern ourselves with
		// shifting > n units.
		int n = arr.length;

		// Create new array for rotated elements:
		int[] rotated = new int[n];

		// Copy segments of shifted elements to rotated array:
		// System.arraycopy(arr, d, rotated, 0, n - d);
		// System.arraycopy(arr, 0, rotated, n - d, d);

		System.out.println("Source Pos: " + numberOfRotations + " Dest Pos: 0 Length: " + (n - numberOfRotations));
		System.out.println("Source Pos: 0 Dest Pos: " + (n - numberOfRotations) + " Length: " + numberOfRotations);

		System.arraycopy(arr, numberOfRotations, rotated, 0, n - numberOfRotations);
		System.arraycopy(arr, 0, rotated, n - numberOfRotations, numberOfRotations);

		return rotated;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int numberOfIntegers = scanner.nextInt();
		int numberOfRotations = scanner.nextInt();
		int[] numbers = new int[numberOfIntegers];

		// Fill initial array:
		for (int i = 0; i < numberOfIntegers; i++) {
			numbers[i] = scanner.nextInt();
		}
		scanner.close();

		// Rotate array by d elements:
		numbers = rotateArray(numbers, numberOfRotations);

		// Print array's elements as a single line of space-separated values:
		for (int i : numbers) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}