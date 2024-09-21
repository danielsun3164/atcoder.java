package other.math_and_algorithm;

import java.util.Scanner;

public class Problem093 {

	/** 最大値 */
	private static final long MAX = 1_000_000_000_000_000_000L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong();
			long ga = a / gcd(a, b), maxGa = MAX / b;
			System.out.println((ga > maxGa) ? "Large" : String.valueOf(ga * b));
		}
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
