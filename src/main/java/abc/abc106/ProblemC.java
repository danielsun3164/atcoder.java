package abc.abc106;

import java.util.Scanner;

public class ProblemC {

	/** 1の文字 */
	private static final char ONE = '1';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			long k = scanner.nextLong();
			for (char c : s) {
				if (ONE == c) {
					k--;
					if (0L == k) {
						System.out.println(c);
						return;
					}
				} else {
					System.out.println(c);
					return;
				}
			}
		}
	}
}
