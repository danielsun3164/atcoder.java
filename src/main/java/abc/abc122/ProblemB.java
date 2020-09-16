package abc.abc122;

import java.util.Scanner;
import java.util.Set;

public class ProblemB {

	/** ACGTの文字のセット */
	private static final Set<Character> SET = Set.of('A', 'C', 'G', 'T');

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			int current = 0, max = 0;
			for (char a : s.toCharArray()) {
				if (SET.contains(a)) {
					current++;
				} else {
					if (current > max) {
						max = current;
					}
					current = 0;
				}
			}
			if (current > max) {
				max = current;
			}
			System.out.println(max);
		}
	}
}
