package abc.abc151_200.abc177;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[] sum = new long[n];
			sum[0] = a[0];
			IntStream.range(1, n).forEach(i -> sum[i] = (sum[i - 1] + a[i]) % MOD);
			long answer = 0L;
			for (int i = 0; i < n - 1; i++) {
				answer = (answer + a[i] * (sum[n - 1] - sum[i]) % MOD) % MOD;
			}
			System.out.println((answer + MOD) % MOD);
		}
	}
}
