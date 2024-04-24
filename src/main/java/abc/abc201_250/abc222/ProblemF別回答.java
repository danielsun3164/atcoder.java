package abc.abc201_250.abc222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc222/editorial/2749 の全方位木DPを利用した解き方の実装
 */
public class ProblemF別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Rerooting g = new Rerooting(n);
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1, c = scanner.nextInt();
				g.addEdge(a, b, c);
				g.addEdge(b, a, c);
			});
			IntStream.range(0, n).forEach(i -> g.d[i] = scanner.nextLong());
			long[] answers = g.run();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answers).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	private static class Rerooting {
		long[] d;
		long[] dp, memo;
		List<Edge>[] edges;

		@SuppressWarnings("unchecked")
		Rerooting(int n) {
			d = new long[n];
			edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			memo = new long[n];
			dp = new long[n];
		}

		void addEdge(int from, int to, long cost) {
			edges[from].add(new Edge(to, cost));
		}

		long[] run() {
			Arrays.fill(memo, 0L);
			Arrays.fill(dp, 0L);
			dfs1(0, -1);
			dfs2(0, -1, 0L);
			return dp;
		}

		long apply(long a, int c, long w) {
			return Math.max(a, d[c]) + w;
		}

		void dfs1(int now, int prev) {
			boolean updated = false;
			for (Edge edge : edges[now]) {
				if (edge.to != prev) {
					dfs1(edge.to, now);
					updated = true;
					memo[now] = Math.max(memo[now], apply(memo[edge.to], edge.to, edge.cost));
				}
			}
			if (!updated) {
				memo[now] = 0;
			}
		}

		void dfs2(int now, int prev, long value) {
			List<Long> ds = new ArrayList<>();
			ds.add(value);
			for (Edge edge : edges[now]) {
				if (edge.to != prev) {
					ds.add(apply(memo[edge.to], edge.to, edge.cost));
				}
			}
			int n = ds.size(), index = 1;
			long[] head = new long[n + 1], tail = new long[n + 1];
			Arrays.fill(head, 0L);
			Arrays.fill(tail, 0L);
			IntStream.range(0, n).forEach(i -> head[i + 1] = Math.max(head[i], ds.get(i)));
			IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> tail[i] = Math.max(tail[i + 1], ds.get(i)));
			dp[now] = head[n];
			for (Edge edge : edges[now]) {
				if (edge.to != prev) {
					long sub = Math.max(head[index], tail[index + 1]);
					dfs2(edge.to, now, apply(sub, now, edge.cost));
					index++;
				}
			}
		}
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Edge {
		int to;
		long cost;

		Edge(int to, long cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
}
