package abc.abc183;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	private static final long MOD = 1_000_000_007L;
	/** 壁を表す文字 */
	private static final char WALL = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] s = new char[h][];
			IntStream.range(0, h).forEach(i -> s[i] = scanner.next().toCharArray());
			// dpは結果、upは上からの合計値、leftは左からの合計値、luは左上からの合計値
			long[][] dp = new long[h][w], up = new long[h][w], left = new long[h][w], lu = new long[h][w];
			IntStream.range(0, h).forEach(i -> {
				Arrays.fill(dp[i], 0L);
				Arrays.fill(up[i], 0L);
				Arrays.fill(left[i], 0L);
				Arrays.fill(lu[i], 0L);
			});
			dp[0][0] = 1L;
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> {
				if (WALL != s[i][j]) {
					dp[i][j] = (dp[i][j] + ((i > 0) ? up[i - 1][j] : 0L) + ((j > 0) ? left[i][j - 1] : 0L)
							+ (((i > 0) && (j > 0)) ? lu[i - 1][j - 1] : 0L)) % MOD;
					up[i][j] = (dp[i][j] + ((i > 0) ? up[i - 1][j] : 0L)) % MOD;
					left[i][j] = (dp[i][j] + ((j > 0) ? left[i][j - 1] : 0L)) % MOD;
					lu[i][j] = (dp[i][j] + (((i > 0) && (j > 0)) ? lu[i - 1][j - 1] : 0L)) % MOD;
				}
			}));
			System.out.println(dp[h - 1][w - 1]);
		}
	}
}
