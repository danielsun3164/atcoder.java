package abc.abc201_250.abc222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** Kの最大値 */
	private static final int MAX_K = 100_001;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			int[] a = IntStream.range(0, m).map(i -> scanner.nextInt() - 1).toArray();
			@SuppressWarnings("unchecked")
			List<Edge>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(new Edge(v, i));
				edges[v].add(new Edge(u, i));
			});
			// 辺を使う回数のカウント
			int[] counts = new int[n - 1];
			IntStream.range(0, m - 1).forEach(i -> dfs(a[i], -1, a[i + 1], edges, counts));
			int sum = Arrays.stream(counts).sum();
			if ((1 == (1 & (sum + k))) || (sum + k) < 0) {
				System.out.println(0);
				return;
			}
			long[] dp = new long[MAX_K];
			Arrays.fill(dp, 0L);
			dp[0] = 1L;
			IntStream.range(0, n - 1).forEach(i -> IntStream.range(counts[i], MAX_K).map(j -> MAX_K + counts[i] - j - 1)
					.forEach(j -> dp[j] = (dp[j] + dp[j - counts[i]]) % MOD));
			System.out.println(dp[(sum + k) >> 1]);
		}
	}

	/**
	 * nowからgoalまでにたどる辺の数を+1する
	 *
	 * @param now    現在の頂点
	 * @param prev   直前の頂点
	 * @param goal   ゴールの頂点
	 * @param edges  辺の一覧の配列
	 * @param counts 使う辺の数の配列
	 * @return nowからgoalまでにたどることができるかどうか
	 */
	private static boolean dfs(int now, int prev, int goal, List<Edge>[] edges, int[] counts) {
		if (now == goal) {
			return true;
		}
		for (Edge edge : edges[now]) {
			if (edge.to != prev) {
				if (dfs(edge.to, now, goal, edges, counts)) {
					counts[edge.index]++;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 変を表すクラス
	 */
	private static class Edge {
		int to, index;

		Edge(int to, int index) {
			this.to = to;
			this.index = index;
		}
	}
}
