package abc.abc201_250.abc243;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[][] dist = new long[n][n];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(dist[i], INF);
				dist[i][i] = 0L;
			});
			Path[] paths = IntStream.range(0, m).mapToObj(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1, c = scanner.nextInt();
				dist[a][b] = dist[b][a] = c;
				return new Path(a, b, c);
			}).sorted((a, b) -> Long.compare(a.cost, b.cost)).toArray(Path[]::new);
			IntStream.range(0, n).forEach(k -> IntStream.range(0, n).forEach(j -> IntStream.range(0, n)
					.forEach(i -> dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]))));
			System.out.println(Arrays.stream(paths).filter(path -> {
				boolean deleteOk = false;
				for (int i = 0; i < n; i++) {
					if ((i != path.from) && (i != path.to) && (dist[path.from][i] + dist[i][path.to] <= path.cost)) {
						deleteOk = true;
						break;
					}
				}
				return deleteOk;
			}).count());
		}
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Path {
		int from, to;
		long cost;

		Path(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
