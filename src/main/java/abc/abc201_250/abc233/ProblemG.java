package abc.abc201_250.abc233;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc233/editorial/3184 の実装<br/>
 * TLE対策のため、エリアのブロックの合計数を事前に計算する
 */
public class ProblemG {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** ブロックを表す文字 */
	private static final char BLOCK = '#';
	/** TLE対策のため、メンバ変数を定義 */
	private static char[][] s;
	private static int[][][][] dp;
	private static int[][] sum;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			s = new char[n][];
			IntStream.range(0, n).forEach(i -> s[i] = scanner.next().toCharArray());
			dp = new int[n][n][n][n];
			sum = new int[n + 1][n + 1];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n)
					.forEach(j -> IntStream.range(0, n).forEach(k -> Arrays.fill(dp[i][j][k], INF))));
			IntStream.range(0, n + 1).forEach(i -> Arrays.fill(sum[i], 0));
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> {
				dp[i][j][i][j] = (BLOCK == s[i][j]) ? 1 : 0;
				sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + ((BLOCK == s[i][j]) ? 1 : 0);
			}));
			System.out.println(solve(0, 0, n - 1, n - 1));
		}
	}

	/**
	 * (lx,ly) ~ (rx,ry) のエリアを破壊するための体力の最小値を計算する
	 *
	 * @param lx
	 * @param ly
	 * @param rx
	 * @param ry
	 * @return (lx,ly) ~ (rx,ry) のエリアを破壊するための体力の最小値
	 */
	private static int solve(int lx, int ly, int rx, int ry) {
		if ((lx > rx) || (ly > ry)) {
			return 0;
		}
		if (dp[lx][ly][rx][ry] < INF) {
			return dp[lx][ly][rx][ry];
		}
		dp[lx][ly][rx][ry] = Math.max(rx - lx + 1, ry - ly + 1);
		IntStream.rangeClosed(lx, rx)
				.filter(i -> 0 == (sum[i + 1][ry + 1] - sum[i + 1][ly] - sum[i][ry + 1] + sum[i][ly]))
				.forEach(i -> dp[lx][ly][rx][ry] = Math.min(dp[lx][ly][rx][ry],
						solve(lx, ly, i - 1, ry) + solve(i + 1, ly, rx, ry)));
		IntStream.rangeClosed(ly, ry)
				.filter(j -> 0 == (sum[rx + 1][j + 1] - sum[lx][j + 1] - sum[rx + 1][j] + sum[lx][j]))
				.forEach(j -> dp[lx][ly][rx][ry] = Math.min(dp[lx][ly][rx][ry],
						solve(lx, ly, rx, j - 1) + solve(lx, j + 1, rx, ry)));
		return dp[lx][ly][rx][ry];
	}
}
