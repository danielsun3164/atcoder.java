package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem055 {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long[][] answer = multiple(pow(new long[][] { { 2L, 1L }, { 1L, 0L } }, n - 2),
					new long[][] { { 1L }, { 1L } });
			System.out.println(answer[0][0]);
		}
	}

	/**
	 * 行列a x 行列b の結果を計算する
	 *
	 * @param a
	 * @param b
	 * @return 行列a x 行列b の結果
	 */
	private static long[][] multiple(long[][] a, long[][] b) {
		int n = a.length, m = b[0].length, r = a[0].length;
		long[][] result = new long[n][m];
		IntStream.range(0, n).forEach(i -> IntStream.range(0, m).forEach(
				j -> result[i][j] = IntStream.range(0, r).mapToLong(k -> a[i][k] * b[k][j] % MOD).sum() % MOD));
		return result;
	}

	/**
	 * 行列a ^ n を計算する
	 *
	 * @param a
	 * @param n
	 * @return 行列a ^ n
	 */
	private static long[][] pow(long[][] a, long n) {
		int m = a.length;
		long[][] result = new long[m][m];
		for (int i = 0; i < m; i++) {
			Arrays.fill(result[i], 0L);
			result[i][i] = 1L;
		}
		while (n > 0L) {
			if (1L == (1L & n)) {
				result = multiple(result, a);
			}
			a = multiple(a, a);
			n >>= 1;
		}
		return result;
	}
}
