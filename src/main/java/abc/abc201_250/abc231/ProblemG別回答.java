package abc.abc201_250.abc231;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://kazun-kyopro.hatenablog.com/entry/ABC/231/G の実装<br/>
 * https://atcoder.jp/contests/abc231/submissions/27883319 にも参考
 */
public class ProblemG別回答 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[] h = convert(a);
			long invN = powMod(n, MOD - 2), c = 1L, x = 0L;
			for (int i = 0; i <= Math.min(n, k); i++) {
				x = (x + h[i] * c % MOD) % MOD;
				c = c * (k - i) % MOD * invN % MOD;
			}
			System.out.println(x);
		}
	}

	private static long[] convert(long[] a) {
		int n = a.length;
		long[] x = new long[n + 1];
		Arrays.fill(x, 0L);
		x[0] = 1L;
		Arrays.stream(a).forEach(ai -> IntStream.rangeClosed(0, n).map(i -> n - i)
				.forEach(i -> x[i] = (i > 0) ? (x[i] * ai % MOD + x[i - 1]) % MOD : x[i] * ai % MOD));
		return x;
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
