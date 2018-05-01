import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ryanreynolds
 * 
 *         The idea here is to build an array using the ordinal value of the
 *         alphabet as a key. The words are broken down in to character values
 *         and stored in the array with their count. The first word passed in
 *         increases the array character count value, and the second decreases.
 *         The idea being that if the words are anagrams of each other, the
 *         resulting array should be all zeros.
 *
 */
public class Anagram {

	public static int numberNeeded(String first, String second) {
		int[] alphabet = new int[26];
		for (Character character : first.toLowerCase().toCharArray()) {
			alphabet[character - 'a']++;
		}
		for (Character character : second.toLowerCase().toCharArray()) {
			alphabet[character - 'a']--;
		}
		int deletions = 0;
		for (int i : alphabet) {
			deletions += Math.abs(i);
		}
		return deletions;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}

}
