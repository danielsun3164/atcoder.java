package abc.abc201_250.abc232;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc232/editorial/3160 の実装<br/>
 * https://atcoder.jp/contests/abc232/submissions/28021143 にも参考
 */
public class ProblemE別回答1 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 2 */
	private static final int N = 2;
	/** 階乗と逆階乗の配列 */
	private static long[] fact, invFact;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), k = scanner.nextInt(), x1 = scanner.nextInt(),
					y1 = scanner.nextInt(), x2 = scanner.nextInt(), y2 = scanner.nextInt();
			init(k);
			long[][] dph = new long[k + 1][N], dpw = new long[k + 1][N];
			dph[0][0] = dph[1][1] = dpw[0][0] = dpw[1][1] = 1L;
			dph[1][0] = dph[0][1] = dpw[1][0] = dpw[0][1] = 0L;
			IntStream.rangeClosed(2, k).forEach(i -> {
				dph[i][0] = dph[i - 1][1] * (h - 1) % MOD;
				dph[i][1] = (dph[i - 1][0] + dph[i - 1][1] * (h - 2) % MOD) % MOD;
				dpw[i][0] = dpw[i - 1][1] * (w - 1) % MOD;
				dpw[i][1] = (dpw[i - 1][0] + dpw[i - 1][1] * (w - 2) % MOD) % MOD;
			});
			int indexH = (x1 == x2) ? 0 : 1, indexW = (y1 == y2) ? 0 : 1;
			System.out.println(IntStream.rangeClosed(0, k)
					.mapToLong(i -> dph[i][indexH] * dpw[k - i][indexW] % MOD * comb(k, i) % MOD).sum() % MOD);
		}
	}

	private static void init(int n) {
		fact = new long[n + 1];
		fact[0] = 1L;
		IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
		invFact = new long[n + 1];
		invFact[n] = powMod(fact[n], MOD - 2);
		IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
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

	private static long comb(int n, int k) {
		return (n < k) ? 0L : fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
	}
}
