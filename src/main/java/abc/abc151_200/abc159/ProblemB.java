package abc.abc151_200.abc159;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			int n = s.length();
			System.out.println((isPalindromic(s) && isPalindromic(s.substring(0, n / 2))
					&& isPalindromic(s.substring((n + 2) / 2))) ? "Yes" : "No");
		}
	}

	/**
	 * 入力文字列が回文かどうかをチェックする
	 *
	 * @param string
	 * @return 入力文字列が回文かどうか
	 */
	private static boolean isPalindromic(String string) {
		char[] s = string.toCharArray();
		int n = s.length;
		for (int i = 0; i < n / 2; i++) {
			if (s[i] != s[n - 1 - i]) {
				return false;
			}
		}
		return true;
	}
}
