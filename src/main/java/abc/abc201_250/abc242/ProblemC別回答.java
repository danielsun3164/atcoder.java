package abc.abc201_250.abc242;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc242/editorial/3532 の実装
 */
public class ProblemC別回答 {

	private static final int N = 9;
	/** MOD対象数字 */
	private static final long MOD = 998_244_353L;
	/** 計算用行列 */
	private static final long[][] M = { { 1, 1, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 1, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1 } };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[][] a = new long[1][N], b = new long[N][1];
			Arrays.fill(a[0], 1L);
			IntStream.range(0, N).forEach(i -> b[i][0] = 1L);
			System.out.println(multiple(multiple(a, pow(M, n - 1)), b)[0][0]);
		}
	}

	/**
	 * 行列aと行列bの積を計算する
	 *
	 * @param a
	 * @param b
	 * @return 行列aと行列bの積
	 */
	private static long[][] multiple(long[][] a, long[][] b) {
		long[][] result = new long[a.length][b[0].length];
		IntStream.range(0, a.length).forEach(i -> Arrays.fill(result[0], 0L));
		IntStream.range(0, a.length).forEach(i -> IntStream.range(0, b[0].length).forEach(j -> IntStream
				.range(0, a[i].length).forEach(k -> result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD)));
		return result;
	}

	/**
	 * 行列aのnべき乗を計算する
	 *
	 * @param a
	 * @param n
	 * @return 行列aのnべき乗
	 */
	private static long[][] pow(long[][] a, int n) {
		int m = a.length;
		long[][] result = new long[m][m];
		for (int i = 0; i < m; i++) {
			Arrays.fill(result[i], 0L);
			result[i][i] = 1L;
		}
		while (n > 0) {
			if ((n & 1) > 0) {
				result = multiple(result, a);
			}
			a = multiple(a, a);
			n >>= 1;
		}
		return result;
	}
}
