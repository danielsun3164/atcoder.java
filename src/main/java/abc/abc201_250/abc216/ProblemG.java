package abc.abc201_250.abc216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc216/editorial/2474 の解説の実装
 */
public class ProblemG {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			// ノードがn+1個のグラフ
			@SuppressWarnings("unchecked")
			List<Edge>[] edges = new List[n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n).forEach(i -> {
				// 頂点 i から頂点 i+1 へ、コスト 1 の辺
				edges[i].add(new Edge(i, i + 1, 1));
				// 頂点 i+1 から頂点 i へ、コスト 0 の辺
				edges[i + 1].add(new Edge(i + 1, i, 0));
			});
			IntStream.range(0, m).forEach(i -> {
				int l = scanner.nextInt(), r = scanner.nextInt(), x = scanner.nextInt();
				// 頂点 L-1 から頂点 R へ、コスト R-L+1-X の辺
				edges[l - 1].add(new Edge(l - 1, r, r - l + 1 - x));
			});
			int[] b = new int[n + 1];
			Arrays.fill(b, INF);
			b[0] = 0;
			Queue<Edge> que = new PriorityQueue<>((x, y) -> Integer.compare(x.cost, y.cost));
			que.add(new Edge(0, 0, 0));
			while (!que.isEmpty()) {
				Edge now = que.poll();
				if (b[now.to] == now.cost) {
					for (Edge edge : edges[now.to]) {
						if (b[edge.to] > b[now.to] + edge.cost) {
							b[edge.to] = b[now.to] + edge.cost;
							que.add(new Edge(now.to, edge.to, b[edge.to]));
						}
					}
				}
			}
			System.out.println(IntStream.range(0, n).mapToObj(i -> String.valueOf((b[i] == b[i + 1]) ? 1 : 0))
					.collect(Collectors.joining(" ")));
		}
	}

	/**
	 * グラフの辺を表すクラス
	 */
	private static class Edge {
		@SuppressWarnings("unused")
		int from, to, cost;

		Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
