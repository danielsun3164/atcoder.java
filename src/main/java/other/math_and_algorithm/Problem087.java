package other.math_and_algorithm;

import java.util.Scanner;

public class Problem087 {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long sum = (n + 1) * n / 2 % MOD;
			System.out.println(sum * sum % MOD);
		}
	}
}
