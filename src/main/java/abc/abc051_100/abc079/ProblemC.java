package abc.abc051_100.abc079;

import java.util.Scanner;

public class ProblemC {

	/** 7 */
	private static final int SEVEN = 7;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] abcd = scanner.next().toCharArray();
			for (int i = 0; i < (1 << abcd.length); i++) {
				if (ok(abcd, i)) {
					System.out.println(toFormula(abcd, i) + "=" + SEVEN);
					return;
				}
			}
		}
	}

	/**
	 * abcdと'+'か'-'を表す二進数で数式を組み立てて、結果が7かどうかを判定
	 * 
	 * @param abcd
	 * @param n    '+'か'-'を表す二進数
	 * @return 結果が7かどうか
	 */
	private static boolean ok(char[] abcd, int n) {
		int result = abcd[0] - '0';
		for (int i = 1; i < abcd.length; i++) {
			if (1 == (n & 1)) {
				result += abcd[i] - '0';
			} else {
				result -= abcd[i] - '0';
			}
			n >>= 1;
		}
		return SEVEN == result;
	}

	/**
	 * abcdと'+'か'-'を表す二進数で数式を組み立てる
	 * 
	 * @param abcd
	 * @param n    '+'か'-'を表す二進数
	 * @return a?b?c?d の数式
	 */
	private static String toFormula(char[] abcd, int n) {
		StringBuilder result = new StringBuilder();
		for (char c : abcd) {
			result.append(c);
			result.append((1 == (n & 1)) ? '+' : '-');
			n >>= 1;
		}
		// 最後の文字を削除
		result.deleteCharAt(result.length() - 1);
		return result.toString();
	}
}
