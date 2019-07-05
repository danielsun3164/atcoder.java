package abc032;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int n = scanner.nextInt();
			int lcm = lcm(a, b);
			System.out.println(((n - 1) / lcm + 1) * lcm);
		}
	}

	/**
	 * @param n
	 * @param m
	 * @return nとmの最小公倍数
	 */
	private static int lcm(int n, int m) {
		return n / gcd(n, m) * m;
	}

	/**
	 * @param n
	 * @param m
	 * @return nとmの最大公約数
	 */
	private static int gcd(int n, int m) {
		if (n > m) {
			return gcd(m, n);
		}
		if (0 == n) {
			return m;
		}
		return gcd(n, m % n);
	}
}
