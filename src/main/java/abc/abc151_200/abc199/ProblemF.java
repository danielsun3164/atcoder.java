package abc.abc151_200.abc199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc199/submissions/22107837 にも参考
 */
public class ProblemF {

	/** mod対象の数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			long[][] a = new long[1][], ma = new long[n][n];
			a[0] = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
				edges[x].add(y);
				edges[y].add(x);
			});
			IntStream.range(0, n).forEach(i -> Arrays.fill(ma[i], 0L));
			IntStream.range(0, n).forEach(i -> {
				ma[i][i] = (ma[i][i] + (((m - edges[i].size()) * inv(m)) % MOD)) % MOD;
				for (int j : edges[i]) {
					ma[i][i] = (ma[i][i] + inv((m * 2L) % MOD)) % MOD;
					ma[i][j] = (ma[i][j] + inv((m * 2L) % MOD)) % MOD;
				}
			});
			long[][] r = multiply(a, pow(ma, k));
			Arrays.stream(r[0]).forEach(System.out::println);
		}
	}

	/**
	 * xy≡1(mod MOD) なる y のうち、0≤y<MOD を満たすものを返します。
	 *
	 * @param x
	 * @return xy≡1(mod MOD) なる y のうち、0≤y<MOD を満たすもの
	 */
	private static long inv(long x) {
		return powMod(x, MOD - 2);
	}

	/**
	 * 行列aと行列bの掛け算を行う
	 *
	 * @param a
	 * @param b
	 * @return 行列aと行列bの掛け算の結果
	 */
	private static long[][] multiply(long[][] a, long[][] b) {
		long[][] result = new long[a.length][b[0].length];
		IntStream.range(0, result.length).forEach(i -> Arrays.fill(result[i], 0L));
		IntStream.range(0, a.length).forEach(i -> IntStream.range(0, result[i].length).forEach(j -> IntStream
				.range(0, a[i].length).forEach(k -> result[i][j] = (result[i][j] + (a[i][k] * b[k][j])) % MOD)));
		return result;
	}

	/**
	 * 行列mのk乗を計算する
	 *
	 * @param m 行列を表す配列
	 * @param k
	 * @return 行列mのk乗
	 */
	private static long[][] pow(long[][] m, int k) {
		long[][] result = new long[m.length][m.length];
		for (int i = 0; i < result.length; i++) {
			Arrays.fill(result[i], 0L);
			result[i][i] = 1L;
		}
		while (k > 0) {
			if (1 == (k & 1)) {
				result = multiply(result, m);
			}
			m = multiply(m, m);
			k >>= 1;
		}
		return result;
	}

	/**
	 * n^m mod MOD を計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (1 & m)) {
				result = (result * n) % MOD;
			}
			n = (n * n) % MOD;
			m >>= 1;
		}
		return result;
	}
}
