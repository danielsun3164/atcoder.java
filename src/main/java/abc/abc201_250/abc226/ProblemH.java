package abc.abc201_250.abc226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc226/editorial/2879 の解説の実装<br/>
 * https://atcoder.jp/contests/abc226/submissions/27241718 にも参考
 */
public class ProblemH {

	/** mod対象数字 */
	private static final int MOD = 998_244_353;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] l = new int[n], r = new int[n];
			int max = IntStream.range(0, n).map(i -> {
				l[i] = scanner.nextInt();
				r[i] = scanner.nextInt();
				return r[i];
			}).max().getAsInt();
			long[] inv = new long[max + 1];
			inv[0] = 0L;
			IntStream.rangeClosed(1, max).forEach(i -> inv[i] = powMod(i, MOD - 2));
			@SuppressWarnings("unchecked")
			List<Integer>[] memo = new List[max + 1];
			IntStream.rangeClosed(0, max).forEach(i -> memo[i] = new ArrayList<>());
			IntStream.range(0, n).forEach(i -> {
				memo[l[i]].add(i);
				memo[r[i]].add(i);
			});
			long[][] dp = new long[n + 1][0];
			dp[n] = new long[] { 1L };
			long answer = 0L;
			for (int li = 0, ri = 1; li < max; li++, ri++) {
				for (int i : memo[li]) {
					long a = inv[r[i] - l[i]], b = a * (MOD - l[i]) % MOD;
					if (li == l[i]) {
						long[][] dp2 = new long[n + 1][];
						System.arraycopy(dp, 1, dp2, 0, dp.length - 1);
						dp2[n] = new long[] {};
						dp = dp2;
						for (int j = n; j >= 0; j--) {
							dp[j] = sparseMul(dp[j], a, b);
							if (j > 0) {
								dp[j] = add(dp[j], sparseMul(dp[j - 1], MOD - a, MOD + 1 - b));
							}
						}
					} else {
						dp[0] = sparseDiv(inv, dp[0], a, b);
						for (int j = 1; j < n; j++) {
							dp[j] = minus(dp[j], sparseMul(dp[j - 1], MOD - a, MOD + 1 - b));
							dp[j] = sparseDiv(inv, dp[j], a, b);
						}
						dp[n] = new long[] {};
					}
				}
				for (int i = 0; i < k; i++) {
					answer = (answer + calc(inv, dp[i], li, ri)) % MOD;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * x^n mod MOD を計算する
	 *
	 * @param x
	 * @param n
	 * @return x^n mod MOD
	 */
	static long powMod(long x, long n) {
		long r = 1L, y = x % MOD;
		while (n > 0L) {
			if (1L == (n & 1L)) {
				r = r * y % MOD;
			}
			y = y * y % MOD;
			n >>= 1;
		}
		return r;
	}

	/**
	 * y<=xとなるf(y)の累積分布関数を計算する
	 *
	 * @param f
	 * @param x
	 * @return y<=xとなるf(y)の累積分布関数
	 */
	static long eval(long[] f, long x) {
		long result = 0L, basis = 1L;
		for (long a : f) {
			result = (result + a * basis % MOD) % MOD;
			basis = basis * x % MOD;
		}
		return result;
	}

	static long[] add(long[] lhs, long[] rhs) {
		long[] result = new long[Math.max(lhs.length, rhs.length)];
		System.arraycopy(lhs, 0, result, 0, lhs.length);
		IntStream.range(0, rhs.length).forEach(i -> result[i] = (result[i] + rhs[i]) % MOD);
		return result;
	}

	static long[] minus(long[] lhs, long[] rhs) {
		long[] result = new long[Math.max(lhs.length, rhs.length)];
		System.arraycopy(lhs, 0, result, 0, lhs.length);
		IntStream.range(0, rhs.length).forEach(i -> result[i] = (result[i] - rhs[i] + MOD) % MOD);
		return result;
	}

	static long calc(long[] inv, long[] f, long l, long r) {
		final int n = f.length;
		long[] g = new long[n + 1];
		g[0] = 0L;
		System.arraycopy(f, 0, g, 1, n);
		IntStream.range(1, n + 1).forEach(i -> g[i] = g[i] * (i - 1) % MOD);
		IntStream.range(0, n + 1).forEach(i -> g[i] = g[i] * inv[i] % MOD);
		return (eval(g, r) - eval(g, l) + MOD) % MOD;
	}

	static long[] sparseMul(long[] f, long a, long b) {
		int n = f.length;
		if (0 == n) {
			return new long[] {};
		}
		long[] g = new long[n + 1];
		Arrays.fill(g, 0L);
		IntStream.range(0, n).forEach(i -> {
			g[i + 1] = (g[i + 1] + f[i] * a % MOD) % MOD;
			g[i] = (g[i] + f[i] * b % MOD) % MOD;
		});
		return g;
	}

	static long[] sparseDiv(long[] inv, long[] f, long a, long b) {
		int n = f.length;
		if (n <= 1) {
			return new long[] {};
		}
		if (0L == b) {
			long invA = powMod(a, MOD - 2);
			long[] g = new long[n - 1];
			IntStream.range(0, n - 1).forEach(i -> g[i] = f[i + 1] * invA % MOD);
			return g;
		}
		long[] g = new long[n - 1];
		long invB = powMod(b, MOD - 2);
		g[0] = f[0] * invB % MOD;
		IntStream.range(1, n - 1).forEach(i -> g[i] = (f[i] - g[i - 1] * a % MOD + MOD) % MOD * invB % MOD);
		return g;
	}
}
