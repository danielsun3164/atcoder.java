package abc.abc151_200.abc151;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** 道を表す文字 */
	private static final char ROAD = '.';
	/** 移動する座標の差分 */
	private static final int[] XS = { -1, 1, 0, 0 };
	private static final int[] YS = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] s = new char[h][];
			IntStream.range(0, h).forEach(i -> s[i] = scanner.next().toCharArray());
			int n = h * w;
			int[][] dist = new int[n][n];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(dist[i], INF);
				dist[i][i] = 0;
			});
			IntStream.range(0, n).forEach(i -> {
				int x = i / w, y = i % w;
				if (ROAD == s[x][y]) {
					IntStream.range(0, XS.length).forEach(j -> {
						int nx = x + XS[j], ny = y + YS[j];
						if ((nx >= 0) && (nx < h) && (ny >= 0) && (ny < w) && (ROAD == s[nx][ny])) {
							dist[i][nx * w + ny] = dist[nx * w + ny][i] = 1;
						}
					});
				}
			});
			IntStream.range(0, n).forEach(k -> IntStream.range(0, n).forEach(j -> IntStream.range(0, n)
					.forEach(i -> dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]))));
			System.out.println(IntStream.range(0, n)
					.map(i -> Arrays.stream(dist[i]).filter(di -> di != INF).max().orElse(0)).max().orElse(0));
		}
	}
}
