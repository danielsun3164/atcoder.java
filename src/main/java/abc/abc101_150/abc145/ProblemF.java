package abc.abc101_150.abc145;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc145/submissions/8505085 にも参考
 */
public class ProblemF {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] h = new int[n + 1];
			h[0] = 0;
			IntStream.rangeClosed(1, n).forEach(i -> h[i] = scanner.nextInt());
			long[][] dp = new long[n + 1][n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], INF));
			dp[0][0] = 0L;
			IntStream.rangeClosed(1, n).forEach(x -> IntStream.rangeClosed(1, x).forEach(y -> dp[x][y] = IntStream
					.range(0, x).mapToLong(i -> dp[i][y - 1] + Math.max(0, h[x] - h[i])).min().orElse(INF)));
			System.out.println(IntStream.rangeClosed(0, n).mapToLong(i -> dp[i][n - k]).min().getAsLong());
		}
	}
}
