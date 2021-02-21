package abc.abc151_200.abc192;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long x = scanner.nextLong();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			System.out.println(IntStream.rangeClosed(1, n).mapToLong(i -> getResult(n, x, a, i)).filter(ri -> ri != -1L)
					.min().getAsLong());
		}
	}

	/**
	 * 魔力の目標値xに達成できる最も早い時刻を計算する
	 * 
	 * @param n 素材種類数
	 * @param x 魔力の目標値
	 * @param a 素材の魔力の配列
	 * @param c 使う素材の種類数
	 * @return 魔力の目標値xに達成できる最も早い時刻
	 */
	private static long getResult(int n, long x, int[] a, int c) {
		long[][][] dp = new long[n + 1][c + 1][c];
		IntStream.rangeClosed(0, n).forEach(i -> IntStream.rangeClosed(0, c).forEach(j -> Arrays.fill(dp[i][j], -1L)));
		dp[0][0][0] = 0L;
		IntStream.range(0, n)
				.forEach(i -> IntStream.range(0, Math.min(c, i + 1)).forEach(j -> IntStream.range(0, c).forEach(k -> {
					if (dp[i][j][k] >= 0) {
						dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k]);
						int r = (k + a[i] % c) % c;
						dp[i + 1][j + 1][r] = Math.max(dp[i + 1][j + 1][r], dp[i][j][k] + a[i]);
					}
				})));
		return (dp[n][c][(int) (x % c)] >= 0L) ? (x - dp[n][c][(int) (x % c)]) / c : -1L;
	}
}
