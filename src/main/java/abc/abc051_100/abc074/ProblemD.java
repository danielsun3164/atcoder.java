package abc.abc051_100.abc074;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// 町と町の間の移動最短距離
			int[][] a = new int[n][n];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> a[i][j] = scanner.nextInt()));
			if (!warshallFloyd(a, n)) {
				System.out.println(-1);
				return;
			}
			System.out.println(IntStream.range(0, n)
					.mapToLong(i -> IntStream.range(i + 1, n).mapToLong(j -> getResult(i, j, a, n)).sum()).sum());
		}
	}

	/**
	 * 町と町の間の移動最短距離をワーシャル–フロイド法で計算する
	 * 
	 * @param d 町と町の間の移動最短距離の配列
	 * @param n 町の数
	 * @return すでに最短距離であるかどうか
	 */
	private static boolean warshallFloyd(int[][] d, int n) {
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {
					if (d[i][k] + d[k][j] < d[i][j]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * @param u 始点の町
	 * @param v 終点の町
	 * @param a 町の町の間の最短距離
	 * @param n 町の数
	 * @return uとvの間に道路が存在する場合、その長さ。存在しない場合は0
	 */
	private static long getResult(final int u, final int v, final int[][] a, final int n) {
		if (u == v) {
			return 0L;
		}
		for (int i = 0; i < n; i++) {
			if ((i != u) && (i != v) && (a[u][i] + a[i][v] == a[u][v])) {
				return 0L;
			}
		}
		return a[u][v];
	}
}
