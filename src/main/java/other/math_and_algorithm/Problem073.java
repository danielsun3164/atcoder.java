package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem073 {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;
	/** 2 */
	private static final int N = 2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray(), pow2 = new long[n + 1];
			pow2[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> pow2[i] = pow2[i - 1] * N % MOD);
			System.out.println(IntStream.range(0, n).mapToLong(i -> a[i] * pow2[i] % MOD).sum() % MOD);
		}
	}
}
