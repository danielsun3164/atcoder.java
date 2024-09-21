package other.math_and_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem099 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			boolean[] visited = new boolean[n];
			Arrays.fill(visited, false);
			long[] dp = new long[n];
			dfs(0, edges, visited, dp);
			System.out.println(IntStream.range(1, n).mapToLong(i -> dp[i] * (n - dp[i])).sum());
		}
	}

	/**
	 * 現在のノードの結果を再帰的に計算する
	 *
	 * @param now     現在のノード
	 * @param edges   辺の一覧
	 * @param visited 各ノードが使ったかどうかの配列
	 * @param dp      計算結果の配列
	 */
	private static void dfs(int now, List<Integer>[] edges, boolean[] visited, long[] dp) {
		visited[now] = true;
		dp[now] = 1L;
		for (int next : edges[now]) {
			if (!visited[next]) {
				dfs(next, edges, visited, dp);
				dp[now] += dp[next];
			}
		}
	}
}
