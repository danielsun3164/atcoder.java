package abc.abc201_250.abc234;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc234/editorial/3223 の実装
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** アルファベットの数 */
	private static final int N = 26;
	/** 階乗と逆階乗の配列 */
	private static long[] fact, invFact;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			init(n);
			int[] freq = new int[N];
			IntStream.range(0, n).forEach(i -> freq[s[i] - 'a']++);
			long[][] dp = new long[N + 1][n + 1];
			IntStream.rangeClosed(0, N).forEach(i -> Arrays.fill(dp[i], 0L));
			dp[0][0] = 1L;
			IntStream.range(0, N).forEach(
					i -> IntStream.rangeClosed(0, n).forEach(j -> IntStream.rangeClosed(0, Math.min(j, freq[i]))
							.forEach(k -> dp[i + 1][j] = (dp[i + 1][j] + dp[i][j - k] * binom(j, k) % MOD) % MOD)));
			System.out.println(IntStream.rangeClosed(1, n).mapToLong(i -> dp[N][i]).sum() % MOD);
		}
	}

	/**
	 * 階乗と逆階乗配列の初期化
	 *
	 * @param n 配列の長さ
	 */
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

	/**
	 * n_C_rを計算する
	 *
	 * @param n
	 * @param r
	 * @return n_C_r
	 */
	private static long binom(int n, int r) {
		return ((n < r) || (n < 0) || (r < 0)) ? 0L : fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
	}
}
