package abc.abc151_200.abc175;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 一行で最大拾うアイテム数+1 */
	private static final int MAX = 4;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt(), c = scanner.nextInt(), k = scanner.nextInt();
			long[][] v = new long[r][c];
			IntStream.range(0, r).forEach(i -> Arrays.fill(v[i], 0L));
			IntStream.range(0, k).forEach(i -> v[scanner.nextInt() - 1][scanner.nextInt() - 1] = scanner.nextLong());
			long[][][] dp = new long[MAX][r][c];
			dp[0][0][0] = 0L;
			dp[1][0][0] = v[0][0];
			IntStream.range(0, r).forEach(i -> IntStream.range(0, c).forEach(j -> {
				if (i > 0) {
					dp[0][i][j] = max(dp[0][i][j],
							IntStream.range(0, MAX).mapToLong(l -> dp[l][i - 1][j]).max().getAsLong());
					if (v[i][j] > 0) {
						dp[1][i][j] = max(dp[1][i][j],
								IntStream.range(0, MAX).mapToLong(l -> dp[l][i - 1][j]).max().getAsLong() + v[i][j]);
					}
				}
				if (j > 0) {
					if (v[i][j] > 0) {
						dp[0][i][j] = max(dp[0][i][j], dp[0][i][j - 1]);
						IntStream.range(1, MAX).forEach(
								l -> dp[l][i][j] = max(dp[l][i][j], dp[l - 1][i][j - 1] + v[i][j], dp[l][i][j - 1]));
					} else {
						IntStream.range(0, MAX).forEach(l -> dp[l][i][j] = max(dp[l][i][j], dp[l][i][j - 1]));
					}
				}
			}));
			System.out.println(IntStream.range(0, MAX).mapToLong(l -> dp[l][r - 1][c - 1]).max().getAsLong());
		}
	}

	/**
	 * 複数のlongのmaxを取得する
	 * 
	 * @param a 一つ目のlong
	 * @param b 二つ目以降のlong
	 * @return 複数のlongのmax
	 */
	private static long max(long a, long... b) {
		long result = a;
		for (long l : b) {
			result = Math.max(result, l);
		}
		return result;
	}
}
