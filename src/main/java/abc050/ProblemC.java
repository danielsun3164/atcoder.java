package abc050;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] count = new int[n], inputCount = new int[n];
			Arrays.fill(count, 0);
			Arrays.fill(inputCount, 0);
			if (1 == (n & 1)) {
				// nが奇数の場合
				count[0] = 1;
				IntStream.rangeClosed(1, n / 2).forEach(i -> count[2 * i] = 2);
			} else {
				// nが偶数の場合
				IntStream.range(0, n / 2).forEach(i -> count[2 * i + 1] = 2);
			}
			IntStream.range(0, n).forEach(i -> inputCount[scanner.nextInt()]++);
			System.out.println(Arrays.equals(count, inputCount) ? pow_mod(2, n / 2) : 0);
		}
	}

	/**
	 * @param n
	 * @param m
	 * @return n^m mod MOD を返す
	 */
	private static long pow_mod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (m & 1)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
