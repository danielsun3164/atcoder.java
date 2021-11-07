package abc.abc201_250.abc210;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), c = scanner.nextInt();
			int[][] a = new int[h][w], a2 = new int[h][w];
			IntStream.range(0, h)
					.forEach(i -> IntStream.range(0, w).forEach(j -> a2[i][w - 1 - j] = a[i][j] = scanner.nextInt()));
			long[][] dp = new long[h + 1][w + 1], dp2 = new long[h + 1][w + 1];
			Arrays.fill(dp[0], INF);
			Arrays.fill(dp2[0], INF);
			IntStream.rangeClosed(1, h).forEach(i -> dp[i][0] = dp2[i][0] = INF);
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> {
				dp[i + 1][j + 1] = min(a[i][j], dp[i][j + 1] + c, dp[i + 1][j] + c);
				dp2[i + 1][j + 1] = min(a2[i][j], dp2[i][j + 1] + c, dp2[i + 1][j] + c);
			}));
			System.out.println(IntStream.range(0, h)
					.mapToLong(i -> IntStream.range(0, w)
							.mapToLong(j -> min(dp[i + 1][j] + c + a[i][j], dp[i][j + 1] + c + a[i][j],
									dp2[i + 1][j] + c + a2[i][j], dp2[i][j + 1] + c + a2[i][j]))
							.min().getAsLong())
					.min().getAsLong());
		}
	}

	/**
	 * 複数のlongの最小値を取得する
	 *
	 * @param a 複数の入力
	 * @return 複数のlongの最小値
	 */
	private static long min(long... a) {
		return Arrays.stream(a).min().getAsLong();
	}
}
