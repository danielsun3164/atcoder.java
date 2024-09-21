package other.math_and_algorithm;

import java.util.Scanner;

public class Problem007 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			int lcm = x / gcd(x, y) * y;
			System.out.println(n / x + n / y - n / lcm);
		}
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static int gcd(int a, int b) {
		return (0 == b) ? a : gcd(b, a % b);
	}
}
