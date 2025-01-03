package other.typical90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem013 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] paths = new List[n];
			IntStream.range(0, n).forEach(i -> paths[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1, c = scanner.nextInt();
				paths[a].add(new Path(b, c));
				paths[b].add(new Path(a, c));
			});
			long[] dist0 = dijkstra(paths, n, 0), distn = dijkstra(paths, n, n - 1);
			// TLEを回避するため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, n).forEach(i -> sb.append(dist0[i] + distn[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * ダイクストラ法で起点ノードから各ノードまでの最短距離を計算する
	 *
	 * @param paths パスの一覧
	 * @param n     ノード数
	 * @param src   起点ノード
	 * @return 起点ノードから各ノードまでの最短距離の配列
	 */
	private static long[] dijkstra(List<Path>[] paths, int n, int src) {
		long[] dist = new long[n];
		Arrays.fill(dist, INF);
		dist[src] = 0L;
		Queue<Path> que = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
		que.add(new Path(src, 0L));
		while (!que.isEmpty()) {
			Path now = que.poll();
			if (dist[now.to] == now.cost) {
				for (Path next : paths[now.to]) {
					if (dist[next.to] > (dist[now.to] + next.cost)) {
						dist[next.to] = dist[now.to] + next.cost;
						que.add(new Path(next.to, dist[next.to]));
					}
				}
			}
		}
		return dist;
	}

	/**
	 * パスを表すクラス
	 */
	private static class Path {
		int to;
		long cost;

		public Path(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}
