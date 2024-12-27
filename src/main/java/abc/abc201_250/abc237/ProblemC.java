package abc.abc201_250.abc237;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** a */
	private static final char A = 'a';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			if (n == IntStream.range(0, n).filter(i -> A == s[i]).count()) {
				System.out.println("Yes");
				return;
			}
			int start = IntStream.range(0, n).filter(i -> s[i] != A).findFirst().getAsInt(), end = IntStream
					.iterate(n - 1, i -> i >= 0, i -> i - 1).filter(i -> A != s[i]).findFirst().getAsInt();
			System.out.println((isPalindrome(s, start, end) && (n - 1 - end >= start)) ? "Yes" : "No");
		}
	}

	/**
	 * 文字列sの[start,end]が回文かどうかを判定する
	 *
	 * @param s
	 * @param start
	 * @param end
	 * @return 文字列sの[start,end]が回文かどうか
	 */
	private static boolean isPalindrome(char[] s, int start, int end) {
		while (end > start) {
			if (s[start++] != s[end--]) {
				return false;
			}
		}
		return true;
	}
}
