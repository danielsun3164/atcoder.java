package abc.abc201_250.abc246;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc246/editorial/3701 の実装
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long i = 0, j = 1_000_000L, answer = Long.MAX_VALUE >> 1;
			while (i <= j) {
				long cf = fn(i, j);
				if (cf >= n) {
					answer = Math.min(answer, cf);
					j--;
				} else {
					i++;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * f(a,b)を計算する
	 *
	 * @param a
	 * @param b
	 * @return f(a,b)
	 */
	private static long fn(long a, long b) {
		return a * a * a + a * a * b + a * b * b + b * b * b;
	}
}
