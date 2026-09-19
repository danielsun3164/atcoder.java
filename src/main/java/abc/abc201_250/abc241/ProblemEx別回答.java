package abc.abc201_250.abc241;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/3502 の実装<br/>
 * https://atcoder.jp/contests/abc241/submissions/29670996 にも参考
 */
public class ProblemEx別回答 {

	/** modの対象 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long m = scanner.nextLong();
			long[] a = new long[n], b = new long[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextLong();
				b[i] = scanner.nextLong() + 1;
			});
			long[][] inv = new long[n][n];
			long[] invProd = new long[n], powMemo = new long[n];
			long answer = IntStream.range(0, n).mapToLong(i -> {
				powMemo[i] = powMod(a[i], b[i]);
				invProd[i] = 1L;
				IntStream.range(0, n).forEach(j -> {
					inv[i][j] = (j == i) ? 1L : divMod(1, a[i] - a[j] + ((a[i] < a[j]) ? MOD : 0L), MOD);
					invProd[i] = invProd[i] * inv[i][j] % MOD;
				});
				return powMod(a[i], m + n - 1) * invProd[i] % MOD;
			}).sum();
			for (int k = 1, l = 1; k < (1 << n); k++, l ^= 1) {
				int i;
				for (i = 0; (k & (1 << i)) == 0; i++) {
					l ^= 1;
				}
				long sum = 0L;
				for (i = 0; i < n; i++) {
					if ((k & (1 << i)) != 0) {
						sum += b[i];
					}
				}
				if (sum > m) {
					continue;
				}
				long dm = m - sum;
				for (i = 0, sum = 0L; i < n; i++) {
					sum += powMod(a[i], dm + n - 1) * invProd[i] % MOD;
				}
				long tmp = 1L;
				for (i = 0; i < n; i++) {
					if ((k & (1 << i)) != 0) {
						tmp = tmp * powMemo[i] % MOD;
					}
				}
				answer += (0 == l) ? sum % MOD * tmp % MOD : (MOD - sum % MOD * tmp % MOD);
			}
			System.out.println(answer % MOD);
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

	/**
	 * x/y mod zを計算する
	 *
	 * @param x
	 * @param y
	 * @param z
	 * @return x/y mod z
	 */
	private static long divMod(long x, long y, long z) {
		return (0L == x % y) ? x / y : (divMod((1 + x / y) * y - x, z % y, y) * z + x) / y;
	}
}
