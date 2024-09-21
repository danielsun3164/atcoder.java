package other.math_and_algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem044 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

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
			int[] dist = dijkstra(edges, 0);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(dist).forEach(di -> sb.append((INF == di) ? -1 : di).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * ダイクストラ法の実施
	 *
	 * @param edges 辺の一覧
	 * @param start 開始ノード
	 * @return 開始ノードから各ノードへの距離一覧
	 */
	private static int[] dijkstra(List<Integer>[] edges, int start) {
		int[] dist = new int[edges.length];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		Queue<Integer> que = new ArrayDeque<>();
		que.add(start);
		while (!que.isEmpty()) {
			int now = que.poll();
			for (int next : edges[now]) {
				if (dist[next] > dist[now] + 1) {
					dist[next] = dist[now] + 1;
					que.add(next);
				}
			}
		}
		return dist;
	}
}
