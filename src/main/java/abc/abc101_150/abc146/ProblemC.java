package abc.abc101_150.abc146;

import java.util.Scanner;

public class ProblemC {

	/** 扱う整数の最大値 */
	private static final long MAX = 1_000_000_000L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), x = scanner.nextLong();
			long left = 0L, right = MAX;
			if (ok(a, b, x, right)) {
				System.out.println(right);
			} else {
				while (right > (left + 1)) {
					long middle = (left + right) / 2;
					if (ok(a, b, x, middle)) {
						left = middle;
					} else {
						right = middle;
					}
				}
				System.out.println(left);
			}
		}
	}

	/**
	 * x円で整数nが買えるかどうかを計算する
	 *
	 * @param a
	 * @param b
	 * @param x
	 * @param n
	 * @return x円で整数nが買えるかどうか
	 */
	private static boolean ok(long a, long b, long x, long n) {
		return x >= ((a * n) + (b * d(n)));
	}

	/**
	 * lの十進表記での桁数を計算する
	 *
	 * @param l
	 * @return lの十進表記での桁数
	 */
	private static int d(long l) {
		return String.valueOf(l).length();
	}
}
