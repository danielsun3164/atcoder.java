package other.math_and_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem043別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			boolean[] visited = new boolean[n];
			Arrays.fill(visited, false);
			dfs(edges, visited, 0);
			System.out.println(
					(IntStream.range(0, n).filter(i -> !visited[i]).count() > 0) ? "The graph is not connected."
							: "The graph is connected.");
		}
	}

	/**
	 * グラフのノードを再帰的に探索する
	 *
	 * @param edges   辺の一覧
	 * @param visited 各ノードが探索されたかどうかの配列
	 * @param now     現在探索しているノード
	 */
	private static void dfs(List<Integer>[] edges, boolean[] visited, int now) {
		visited[now] = true;
		for (int next : edges[now]) {
			if (!visited[next]) {
				dfs(edges, visited, next);
			}
		}
	}
}
