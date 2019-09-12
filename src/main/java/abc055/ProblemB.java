package abc055;

import java.util.Scanner;

public class ProblemB {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(calcFractorialMod(n));
		}
	}

	/**
	 * @param n
	 * @return nの階乗 mod MOD
	 */
	private static long calcFractorialMod(int n) {
		long result = 1L;
		for (int i = 2; i <= n; i++) {
			result = result * i % MOD;
		}
		return result;
	}
}
