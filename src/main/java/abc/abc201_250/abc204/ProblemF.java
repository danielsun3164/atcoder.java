package abc.abc201_250.abc204;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc204/submissions/23280058 にも参考
 */
public class ProblemF {

	/** modの対象値 */
	private static final long MOD = 998_244_353L;

	/** フィボナッチ数列 */
	private static final int[] LENGTHS = { 1, 1, 2, 3, 5, 8, 13 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt();
			long w = scanner.nextLong();
			int n = 1 << h;
			long[][] m = new long[n][n];
			IntStream.range(0, n).forEach(prev -> IntStream.range(0, n).forEach(next -> {
				int flag = 0;
				for (int k = 0; k < h; k++) {
					if ((0 == (prev & (1 << k))) && (0 == (next & (1 << k)))) {
						flag |= 1 << k;
					}
					if ((0 != (prev & (1 << k))) && (0 != (next & (1 << k)))) {
						flag = -1;
						break;
					}
				}
				if (-1 != flag) {
					m[prev][next] = 1L;
					int c = 0;
					for (int k = 0; k <= h; k++) {
						if (0 != (flag & (1 << k))) {
							c++;
						} else {
							m[prev][next] = (m[prev][next] * LENGTHS[c]) % MOD;
							c = 0;
						}
					}
				}
			}));
			System.out.println(pow(m, w)[0][0]);
		}
	}

	/**
	 * 行列aとbの掛け算を実施
	 *
	 * @param a
	 * @param b
	 * @return 行列aとbの掛け算の結果
	 */
	private static long[][] multiply(long[][] a, long[][] b) {
		long[][] result = new long[a.length][b[0].length];
		IntStream.range(0, a.length).forEach(i -> Arrays.fill(result[i], 0L));
		IntStream.range(0, a.length)
				.forEach(i -> IntStream.range(0, b[0].length).forEach(j -> IntStream.range(0, a[0].length)
						.forEach(k -> result[i][j] = (result[i][j] + ((a[i][k] * b[k][j]) % MOD)) % MOD)));
		return result;
	}

	/**
	 * 行列aのm乗を計算する
	 *
	 * @param a
	 * @param m
	 * @return 行列aのm乗
	 */
	private static long[][] pow(long[][] a, long m) {
		long[][] result = new long[a.length][a.length];
		for (int i = 0; i < a.length; i++) {
			Arrays.fill(result[i], 0L);
			result[i][i] = 1L;
		}
		while (m > 0L) {
			if (1 == (1 & m)) {
				result = multiply(result, a);
			}
			a = multiply(a, a);
			m >>= 1;
		}
		return result;
	}
}
