package abc.abc051_100.abc075;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[m], b = new int[m];
			boolean[][] graph = new boolean[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(graph[i], false));
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
				graph[a[i]][b[i]] = graph[b[i]][a[i]] = true;
			});
			boolean[] visited = new boolean[n];
			System.out.println(IntStream.range(0, m).filter(i -> {
				Arrays.fill(visited, false);
				graph[a[i]][b[i]] = graph[b[i]][a[i]] = false;
				dnf(graph, visited, 0);
				graph[a[i]][b[i]] = graph[b[i]][a[i]] = true;
				return IntStream.range(0, n).filter(j -> !visited[j]).count() > 0;
			}).count());
		}
	}

	/**
	 * グラフの遍歴処理
	 * 
	 * @param graph   グラフを表す配列
	 * @param visited 各ノードが処理されたかどうかを表す配列
	 * @param node    現在処理しているノード
	 */
	private static void dnf(final boolean[][] graph, boolean[] visited, int node) {
		visited[node] = true;
		IntStream.range(0, visited.length).filter(i -> graph[node][i]).forEach(i -> {
			if (!visited[i]) {
				dnf(graph, visited, i);
			}
		});
	}
}
