import java.util.Scanner;

public class GCD {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		scanner.close();
		
		int gcd = a > b ? computeGCD(a, b) : computeGCD(b, a);
		
		System.out.println(gcd);
	}

	private static int computeGCD(int big, int small) {

		int remainder = big % small;
		
		//System.out.println("Bigger: " + big + " Smaller: " + small + " Remainder: " + remainder);
		
		if (remainder == 0)
			return small;
		else if (remainder == 1)
			return 1;
		else
			return computeGCD(small, remainder);
	}
}
