package abc.abc201_250.abc232;

import java.util.Scanner;

public class ProblemB {

	/** 26 */
	private static final int N = 26;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			int diff = t[0] - s[0];
			for (int i = 0; i < s.length; i++) {
				char c = (char) (s[i] + diff);
				if (c < 'a') {
					c += N;
				}
				if (c > 'z') {
					c -= N;
				}
				if (c != t[i]) {
					System.out.println("No");
					return;
				}
			}
			System.out.println("Yes");
		}
	}
}
