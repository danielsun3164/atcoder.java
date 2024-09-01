package abc.abc201_250.abc232;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc232/editorial/3149 の実装<br/>
 * https://atcoder.jp/contests/abc232/submissions/27978713 にも参考
 */
public class ProblemF別回答 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long x = scanner.nextLong(), y = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[] b = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[] dp = new long[1 << n];
			Arrays.fill(dp, INF);
			dp[0] = 0L;
			IntStream.range(0, 1 << n).forEach(s -> {
				int size = Integer.bitCount(s);
				IntStream.range(0, n).filter(i -> 0 == ((s >> i) & 1))
						.forEach(i -> dp[s ^ 1 << i] = Math.min(dp[s ^ (1 << i)],
								dp[s] + Math.abs(a[i] - b[size]) * x + Integer.bitCount((~s) & ((1 << i) - 1)) * y));
			});
			System.out.println(dp[(1 << n) - 1]);
		}
	}
}
