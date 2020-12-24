package abc.abc051_100.abc073;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			// 町と町の間の移動最短距離
			int[][] d = new int[n][n];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(d[i], Integer.MAX_VALUE >> 1);
				d[i][i] = 0;
			});
			int[] r = new int[q];
			IntStream.range(0, q).forEach(i -> r[i] = scanner.nextInt() - 1);
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1, c = scanner.nextInt();
				d[a][b] = d[b][a] = c;
			});
			warshallFloyd(d, n);
			System.out.println(getResult(d, r, -1, new boolean[q], 1));
		}
	}

	/**
	 * 町と町の間の移動最短距離をワーシャル–フロイド法で計算する
	 * 
	 * @param d 町と町の間の移動最短距離の配列
	 * @param n 町の数
	 */
	private static void warshallFloyd(int[][] d, int n) {
		IntStream.range(0, n).forEach(k -> IntStream.range(0, n)
				.forEach(j -> IntStream.range(0, n).forEach(i -> d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]))));
	}

	/**
	 * 解説通りに実装したメソッド
	 * 
	 * @param d       町と町の最短距離の配列
	 * @param r       訪ねる町の配列
	 * @param prev    直前に訪ねた町（存在しないときは-1）
	 * @param visited 町が訪ねたかどうかの配列
	 * @param depth   訪ねた町の数
	 * @return 訪ねる町をすべて訪ねたときの移動距離
	 */
	private static int getResult(final int[][] d, final int[] r, int prev, boolean[] visited, int depth) {
		if (depth > r.length) {
			return 0;
		}
		int result = Integer.MAX_VALUE >> 1;
		for (int i = 0; i < r.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (-1 == prev) {
					result = Math.min(result, getResult(d, r, i, visited, depth + 1));
				} else {
					result = Math.min(result, getResult(d, r, i, visited, depth + 1) + d[r[prev]][r[i]]);
				}
				visited[i] = false;
			}
		}
		return result;
	}
}
