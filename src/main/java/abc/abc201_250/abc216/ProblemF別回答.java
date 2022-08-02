package abc.abc201_250.abc216;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc216/editorial/3460 の解説の実装
 */
public class ProblemF別回答 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 最大値 */
	private static final int MAX = 5000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			// aをソートし、bの順番も変える
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(a[i], b[i]))
					.sorted((x, y) -> Integer.compare(x.a, y.a)).toArray(Data[]::new);
			IntStream.range(0, n).forEach(i -> {
				a[i] = datas[i].a;
				b[i] = datas[i].b;
			});
			long[][] dp = new long[n][MAX + 1];
			Arrays.fill(dp[0], 0, b[0], 1L);
			Arrays.fill(dp[0], b[0], MAX + 1, 2L);
			IntStream.range(1, n).forEach(i -> Arrays.fill(dp[i], 0L));
			IntStream.range(1, n).forEach(i -> IntStream.rangeClosed(0, MAX).map(j -> MAX - j)
					.forEach(j -> dp[i][j] = (dp[i - 1][j] + ((j >= b[i]) ? dp[i - 1][j - b[i]] : 0L)) % MOD));
			System.out.println(IntStream.range(1, n).filter(i -> a[i] >= b[i]).mapToLong(i -> dp[i - 1][a[i] - b[i]])
					.reduce((a[0] >= b[0]) ? 1L : 0L, (s, d) -> (s + d) % MOD));
		}
	}

	/**
	 * a,bを格納するクラス
	 */
	private static class Data {
		int a, b;

		Data(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
	}
}
