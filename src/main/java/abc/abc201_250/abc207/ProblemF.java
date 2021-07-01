package abc.abc201_250.abc207;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc207/submissions/23735814 にも参考
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	/** dpの初期化用（TLE対策） */
	private static final long[][][] INIT = new long[2][2][2];
	static {
		INIT[0][0][0] = INIT[1][1][1] = 1L;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			long[][][][] dp = new long[n][][][];
			dfs(edges, dp, 0);
			// TLE対策
			// 結果の計算方法は https://blog.hamayanhamayan.com/entry/2021/06/27/005906 にも参考
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(0, n).forEach(i -> sb.append((dp[0][i][0][0] + dp[0][i][0][1] + dp[0][i][1][1]) % MOD)
					.append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 各ノードのdpを計算する
	 *
	 * @param edges 辺の一覧
	 * @param dp
	 * @param now   現在処理対象のノード
	 */
	private static void dfs(List<Integer>[] edges, long[][][][] dp, int now) {
		dp[now] = INIT;
		for (int next : edges[now]) {
			if (null == dp[next]) {
				dfs(edges, dp, next);
				int a = dp[now].length, b = dp[next].length;
				long[][][] nex = new long[a + b - 1][2][2];
				IntStream.range(0, a).forEach(
						i -> IntStream.range(0, 2).forEach(k -> IntStream.range(0, 2).forEach(l -> IntStream.range(0, b)
								.forEach(j -> IntStream.range(0, 2).forEach(m -> IntStream.range(0, 2).forEach(n -> {
									if ((0L != dp[now][i][k][l]) && (0L != dp[next][j][m][n])) {
										int sum = i + j + ((1 - l) & m) + (k & (1 - n)), p = l | m;
										nex[sum][k][p] = (nex[sum][k][p] + dp[now][i][k][l] * dp[next][j][m][n] % MOD)
												% MOD;
									}
								}))))));
				dp[now] = nex;
			}
		}
	}
}
