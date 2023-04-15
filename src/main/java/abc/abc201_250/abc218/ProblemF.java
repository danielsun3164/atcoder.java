package abc.abc201_250.abc218;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** intの桁数 */
	private static final int N = Integer.SIZE;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] s = new int[m], t = new int[m];
			@SuppressWarnings("unchecked")
			Set<Integer>[] edges = new Set[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new HashSet<>());
			Map<Long, Integer> map = new HashMap<>();
			IntStream.range(0, m).forEach(i -> {
				s[i] = scanner.nextInt() - 1;
				t[i] = scanner.nextInt() - 1;
				edges[s[i]].add(t[i]);
				map.put(((long) s[i]) << N | t[i], i);
			});
			int[] dist = new int[n], memo = new int[n];
			Arrays.fill(dist, INF);
			Arrays.fill(memo, -1);
			Queue<Integer> que = new ArrayDeque<>();
			dist[0] = 0;
			que.add(0);
			while (!que.isEmpty()) {
				int now = que.poll();
				for (int next : edges[now]) {
					if (dist[next] > dist[now] + 1) {
						dist[next] = dist[now] + 1;
						memo[next] = now;
						que.add(next);
					}
				}
			}
			int[] answer = new int[m];
			if (INF == dist[n - 1]) {
				Arrays.fill(answer, -1);
			} else {
				Arrays.fill(answer, dist[n - 1]);
				IntStream.range(0, n).filter(i -> memo[i] != -1).forEach(i -> {
					int index = map.get(((long) memo[i]) << N | i);
					edges[s[index]].remove(t[index]);
					answer[index] = dijkstra(edges);
					edges[s[index]].add(t[index]);
				});
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, m).forEach(i -> sb.append(answer[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 頂点1から頂点Nまでの距離を計算する
	 *
	 * @param edges 辺の配列
	 * @return 頂点1から頂点Nまでの距離
	 */
	private static int dijkstra(Set<Integer>[] edges) {
		int n = edges.length;
		int[] dist = new int[n];
		Arrays.fill(dist, INF);
		dist[0] = 0;
		Queue<Integer> que = new ArrayDeque<>();
		que.add(0);
		while (!que.isEmpty()) {
			int now = que.poll();
			for (int next : edges[now]) {
				if (dist[next] > dist[now] + 1) {
					dist[next] = dist[now] + 1;
					que.add(next);
				}
			}
		}
		return (INF == dist[n - 1]) ? -1 : dist[n - 1];
	}
}
