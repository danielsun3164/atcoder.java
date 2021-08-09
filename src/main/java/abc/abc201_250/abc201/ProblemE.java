package abc.abc201_250.abc201;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;
	/** 最大2進数の桁数 */
	private static final int N = 61;
	/** modの対象 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				long w = scanner.nextLong();
				edges[u].add(new Path(v, w));
				edges[v].add(new Path(u, w));
			});
			long[] dist = dijkstra(edges, 0, n);
			int[][] count = new int[N][2];
			IntStream.range(0, N).forEach(i -> Arrays.fill(count[i], 0));
			IntStream.range(0, N)
					.forEach(i -> IntStream.range(0, n).forEach(j -> count[i][(int) ((dist[j] >> i) & 1L)]++));
			System.out.println(LongStream.range(0, N).reduce(0L, (sum, i) -> safeMod(
					sum + safeMod(safeMod(count[(int) i][0] * (long) count[(int) i][1]) * powMod(2L, i)))));
		}
	}

	/**
	 * ダイクストラ法で起点から各ノードへの距離の配列を計算する
	 *
	 * @param edges 辺の一覧
	 * @param src   起点
	 * @param n     ノードの数
	 * @return 起点から各ノードへの距離の配列
	 */
	private static long[] dijkstra(List<Path>[] edges, int src, int n) {
		long[] dist = new long[n];
		Arrays.fill(dist, INF);
		dist[src] = 0L;
		Queue<Path> que = new ArrayDeque<>();
		que.add(new Path(src, 0L));
		while (!que.isEmpty()) {
			Path p = que.poll();
			for (Path next : edges[p.to]) {
				if (INF == dist[next.to]) {
					dist[next.to] = p.cost ^ next.cost;
					que.add(new Path(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}

	/**
	 * x^n mod MOD を計算する
	 *
	 * @param x
	 * @param n
	 * @return x^n mod MOD
	 */
	static long powMod(long x, long n) {
		long r = 1L, y = safeMod(x);
		while (n > 0L) {
			if (1L == (n & 1L)) {
				r = safeMod(r * y);
			}
			y = safeMod(y * y);
			n >>= 1;
		}
		return r;
	}

	/**
	 * x mod MOD を安全に計算する
	 *
	 * @param x
	 * @return x mod MOD
	 */
	static long safeMod(long x) {
		x %= MOD;
		if (x < 0) {
			x += MOD;
		}
		return x;
	}

	/**
	 * 辺を表すクラス
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
