package other.math_and_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem080 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				long c = scanner.nextLong();
				edges[a].add(new Path(b, c));
				edges[b].add(new Path(a, c));
			});
			long[] dist = new long[n];
			Arrays.fill(dist, INF);
			dist[0] = 0L;
			Queue<Path> que = new PriorityQueue<>((x, y) -> Long.compare(x.cost, y.cost));
			que.add(new Path(0, 0L));
			while (!que.isEmpty()) {
				Path now = que.poll();
				if (dist[now.to] == now.cost) {
					edges[now.to].stream().filter(next -> dist[next.to] > now.cost + next.cost).forEach(next -> {
						dist[next.to] = now.cost + next.cost;
						que.add(new Path(next.to, dist[next.to]));
					});
				}
			}
			System.out.println((INF == dist[n - 1]) ? -1 : dist[n - 1]);
		}
	}

	/**
	 * to,costを格納するクラス
	 */
	private static class Path {
		int to;
		long cost;

		Path(int to, long cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
}
