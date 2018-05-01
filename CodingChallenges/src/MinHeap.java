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
		
		if(biggerHeap.size() == smallerHeap.size()) {
			return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
		}else {
			return biggerHeap.peek();
		}
	}

	private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > uppers.size() ? lowers : uppers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > uppers.size() ? uppers : lowers;
		if(biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
	}

	private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
		if(lowers.isEmpty() || number < lowers.peek()) {
			lowers.add(number);
		}else {
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
