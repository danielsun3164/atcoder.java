package abc.abc070;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long result = 1;
			for (int i = 0; i < n; i++) {
				result = lcm(result, scanner.nextLong());
			}
			System.out.println(result);
		}
	}

	/**
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		long temp;
		while ((temp = a % b) != 0) {
			a = b;
			b = temp;
		}
		return b;
	}

	/**
	 * @param a
	 * @param b
	 * @return aとbの最小公倍数
	 */
	private static long lcm(long a, long b) {
		return a / gcd(a, b) * b;
	}
}
