package abc.abc201_250.abc244;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt(), s = scanner.nextInt() - 1,
					t = scanner.nextInt() - 1, x = scanner.nextInt() - 1;
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			long[][][] dp = new long[n][k + 1][2];
			boolean[][] visited = new boolean[n][k + 1];
			IntStream.range(0, n).forEach(i -> IntStream.rangeClosed(0, k).forEach(j -> Arrays.fill(dp[i][j], 0L)));
			IntStream.range(0, n).forEach(i -> Arrays.fill(visited[i], false));
			dp[s][0][0] = 1L;
			visited[0][0] = true;
			Queue<Path> que = new ArrayDeque<>();
			edges[s].forEach(next -> que.add(new Path(s, next, 1)));
			while (!que.isEmpty()) {
				Path now = que.poll();
				IntStream.range(0, 2)
						.forEach(i -> dp[now.to][now.cost][i
								^ ((x == now.to) ? 1 : 0)] = (dp[now.to][now.cost][i ^ ((x == now.to) ? 1 : 0)]
										+ dp[now.from][now.cost - 1][i]) % MOD);
				if ((now.cost < k) && !visited[now.to][now.cost]) {
					visited[now.to][now.cost] = true;
					edges[now.to].forEach(next -> que.add(new Path(now.to, next, now.cost + 1)));
				}
			}
			System.out.println(dp[t][k][0]);
		}
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Path {
		int from, to, cost;

		Path(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
