import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinHeap {

	public static double[] getMedians(int[] array) {
		// MAX HEAP
		PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer left, Integer right) {
				return -1 * left.compareTo(right);
			}
		});
		// MIN HEAP
		PriorityQueue<Integer> uppers = new PriorityQueue<>();

		double[] medians = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			addNumber(number, lowers, uppers);
			rebalance(lowers, uppers);
			medians[i] = getMedian(lowers, uppers);
			System.out.println(medians[i]);
		}
		return medians;
	}

	private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > uppers.size() ? lowers : uppers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > uppers.size() ? uppers : lowers;

		if (biggerHeap.size() == smallerHeap.size()) { // If it's and even number of elements, you need to do this.
			return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
		} else { // If one of the heaps has an odd number of elements, it will be in the "bigger"
					// Q, so peek that head item as median
			return biggerHeap.peek();
		}
	}

	private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > uppers.size() ? lowers : uppers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > uppers.size() ? uppers : lowers;
		/*
		 * If there is a difference of two or more in size between these, poll the head
		 * item off and move to the other. If the bigger heap is the max heap, this will
		 * take the biggest number off the max heap and append it to the min heap
		 */
		if (biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
	}

	private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
		if (lowers.isEmpty() || number < lowers.peek()) {
			lowers.add(number);
		} else {
			uppers.add(number);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		getMedians(a);
	}

}
