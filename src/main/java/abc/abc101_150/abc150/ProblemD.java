package abc.abc101_150.abc150;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long m = scanner.nextLong();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt() >> 1).sorted().toArray();
			if (check(a)) {
				System.out.println(0);
				return;
			}
			long lcm = 1L;
			for (int ai : a) {
				lcm = lcm(lcm, ai);
			}
			long count = m / lcm;
			System.out.println((count + 1) >> 1);
		}
	}

	/**
	 * 配列aに結果がないかをチェックする
	 *
	 * @param a
	 * @return 結果がない場合はtrue、ある場合はfalse
	 */
	private static boolean check(int[] a) {
		int zeros = Integer.numberOfTrailingZeros(a[0]);
		for (int i = 1; i < a.length; i++) {
			if (zeros != Integer.numberOfTrailingZeros(a[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * aとbの最小公倍数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最小公倍数
	 */
	private static long lcm(long a, long b) {
		return a / gcd(a, b) * b;
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0L == b) ? a : gcd(b, a % b);
	}
}
