package other.typical90;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem003 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

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
			int[] distance = dijkstra(n, edges, 0);
			int src = 0, maxD = 0;
			for (int i = 0; i < n; i++) {
				if (distance[i] > maxD) {
					src = i;
					maxD = distance[i];
				}
			}
			// 0から一覧遠いノードを起点として計算する
			distance = dijkstra(n, edges, src);
			System.out.println(Arrays.stream(distance).max().getAsInt() + 1);
		}
	}

	/**
	 * 起点からすべてのノードへの距離の配列を計算する
	 *
	 * @param n     ノードの数
	 * @param edges 辺の一覧
	 * @param src   起点
	 * @return 起点からすべてのノードへの距離の配列
	 */
	private static int[] dijkstra(int n, List<Integer>[] edges, int src) {
		int[] distance = new int[n];
		Arrays.fill(distance, INF);
		distance[src] = 0;
		Queue<Integer> que = new ArrayDeque<>();
		que.add(src);
		while (!que.isEmpty()) {
			int now = que.poll();
			for (int next : edges[now]) {
				if (INF == distance[next]) {
					distance[next] = distance[now] + 1;
					que.add(next);
				}
			}
		}
		return distance;
	}
}
