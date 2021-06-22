package abc.abc201_250.abc204;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc204/submissions/23263864 にも参考
 */
public class ProblemF別回答 {

	/** modの対象値 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt();
			long w = scanner.nextLong();
			int n = 1 << h;
			long[] init = new long[n];
			IntStream.range(0, n).forEach(mask -> {
				boolean nextPlace = false, ok = true;
				for (int i = 0; i < h; i++) {
					if (nextPlace) {
						if (0 != (mask & (1 << i))) {
							nextPlace = false;
						} else {
							ok = false;
						}
					} else if (0 != (mask & (1 << i))) {
						nextPlace = true;
					}
				}
				if (nextPlace) {
					ok = false;
				}
				init[mask] = ok ? 1L : 0L;
			});
			long[][] m = new long[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(m[i], 0L));
			IntStream.range(0, n)
					.forEach(from -> IntStream.range(0, n).forEach(to -> IntStream.range(0, n).forEach(used -> {
						boolean ok = true;
						for (int i = 0; i < h; i++) {
							if ((0 != (used & (1 << i))) && (((0 != (from & (1 << i))) || (0 != (to & (1 << i)))))) {
								ok = false;
								break;
							}
						}
						if (ok) {
							int to2 = to + used;
							m[to2][from] = (m[to2][from] + init[to]) % MOD;
						}
					})));
			long[][] v = new long[n][1];
			IntStream.range(0, n).forEach(i -> v[i][0] = init[i]);
			long[][] v2 = multiply(pow(m, w - 1), v);
			System.out.println(LongStream.range(0, n).reduce(0L, (s, i) -> (s + v2[(int) i][0]) % MOD));
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
