package abc.abc101_150.abc145;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc145/submissions/18190200 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), t = scanner.nextInt();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(scanner.nextInt(), scanner.nextInt()))
					.sorted((x, y) -> Integer.compare(x.a, y.a)).toArray(Data[]::new);
			int[][] dp = new int[n + 1][t + Math.max(datas[n - 1].a, t) + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], 0));
			IntStream.range(0, n).forEach(i -> {
				IntStream.range(0, dp[i].length).forEach(j -> dp[i + 1][j] = dp[i][j]);
				IntStream.range(0, t).forEach(j -> {
					dp[i + 1][j + datas[i].a] = Math.max(dp[i + 1][j + datas[i].a], dp[i][j] + datas[i].b);
				});
			});
			System.out.println(Arrays.stream(dp[n]).max().getAsInt());
		}
	}

	/**
	 * aとbを格納するクラス
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
