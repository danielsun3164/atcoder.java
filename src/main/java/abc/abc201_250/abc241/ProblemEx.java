package abc.abc201_250.abc241;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/3473 の実装
 */
public class ProblemEx {

	/** modの対象 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long m = scanner.nextLong();
			long[] a = new long[n], b = new long[n], d = new long[1 << n], p = new long[1 << n];
			d[0] = 1L;
			p[0] = 0L;
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextLong();
				b[i] = scanner.nextLong() + 1;
				long x = (MOD - powMod(a[i], b[i])) % MOD;
				IntStream.range(0, 1 << i).forEach(j -> {
					d[(1 << i) + j] = d[j] * x % MOD;
					p[(1 << i) + j] = p[j] + b[i];
				});
			});
			long[] c = new long[n];
			IntStream.range(0, n).forEach(i -> {
				long x = powMod(a[i], MOD - 2);
				c[i] = 1L;
				IntStream.range(0, n).filter(j -> j != i).forEach(j -> {
					long y = a[j] * x % MOD;
					c[i] = (c[i] * (MOD + 1 - y)) % MOD;
				});
				c[i] = powMod(c[i], MOD - 2);
			});
			long answer = 0L;
			for (int i = 0; i < (1 << n); i++) {
				if (p[i] <= m) {
					long x = 0L;
					for (int j = 0; j < n; j++) {
						x = (x + powMod(a[j], m - p[i]) * c[j]) % MOD;
					}
					answer = (answer + (x * d[i])) % MOD;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * n^m mod MODを計算する
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
