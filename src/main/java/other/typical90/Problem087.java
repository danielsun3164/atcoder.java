package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem087 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;
	/** Xを置き換える値 */
	private static final long X = 100_000_000_000L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), p = scanner.nextInt(), k = scanner.nextInt();
			long[][] a = new long[n][n], dist = new long[n][n];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> {
				a[i][j] = scanner.nextLong();
				dist[i][j] = (a[i][j] > p) ? INF : ((-1 == a[i][j]) ? X : a[i][j]);
			}));
			IntStream.range(0, n).forEach(l -> IntStream.range(0, n).forEach(j -> IntStream.range(0, n).forEach(i -> {
				long dij = dist[i][l] + dist[l][j];
				if ((dij < X) && (dij > p)) {
					dij = INF;
				}
				dist[i][j] = Math.min(dist[i][j], dij);
			})));
			if (k == IntStream.range(0, n)
					.map(i -> (int) IntStream.range(i + 1, n).filter(j -> dist[i][j] <= p).count()).sum()) {
				System.out.println("Infinity");
				return;
			}
			System.out.println(calcX(n, p, a, k - 1) - calcX(n, p, a, k));
		}
	}

	/**
	 * (a[i][j]<=pの数)<=kとなる最大のXを計算する
	 *
	 * @param n 街の数
	 * @param p コストの最大値
	 * @param a コストの一覧
	 * @param k コストがp以下の経路の数
	 * @return (a[i][j]<=pの数)<=kとなる最大のX
	 */
	private static long calcX(int n, int p, long[][] a, int k) {
		long[][] d = new long[n][n];
		long left = 0L, right = p + 1;
		while (right > left + 1) {
			long med = (right + left) / 2L;
			IntStream.range(0, n)
					.forEach(i -> IntStream.range(0, n).forEach(j -> d[i][j] = (-1L == a[i][j]) ? med : a[i][j]));
			IntStream.range(0, n).forEach(l -> IntStream.range(0, n)
					.forEach(j -> IntStream.range(0, n).forEach(i -> d[i][j] = Math.min(d[i][j], d[i][l] + d[l][j]))));
			if (IntStream.range(0, n).map(i -> (int) IntStream.range(i + 1, n).filter(j -> d[i][j] <= p).count())
					.sum() <= k) {
				right = med;
			} else {
				left = med;
			}
		}
		return right;
	}
}
