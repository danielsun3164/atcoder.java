package abc.abc201_250.abc236;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc236/editorial/3286 の実装<br/>
 * https://atcoder.jp/contests/abc236/submissions/33324252 にも参考
 */
public class ProblemG {

	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), t = scanner.nextInt(), l = scanner.nextInt();
			long[][] matrix = new long[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(matrix[i], INF));
			IntStream.rangeClosed(1, t).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				matrix[v][u] = i;
			});
			long[][] pMatrix = pow(matrix, l);
			System.out.println(IntStream.range(0, n).mapToLong(i -> (pMatrix[i][0] > INF / 2) ? -1 : pMatrix[i][0])
					.mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * 行列aと行列bの掛け算を計算する（数字の掛け算はmax、足し算はminで計算する）
	 *
	 * @param a
	 * @param b
	 * @return 掛け算の結果
	 */
	private static long[][] multiply(long[][] a, long[][] b) {
		int n = a.length, m = a[0].length, l = b[0].length;
		long[][] result = new long[n][l];
		IntStream.range(0, n).forEach(i -> IntStream.range(0, l).forEach(j -> result[i][j] = IntStream.range(0, m)
				.mapToLong(k -> Math.max(a[i][k], b[k][j])).min().getAsLong()));
		return result;
	}

	/**
	 * 行列aのmべき乗を計算する
	 *
	 * @param a
	 * @param m
	 * @return 行列aのmべき乗
	 */
	private static long[][] pow(long[][] a, long m) {
		int n = a.length;
		long[][] result = new long[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(result[i], INF);
			result[i][i] = -INF;
		}
		while (m > 0L) {
			if (1L == (1L & m)) {
				result = multiply(result, a);
			}
			a = multiply(a, a);
			m >>= 1;
		}
		return result;
	}
}
