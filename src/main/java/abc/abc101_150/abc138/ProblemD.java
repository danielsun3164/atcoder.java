package abc.abc101_150.abc138;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			long[] x = new long[n];
			Arrays.fill(x, 0L);
			IntStream.range(0, q).forEach(i -> x[scanner.nextInt() - 1] += scanner.nextInt());
			boolean[] visited = new boolean[n];
			Arrays.fill(visited, false);
			sum(x, edges, visited, 0, 0L);
			System.out.println(Arrays.stream(x).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * ノードnow以下のカウンター値をすべて累積する
	 * 
	 * @param x       カウンター値の配列
	 * @param edges   辺の配列
	 * @param visited 累積したかどうかの配列
	 * @param now     現在処理中のノード
	 * @param parent  親のカウンター値
	 */
	private static void sum(long[] x, List<Integer>[] edges, boolean[] visited, int now, long parent) {
		if (!visited[now]) {
			visited[now] = true;
			x[now] += parent;
			for (int next : edges[now]) {
				sum(x, edges, visited, next, x[now]);
			}
		}
	}
}
