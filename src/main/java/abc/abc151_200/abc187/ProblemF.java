package abc.abc151_200.abc187;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc187/submissions/19103570 にも参考
 */
public class ProblemF {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[m], b = new int[m], edges = new int[n];
			Arrays.fill(edges, 0);
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
				edges[a[i]] |= 1 << b[i];
				edges[b[i]] |= 1 << a[i];
			});
			int[] dp = new int[1 << n];
			Arrays.fill(dp, INF);
			dp[0] = 1;
			IntStream.range(0, n).forEach(i -> IntStream.range(0, 1 << n)
					.filter(j -> (1 == dp[j]) && (j == (edges[i] & j))).forEach(j -> dp[j | 1 << i] = 1));
			IntStream.range(0, 1 << n).forEach(i -> {
				for (int j = (i - 1) & i; j > 0; j = (j - 1) & i) {
					dp[i] = Math.min(dp[i], dp[i ^ j] + dp[j]);
				}
			});
			System.out.println(dp[(1 << n) - 1]);
		}
	}
}
