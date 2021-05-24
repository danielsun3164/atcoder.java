package abc.abc201_250.abc202;

import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			long k = scanner.nextLong();
			System.out.println(solve(a, b, k));
		}
	}

	/**
	 * a個の'a'とb個の'b'から構成される文字列の辞書順でk番目のものを計算する
	 *
	 * @param a 文字'a'の数
	 * @param b 文字'b'の数
	 * @param k 順番
	 * @return a個の'a'とb個の'b'から構成される文字列の辞書順でk番目のもの
	 */
	private static String solve(int a, int b, long k) {
		if (1L == k) {
			return "a".repeat(a) + "b".repeat(b);
		}
		long half = calc(a - 1, b);
		if (k <= half) {
			return "a" + solve(a - 1, b, k);
		} else {
			return "b" + solve(a, b - 1, k - half);
		}
	}

	/**
	 * a個の'a'とb個ので構成される文字列の数
	 *
	 * @param a 文字'a'の数
	 * @param b 文字'b'の数
	 * @return a個の'a'とb個ので構成される文字列
	 */
	private static long calc(int a, int b) {
		long result = 1L;
		for (int i = 1; i <= Math.min(a, b); i++) {
			result *= (a + b + 1) - i;
			result /= i;
		}
		return result;
	}
}
