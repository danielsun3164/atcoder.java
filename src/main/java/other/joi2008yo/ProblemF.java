package other.joi2008yo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemF {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[][] dist = new int[n][n];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(dist[i], INF);
				dist[i][i] = 0;
			});
			IntStream.range(0, k).forEach(i -> {
				int t = scanner.nextInt();
				if (0 == t) {
					int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
					System.out.println((INF == dist[a][b]) ? -1 : dist[a][b]);
				} else {
					int c = scanner.nextInt() - 1, d = scanner.nextInt() - 1, e = scanner.nextInt();
					if (dist[c][d] > e) {
						dist[c][d] = dist[d][c] = e;
						warshallFloyd(dist, n);
					}
				}
			});
		}
	}

	/**
	 * ノード関の移動コストを計算する
	 *
	 * @param dist ノード関の移動コストの配列
	 * @param n    ノードの総数
	 */
	private static void warshallFloyd(int[][] dist, int n) {
		IntStream.range(0, n).forEach(k -> IntStream.range(0, n).forEach(
				j -> IntStream.range(0, n).forEach(i -> dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]))));
	}
}
