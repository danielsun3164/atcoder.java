package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem049 {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] f = new long[n + 1];
			f[1] = f[2] = 1L;
			IntStream.rangeClosed(3, n).forEach(i -> f[i] = (f[i - 1] + f[i - 2]) % MOD);
			System.out.println(f[n]);
		}
	}
}
