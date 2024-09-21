package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem030 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), w = scanner.nextInt();
			int[] ws = new int[n];
			long[] v = new long[n];
			IntStream.range(0, n).forEach(i -> {
				ws[i] = scanner.nextInt();
				v[i] = scanner.nextLong();
			});
			long[] dp = new long[w + 1];
			Arrays.fill(dp, -INF);
			dp[0] = 0L;
			IntStream.range(0, n).forEach(i -> IntStream.rangeClosed(0, w - ws[i]).map(j -> w - ws[i] - j)
					.filter(j -> dp[j] >= 0L).forEach(j -> dp[j + ws[i]] = Math.max(dp[j + ws[i]], dp[j] + v[i])));
			System.out.println(IntStream.rangeClosed(0, w).mapToLong(i -> dp[i]).max().getAsLong());
		}
	}
}
