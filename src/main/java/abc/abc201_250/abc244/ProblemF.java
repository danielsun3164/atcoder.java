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
 *
 * https://atcoder.jp/contests/abc244/editorial/3599 の実装
 */
public class ProblemF {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = 1 << n;
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			int[][] dist = new int[q][n];
			IntStream.range(0, q).forEach(i -> Arrays.fill(dist[i], INF));
			Queue<Path> que = new ArrayDeque<>();
			IntStream.range(0, n).forEach(i -> {
				dist[1 << i][i] = 1;
				que.add(new Path(1 << i, i));
			});
			while (!que.isEmpty()) {
				Path now = que.poll();
				edges[now.to].forEach(next -> {
					int ns = now.s ^ (1 << next);
					if (INF == dist[ns][next]) {
						dist[ns][next] = dist[now.s][now.to] + 1;
						que.add(new Path(ns, next));
					}
				});
			}
			System.out.println(IntStream.range(1, q).mapToLong(i -> Arrays.stream(dist[i]).min().getAsInt()).sum());
		}
	}

	/**
	 * sとtoを格納するクラス
	 */
	private static class Path {
		int s, to;

		Path(int s, int to) {
			this.s = s;
			this.to = to;
		}
	}
}
