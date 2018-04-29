import java.util.Arrays;
import java.util.Scanner;

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
