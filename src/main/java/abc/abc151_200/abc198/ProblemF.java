package abc.abc151_200.abc198;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * 解法1 ポリアの数え上げ定理 の桁DPの実装
 *
 * https://atcoder.jp/contests/abc198/submissions/21802587 にも参考
 */
public class ProblemF {

	/** mod対象の数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long s = scanner.nextLong();
			long answer = solve(new int[] { 1, 1, 1, 1, 1, 1 }, s);
			answer = (answer + (solve(new int[] { 1, 1, 2, 2 }, s) * 3L)) % MOD;
			answer = (answer + (solve(new int[] { 1, 1, 4 }, s) * 6L)) % MOD;
			answer = (answer + (solve(new int[] { 2, 2, 2 }, s) * 6L)) % MOD;
			answer = (answer + (solve(new int[] { 3, 3 }, s) * 8L)) % MOD;
			System.out.println((answer * invMod(24L)) % MOD);
		}
	}

	/**
	 * 結果を計算する
	 *
	 * @param x
	 * @param s
	 * @return 結果
	 */
	private static long solve(int[] x, long s) {
		int l = Arrays.stream(x).sum();
		if (s < l) {
			return 0L;
		}
		char[] t = String.valueOf(s - l).toCharArray();
		int n = t.length;

		int[] flow = new int[(l * 9) + 1];
		Arrays.fill(flow, 0);
		dfs(0, 0, x, flow);

		// dp[i][j]は i桁以下でs-lを組み合わせて、上の桁にj繰り上がるような組の個数
		long[][] dp = new long[n + 1][l];
		IntStream.range(0, n + 1).forEach(i -> Arrays.fill(dp[i], 0L));
		dp[0][0] = 1L;

		IntStream.range(0, n).forEach(i -> {
			int b = t[n - 1 - i] - '0';
			IntStream.range(0, l).forEach(j -> {
				for (int k = b - j; k < flow.length; k += 10) {
					if (k >= 0) {
						dp[i + 1][(j + k) / 10] += (dp[i][j] * flow[k]) % MOD;
						dp[i + 1][(j + k) / 10] %= MOD;
					}
				}
			});
		});
		return dp[n][0];
	}

	/**
	 * flowを計算する
	 *
	 * @param k
	 * @param s
	 * @param x
	 * @param flow
	 */
	private static void dfs(int k, int s, int[] x, int[] flow) {
		if (k < x.length) {
			IntStream.range(0, 10).forEach(i -> dfs(k + 1, s + (i * x[k]), x, flow));
		} else {
			flow[s]++;
		}
	}

	/**
	 * x mod m を安全に計算する
	 *
	 * @param x
	 * @param m
	 * @return x mod m
	 */
	private static long safeMod(long x, long m) {
		x %= m;
		if (x < 0) {
			x += m;
		}
		return x;
	}

	static long invMod(long x) {
		return invMod(x, MOD);
	}

	static long invMod(long x, long m) {
		if (!(1 <= m)) {
			throw new IllegalArgumentException("m is " + m);
		}
		long[] z = invGcd(x, m);
		if (1L != z[0]) {
			throw new IllegalArgumentException("z[0] is " + z[0]);
		}
		return z[1];
	}

	/**
	 * @param a
	 * @param b `1 <= b`
	 * @return {g, x} s.t. g = gcd(a, b), x a = g (mod b), 0 <= x < b/g
	 */
	static long[] invGcd(long a, long b) {
		a = safeMod(a, b);
		if (a == 0) {
			return new long[] { b, 0 };
		}

		// Contracts:
		// [1] s - m0 * a = 0 (mod b)
		// [2] t - m1 * a = 0 (mod b)
		// [3] s * |m1| + t * |m0| <= b
		long s = b, t = a;
		long m0 = 0, m1 = 1;

		while (t > 0) {
			long u = s / t;
			s -= t * u;
			m0 -= m1 * u; // |m1 * u| <= |m1| * s <= b

			// [3]:
			// (s - t * u) * |m1| + t * |m0 - m1 * u|
			// <= s * |m1| - t * u * |m1| + t * (|m0| + |m1| * u)
			// = s * |m1| + t * |m0| <= b
			long tmp = s;
			s = t;
			t = tmp;
			tmp = m0;
			m0 = m1;
			m1 = tmp;
		}
		// by [3]: |m0| <= b/g
		// by g != b: |m0| < b/g
		if (m0 < 0) {
			m0 += b / s;
		}
		return new long[] { s, m0 };
	}
}
