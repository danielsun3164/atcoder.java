package abc.abc151_200.abc163;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc163/submissions/12199930 にも参考
 */
public class ProblemE {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(scanner.nextInt(), i)).sorted(
					(a, b) -> (a.value == b.value) ? Integer.compare(a.index, b.index) : Long.compare(b.value, a.value))
					.toArray(Data[]::new);
			// dp[i][j] はi個の移動先が決まって、そのうちj個が左に移動する場合のうれしさの合計の最大値
			long[][] dp = new long[n + 1][n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], -INF));
			dp[0][0] = 0L;
			IntStream.range(0, n).forEach(i -> IntStream.rangeClosed(0, i).filter(j -> dp[i][j] >= 0L).forEach(j -> {
				int index = datas[i].index;
				// 左へ移動
				dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + datas[i].value * Math.abs(index - j));
				// 右へ移動
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + datas[i].value * Math.abs(n - 1 - (i - j) - index));
			}));
			System.out.println(Arrays.stream(dp[n]).max().getAsLong());
		}
	}

	/**
	 * valueとindexを格納するクラス
	 */
	private static class Data {
		long value;
		int index;

		Data(long value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
