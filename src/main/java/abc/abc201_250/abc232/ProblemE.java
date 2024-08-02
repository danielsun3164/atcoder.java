package abc.abc201_250.abc232;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc232/editorial/3148 の実装
 */
public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 2 */
	private static final int N = 2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), k = scanner.nextInt(), x1 = scanner.nextInt(),
					y1 = scanner.nextInt(), x2 = scanner.nextInt(), y2 = scanner.nextInt();
			long[][] dp = new long[N][N];
			Arrays.fill(dp[0], 0L);
			Arrays.fill(dp[1], 0L);
			dp[(x1 != x2) ? 1 : 0][(y1 != y2) ? 1 : 0] = 1L;
			long[] row = new long[] { 1L, h - 1 }, col = new long[] { 1L, w - 1 };
			while (k-- > 0) {
				long[][] next = new long[N][N];
				IntStream.range(0, N).forEach(i -> Arrays.fill(next[i], 0L));
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						for (int a = 0; a < N; a++) {
							next[i][a] = (next[i][a] + dp[i][j] * (col[a] - ((j == a) ? 1L : 0L)) % MOD) % MOD;
							next[a][j] = (next[a][j] + dp[i][j] * (row[a] - ((i == a) ? 1L : 0L)) % MOD) % MOD;
						}
					}
				}
				dp = next;
			}
			System.out.println(dp[0][0]);
		}
	}
}
