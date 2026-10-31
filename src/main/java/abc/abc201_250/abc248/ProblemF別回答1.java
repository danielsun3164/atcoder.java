package abc.abc201_250.abc248;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://kazun-kyopro.hatenablog.com/entry/ABC/248/F の実装<br/>
 * https://atcoder.jp/contests/abc248/submissions/31033052 にも参考
 */
public class ProblemF別回答1 {

	private static final int[][] EDGE_A = { { 2, 1 }, { 2, 1 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 0, 0 } };
	private static final int[][] EDGE_B = { { 1, 1 }, { 0, 0 } };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), p = scanner.nextInt();
			long[][] dp = new long[n + 1][2];
			dp[0][0] = dp[1][1] = 1;
			for (int i = 2; i <= n; i++) {
				long[][] previous = dp, next = new long[n + 1][2];
				IntStream.rangeClosed(0, n).forEach(k -> {
					Arrays.stream(EDGE_A).forEach(edge -> {
						int u = edge[0], t = edge[1];
						if (k + u <= n) {
							next[k + u][t] = (next[k + u][t] + previous[k][0]) % p;
						}
					});
					Arrays.stream(EDGE_B).forEach(edge -> {
						int u = edge[0], t = edge[1];
						if (k + u <= n) {
							next[k + u][t] = (next[k + u][t] + previous[k][1]) % p;
						}
					});
				});
				dp = next;
			}
			long[][] answer = dp;
			System.out.println(
					IntStream.range(1, n).mapToObj(k -> String.valueOf(answer[k][0])).collect(Collectors.joining(" ")));
		}
	}
}
