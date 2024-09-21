package other.math_and_algorithm;

import java.util.Scanner;

public class Problem088 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
			long sumA = (a + 1) * a / 2 % MOD, sumB = (b + 1) * b / 2 % MOD, sumC = (c + 1) * c / 2 % MOD;
			System.out.println(sumA * sumB % MOD * sumC % MOD);
		}
	}
}
