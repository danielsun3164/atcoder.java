package abc.abc201_250.abc218;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc218/editorial/2602 解法3 二分探索の実装<br/>
 * https://atcoder.jp/contests/abc218/submissions/25735182 にも参考
 */
public class ProblemH別回答2 {

	/** 最大値 */
	private static final long INF = 1 << 60;
	/** 配列のサイズ */
	private static final int N = 2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), r = scanner.nextInt();
			r = Math.min(r, n - r);
			long[] a = new long[n - 1], b = new long[n];
			Arrays.fill(b, 0L);
			IntStream.range(0, n - 1).forEach(i -> {
				a[i] = scanner.nextLong();
				b[i] += a[i];
				b[i + 1] += a[i];
			});
			long ok = 0L, ng = 1L << 31;
			while (ng > ok + 1) {
				long med = (ok + ng) >> 1;
				if (f(n, b, med)[1] >= r) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(f(n, b, ok)[0] + r * ok);
		}
	}

	/**
	 * f(x)を計算する
	 *
	 * @param n
	 * @param b
	 * @param x
	 * @return f(x)
	 */
	private static long[] f(int n, long[] b, long x) {
		long[][] dp = new long[N][n + 1], ep = new long[N][n + 1];
		Arrays.fill(dp[0], -INF);
		Arrays.fill(dp[1], 0L);
		Arrays.fill(ep[0], -INF);
		Arrays.fill(ep[1], 0);
		ep[0][0] = ep[1][0] = 0L;
		IntStream.range(0, n).forEach(i -> {
			dp[0][i + 1] = ep[0][i] + b[i] - x;
			dp[1][i + 1] = ep[1][i] + 1;
			ep[0][i + 1] = Math.max(dp[0][i], ep[0][i]);
			ep[1][i + 1] = (dp[0][i] == ep[0][i]) ? Math.max(dp[1][i], ep[1][i])
					: ((dp[0][i] > ep[0][i]) ? dp[1][i] : ep[1][i]);
		});
		long[] result = new long[N];
		result[0] = Math.max(dp[0][n], ep[0][n]);
		result[1] = (dp[0][n] == ep[0][n]) ? Math.max(dp[1][n], ep[1][n])
				: ((dp[0][n] > ep[0][n]) ? dp[1][n] : ep[1][n]);
		return result;
	}
}
