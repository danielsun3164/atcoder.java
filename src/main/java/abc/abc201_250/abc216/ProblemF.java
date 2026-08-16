package abc.abc201_250.abc216;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc216/editorial/2560 の解説の実装
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

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
			int maxA = a[n - 1];
			long[][] dp = new long[n + 1][maxA + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], 0L));
			dp[0][0] = 1L;
			long answer = 0L;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= maxA; j++) {
					dp[i + 1][j] = dp[i][j];
					if (b[i] <= j) {
						dp[i + 1][j] = (dp[i + 1][j] + dp[i][j - b[i]]) % MOD;
					}
					if (j <= a[i] - b[i]) {
						answer = (answer + dp[i][j]) % MOD;
					}
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * a,bを格納するクラス
	 */
	private static class Data {
		int a, b;

		Data(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
