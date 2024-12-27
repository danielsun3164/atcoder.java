package abc.abc201_250.abc238;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc238/editorial/3361 の実装
 */
public class ProblemEx {

	/** 左を表す文字 */
	private static final char LEFT = 'L';
	/** 右を表す文字 */
	private static final char RIGHT = 'R';
	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 数値の最大値 */
	private static final int MAX = 100_000;
	/** 階乗、逆階乗の配列 */
	private static long[] fact, invFact;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			init();
			long[][] num = new long[n][n], cost = new long[n][n];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(num[i], 0L);
				num[i][(i + 1) % n] = 1L;
				Arrays.fill(cost[i], 0L);
			});
			IntStream.rangeClosed(1, n).forEach(d -> {
				IntStream.range(0, n).forEach(l -> {
					int r = (l + d) % n, i = (l + 1) % n;
					while (i != r) {
						int c1 = ((RIGHT == s[l]) ? 1 : 0) + ((LEFT == s[r]) ? 1 : 0),
								c2 = ((RIGHT == s[l]) ? (i - l + n) % n : 0) + ((LEFT == s[r]) ? (r - i + n) % n : 0);
						num[l][r] = (num[l][r] + num[l][i] * num[i][r] % MOD * c1 % MOD
								* binom((r - l - 2 + n) % n, (i - l - 1 + n) % n) % MOD) % MOD;
						cost[l][r] = (cost[l][r] + (num[l][i] * num[i][r] % MOD * c2 % MOD
								+ num[l][i] * cost[i][r] % MOD * c1 % MOD + cost[l][i] * num[i][r] % MOD * c1 % MOD)
								* binom((r - l - 2 + n) % n, (i - l - 1 + n) % n) % MOD) % MOD;
						i = (i + 1) % n;
					}
				});
			});
			System.out.println(IntStream.range(0, n).mapToLong(i -> cost[i][i]).sum() % MOD * invFact[n] % MOD);
		}
	}

	/**
	 * 階乗、逆階乗の配列の初期化を行う
	 */
	private static void init() {
		fact = new long[MAX + 1];
		fact[0] = 1L;
		IntStream.rangeClosed(1, MAX).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
		invFact = new long[MAX + 1];
		invFact[MAX] = powMod(fact[MAX], MOD - 2);
		IntStream.iterate(MAX - 1, i -> i >= 0, i -> i - 1).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
	}

	/**
	 * n_C_r mod MOD を計算する
	 *
	 * @param n
	 * @param r
	 * @return n_C_r mod MOD
	 */
	private static long binom(int n, int r) {
		return ((n < 0) || (r < 0) || (n < r)) ? 0L : fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
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
