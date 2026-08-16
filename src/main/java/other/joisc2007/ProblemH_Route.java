package other.joisc2007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemH_Route {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			@SuppressWarnings("unchecked")
			List<Edge>[] childrens = new List[n];
			IntStream.range(0, n).forEach(i -> childrens[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1, c = scanner.nextInt();
				childrens[a].add(new Edge(a, b, c));
				childrens[b].add(new Edge(b, a, c));
			});
			int[] dist = new int[n];
			Arrays.fill(dist, INF);
			dist[0] = 0;
			boolean[][] visited = new boolean[n][n];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(visited[i], false);
				visited[i][0] = true;
			});
			Queue<Edge> que = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
			que.addAll(childrens[0]);
			while (!que.isEmpty()) {
				Edge edge = que.poll();
				int a2 = getEdge2(edge.from, edge.to, x, y);
				dist[edge.to] = Math.min(dist[edge.to], edge.cost);
				if (!visited[edge.from][edge.to]) {
					for (Edge next : childrens[edge.to]) {
						int b2 = getEdge2(next.to, edge.to, x, y);
						int c2 = getEdge2(edge.from, next.to, x, y);
						// 角度の条件は https://atcoder.jp/contests/joisc2007/submissions/18212565 に参考
						if (a2 + b2 - c2 <= 0) {
							dist[next.to] = Math.min(dist[next.to], edge.cost + next.cost);
							que.add(new Edge(next.from, next.to, edge.cost + next.cost));
						}
					}
					visited[edge.from][edge.to] = true;
				}
			}
			System.out.println((INF == dist[1]) ? -1 : dist[1]);
		}
	}

	/**
	 * from、toの間の距離の2乗を取得する
	 *
	 * @param from
	 * @param to
	 * @param x    X座標一覧の配列
	 * @param y    X座標一覧の配列
	 * @return from、toの間の距離の2乗
	 */
	private static int getEdge2(int from, int to, final int[] x, final int[] y) {
		return (x[from] - x[to]) * (x[from] - x[to]) + (y[from] - y[to]) * (y[from] - y[to]);
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Edge {
		/** 開始地点 */
		int from;
		/** 終了地点 */
		int to;
		/** コスト */
		int cost;

		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
