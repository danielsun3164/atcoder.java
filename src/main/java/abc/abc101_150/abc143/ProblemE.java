package abc.abc101_150.abc143;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long l = scanner.nextLong();
			// 距離の配列
			long[][] dist = new long[n][n];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(dist[i], INF);
				dist[i][i] = 0L;
			});
			IntStream.range(0, m).forEach(i -> {
				int from = scanner.nextInt() - 1, to = scanner.nextInt() - 1;
				long c = scanner.nextLong();
				if (c <= l) {
					dist[from][to] = c;
					dist[to][from] = c;
				}
			});
			IntStream.range(0, n).forEach(k -> IntStream.range(0, n).forEach(j -> IntStream.range(0, n)
					.forEach(i -> dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]))));
			// 燃料補給回数の配列
			long[][] refuel = new long[n][n];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> {
				if (i == j) {
					refuel[i][j] = 0L;
				} else {
					refuel[i][j] = (dist[i][j] <= l) ? 1L : INF;
				}
			}));
			IntStream.range(0, n).forEach(k -> IntStream.range(0, n).forEach(j -> IntStream.range(0, n)
					.forEach(i -> refuel[i][j] = Math.min(refuel[i][j], refuel[i][k] + refuel[k][j]))));
			int q = scanner.nextInt();
			IntStream.range(0, q).mapToLong(i -> {
				int s = scanner.nextInt() - 1, t = scanner.nextInt() - 1;
				return (INF == refuel[s][t]) ? -1L : refuel[s][t] - 1;
			}).forEach(System.out::println);
		}
	}
}
