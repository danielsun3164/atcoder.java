package abc.abc201_250.abc239;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc239/editorial/3357 の最初の解法の実装
 */
public class ProblemEx {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;
	/** 50_000 */
	private static final int N = 50_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int l = (int) (Math.sqrt(m) + 0.5), k = m / (l + 1);
			long[] low = new long[N], high = new long[N];
			IntStream.rangeClosed(1, l + k).forEach(i -> {
				int x = (i <= l) ? i : m / (l + k + 1 - i), r = 0;
				long sum = 0L;
				for (int j = 2, le = Math.min(n, x); j <= le; j = r) {
					int q = x / j;
					r = Math.min(n, x / q) + 1;
					long current = (q <= l) ? low[q] : high[m / q];
					sum = (sum + current * (r - j) % MOD) % MOD;
				}
				if (i <= l) {
					low[i] = (sum + n) * powMod(n - 1, MOD - 2) % MOD;
				} else {
					high[l + k + 1 - i] = (sum + n) * powMod(n - 1, MOD - 2) % MOD;
				}
			});
			System.out.println((m <= l) ? low[m] : high[1]);
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
