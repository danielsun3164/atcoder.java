package abc.abc132;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			Set<Integer>[] sets = new Set[n * 3];
			IntStream.range(0, 3 * n).forEach(i -> sets[i] = new HashSet<>());
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				// 3 辺 u0 → v1, u1 → v2, u2 → v0 を張る
				sets[u].add(v + n);
				sets[u + n].add(v + n + n);
				sets[u + n + n].add(v);
			});
			int s = scanner.nextInt() - 1, t = scanner.nextInt() - 1;
			int[] dp = new int[3 * n];
			Arrays.fill(dp, Integer.MAX_VALUE);
			Queue<Edge> que = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
			que.add(new Edge(s, 0));
			while (!que.isEmpty()) {
				Edge e = que.poll();
				if (t == e.to) {
					System.out.println(e.cost / 3);
					return;
				}
				if (dp[e.to] > e.cost) {
					dp[e.to] = e.cost;
					for (Integer next : sets[e.to]) {
						if (dp[next] > e.cost + 1) {
							que.add(new Edge(next, e.cost + 1));
						}
					}
				}
			}
			System.out.println(-1);
		}
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Edge {
		int to;
		int cost;

		Edge(int to, int minCost) {
			super();
			this.to = to;
			this.cost = minCost;
		}
	}
}
