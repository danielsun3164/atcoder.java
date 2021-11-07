package abc.abc201_250.abc211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] childrens = new List[n];
			IntStream.range(0, n).forEach(i -> childrens[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				childrens[a].add(b);
				childrens[b].add(a);
			});
			// ノード0からの距離
			int[] dist = new int[n];
			Arrays.fill(dist, INF);
			// ノード0からの最短距離の移動方法数
			long[] dp = new long[n];
			Arrays.fill(dp, 0L);
			dist[0] = 0;
			dp[0] = 1L;
			Queue<Path> que = new PriorityQueue<>((x, y) -> Long.compare(x.cost, y.cost));
			que.add(new Path(0, 0));
			while (!que.isEmpty()) {
				Path path = que.poll();
				int now = path.to;
				if (dist[now] == path.cost) {
					for (int next : childrens[now]) {
						if (dist[next] > dist[now] + 1) {
							dist[next] = dist[now] + 1;
							dp[next] = dp[now];
							que.add(new Path(next, dist[next]));
						} else if (dist[next] == dist[now] + 1) {
							dp[next] = (dp[next] + dp[now]) % MOD;
						}
					}
				}
			}
			System.out.println(dp[n - 1]);
		}
	}

	/**
	 * パスを表すクラス
	 */
	private static class Path {
		int to, cost;

		Path(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
}
