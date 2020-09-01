package abc.abc066;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int result = s.length;
			for (int i = 1; i < s.length / 2; i++) {
				result = s.length - i * 2;
				if (check(s, result)) {
					break;
				}
			}
			System.out.println(result);
		}
	}

	/**
	 * @param s 入力文字列
	 * @param n 文字数
	 * @return sの最初のn文字が偶文字列かどうか
	 */
	private static boolean check(char[] s, int n) {
		int half = n / 2;
		for (int i = 0; i < half; i++) {
			if (s[i] != s[half + i]) {
				return false;
			}
		}
		return true;
	}
}
