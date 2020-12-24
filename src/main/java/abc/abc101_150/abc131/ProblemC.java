package abc.abc101_150.abc131;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong(), d = scanner.nextLong();
			System.out.println(
					b - a - b / c - b / d + b / lcm(c, d) + (a - 1) / c + (a - 1) / d - (a - 1) / lcm(c, d) + 1);
		}
	}

	/**
	 * @param n
	 * @param m
	 * @return nとmの最小公倍数
	 */
	private static long lcm(long n, long m) {
		return n / gcd(n, m) * m;
	}

	/**
	 * @param n
	 * @param m
	 * @return nとmの最大公約数
	 */
	private static long gcd(long n, long m) {
		if (n > m) {
			return gcd(m, n);
		}
		if (0 == n) {
			return m;
		}
		return gcd(n, m % n);
	}
}
