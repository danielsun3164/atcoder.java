package abc.abc201_250.abc228;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc228/editorial/2942 の実装<br/>
 * https://atcoder.jp/contests/abc227/submissions/27209472 にも参考
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), n = scanner.nextInt();
			int[][] c = IntStream.range(0, h).mapToObj(i -> {
				char[] s = scanner.next().toCharArray();
				return IntStream.range(0, w).map(j -> s[j] - '0').toArray();
			}).toArray(int[][]::new);
			int n2 = n <<= 1, b = 1 << TEN;
			int[][][][] trans = new int[2][TEN][b][TEN];
			IntStream.range(1, TEN)
					.forEach(i -> IntStream.range(0, b).forEach(j -> IntStream.range(1, TEN).forEach(k -> {
						int iMask = 0, kMask = 0;
						for (int x = 0; x < h; x++) {
							for (int y = 0; y < w; y++) {
								if ((c[x][y] == i) && (0 != (j & (1 << y)))) {
									iMask |= 1 << x;
								}
								if (c[x][y] == k) {
									kMask |= 1 << x;
								}
							}
						}
						trans[0][i][j][k] = iMask & kMask;
					})));
			IntStream.range(1, TEN)
					.forEach(i -> IntStream.range(0, b).forEach(j -> IntStream.range(1, TEN).forEach(k -> {
						int iMask = 0, kMask = 0;
						for (int x = 0; x < h; x++) {
							for (int y = 0; y < w; y++) {
								if ((c[x][y] == i) && (0 != (j & (1 << x)))) {
									iMask |= 1 << y;
								}
								if (c[x][y] == k) {
									kMask |= 1 << y;
								}
							}
						}
						trans[1][i][j][k] = iMask & kMask;
					})));
			long[][][] dp = new long[n2 + 1][TEN][b];
			IntStream.rangeClosed(0, n2).forEach(i -> IntStream.range(0, TEN).forEach(j -> Arrays.fill(dp[i][j], 0L)));
			IntStream.range(1, TEN).forEach(i -> {
				int iMask = 0;
				for (int x = 0; x < h; x++) {
					for (int y = 0; y < w; y++) {
						if (c[x][y] == i) {
							iMask |= 1 << x;
						}
					}
				}
				dp[1][i][iMask] = 1L;
			});
			IntStream.range(1, n2).forEach(i -> IntStream.range(1, TEN).forEach(j -> IntStream.range(0, b)
					.filter(k -> 0 != dp[i][j][k]).forEach(k -> IntStream.range(1, TEN).forEach(l -> {
						int nk = trans[i & 1][j][k][l];
						dp[i + 1][l][nk] = (dp[i + 1][l][nk] + dp[i][j][k]) % MOD;
					}))));
			System.out.println(IntStream.range(1, TEN).mapToLong(
					j -> IntStream.range(1, b).mapToLong(k -> dp[n2][j][k]).reduce(0L, (s, dpi) -> (s + dpi) % MOD))
					.sum() % MOD);
		}
	}
}
