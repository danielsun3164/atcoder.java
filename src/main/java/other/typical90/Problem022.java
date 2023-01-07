package other.typical90;

import java.util.Scanner;

public class Problem022 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
			long gcd = gcd(gcd(a, b), c);
			System.out.println(((a / gcd) - 1) + ((b / gcd) - 1) + ((c / gcd) - 1));
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
		return (0 == b) ? a : gcd(b, a % b);
	}
}
