package abc.abc151_200.abc198;

import java.util.Scanner;

public class ProblemB {

	/** 0を表す文字 */
	private static final char ZERO = '0';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] n = scanner.next().toCharArray();
			int start = 0, end = n.length - 1;
			while ((start < n.length) && (ZERO == n[start])) {
				start++;
			}
			while ((end >= 0) && (ZERO == n[end])) {
				end--;
			}
			System.out.println(isPalindrome(n, start, end) ? "Yes" : "No");
		}
	}

	/**
	 * 文字列sのstartからendまでの部分が回文かどうかを計算する
	 *
	 * @param s     文字列
	 * @param start
	 * @param end
	 * @return 文字列のstartからendまでの部分が回文かどうか
	 */
	private static boolean isPalindrome(char[] s, int start, int end) {
		while (end > start) {
			if (s[start] != s[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
