import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class MergeSortCountingInversions {

	static long countInversions(int[] arr) {
		mergesort(arr);
		return 0;
	}

	public static void mergesort(int[] array) {
		mergesort(array, new int[array.length], 0, array.length - 1);
	}

	private static void mergesort(int[] array, int[] temp, int startIndex, int endIndex) {
		if (startIndex >= endIndex)
			return;
		int pivot = (startIndex + endIndex) / 2;
			
		mergesort(array, temp, startIndex, pivot); // Merge Left side
		mergesort(array, temp, pivot + 1, endIndex); // Merge Right Side
		mergeHalves(array, temp, startIndex, endIndex);
	}

	private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		int[] leftSide = new int[leftEnd - leftStart + 1];
		System.arraycopy(array, leftStart, leftSide, 0, leftSide.length);
		
		int[] rightSide = new int[rightEnd - rightStart + 1];
		System.arraycopy(array, rightStart, rightSide, 0, rightSide.length);
		
		System.out.println("leftSide: " + Arrays.toString(leftSide) + " / rightSide: " + Arrays.toString(rightSide));

		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		
		System.out.println("pre-copy   { temp  } : " + Arrays.toString(temp));
		System.out.println("pre-copy   { array } : " + Arrays.toString(array));

		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, 0, array, 0, size);
		
		System.out.println("post-copy  [ temp  ] : " + Arrays.toString(temp));
		System.out.println("post-copy  [ array ] : " + Arrays.toString(array));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfDatasets = in.nextInt();
		for (int x = 0; x < numberOfDatasets; x++) {
			int itemsInDataset = in.nextInt();
			int[] datasetArray = new int[itemsInDataset];
			for (int y = 0; y < itemsInDataset; y++) {
				datasetArray[y] = in.nextInt();
			}
			long result = countInversions(datasetArray);
			System.out.println(result);
		}
		in.close();
	}
}
