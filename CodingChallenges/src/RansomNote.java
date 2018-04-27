import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

	Map<String, Integer> magazineWords = null;
	Map<String, Integer> ransomWords = null;

	public RansomNote(String magazine, String note) {
		magazineWords = ConvertToMap(magazine);
		ransomWords = ConvertToMap(magazine);
	}

	private Map<String, Integer> ConvertToMap(String words) {
		Map<String, Integer> wordFreq = new HashMap<String, Integer>();
		String[] wordsList = words.split(" ");
		for (String word : wordsList) {
			if (wordFreq.containsKey(word))
				wordFreq.put(word, 0);
			wordFreq.put(word, wordFreq.get(word) + 1);
		}
		return wordFreq;
	}

	public boolean solve() {
		for (String key : ransomWords.keySet()) {
			if (magazineWords.containsKey(key)) {
				if (magazineWords.get(key).intValue() < ransomWords.get(key).intValue())
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		// Eat whitespace to beginning of next line
		scanner.nextLine();

		RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		if (m < n) {
			System.out.println("No");
		} else {
			boolean answer = s.solve();
			if (answer)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
