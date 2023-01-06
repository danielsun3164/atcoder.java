package other.typical90;

import java.util.Scanner;

public class Problem038 {

	/** 最大値 */
	private static final long MAX = 1_000_000_000_000_000_000L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong();
			long gcd = gcd(a, b);
			System.out.println((a / gcd > MAX / b) ? "Large" : String.valueOf(a / gcd * b));
		}
	}

	/**
	 * aとbの最大公約数を返す
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0L == b) ? a : gcd(b, a % b);
	}
}
