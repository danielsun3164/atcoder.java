package abc.abc201_250.abc217;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc217/editorial/2616 の実装
 */
public class ProblemF別回答 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt() << 1, m = scanner.nextInt();
			boolean[][] ok = new boolean[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(ok[i], false));
			long[] fact = new long[n + 1], invFact = new long[n + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[n] = powMod(fact[n], MOD - 2);
			IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			@SuppressWarnings("unchecked")
			List<Integer>[] lists = new List[n];
			IntStream.range(0, n).forEach(i -> lists[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				lists[a].add(b);
			});
			long[][] dp = new long[n + 1][n + 1], dp2 = new long[n + 1][n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], -1L));
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp2[i], -1L));
			calcDp(lists, fact, invFact, dp, dp2, 0, n);
			System.out.println(dp[0][n]);
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
	 * DPを[from,to)の範囲で計算する
	 *
	 * @param lists   仲良し生徒の一覧
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param dp      DP
	 * @param dp2     DP2
	 * @param from
	 * @param to
	 */
	private static void calcDp(List<Integer>[] lists, long[] fact, long[] invFact, long[][] dp, long[][] dp2, int from,
			int to) {
		if (-1L == dp[from][to]) {
			if (from == to) {
				dp[from][to] = 1L;
				return;
			}
			dp[from][to] = 0L;
			if ((from > to) || (1 == (1 & (from - to)))) {
				return;
			}
			IntStream.range(from, to).forEach(i -> {
				calcDp(lists, fact, invFact, dp, dp2, from, i);
				calcDp2(lists, fact, invFact, dp, dp2, i, to);
				dp[from][to] = (dp[from][to] + dp[from][i] * dp2[i][to] % MOD
						* ncr(fact, invFact, (to - from - 2) / 2, (i - from) / 2) % MOD) % MOD;
			});
		}
	}

	/**
	 * DP2を[from,to)の範囲で計算する
	 *
	 * @param lists   仲良し生徒の一覧
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param dp      DP
	 * @param dp2     DP2
	 * @param from
	 * @param to
	 */
	private static void calcDp2(List<Integer>[] lists, long[] fact, long[] invFact, long[][] dp, long[][] dp2, int from,
			int to) {
		if (-1L == dp2[from][to]) {
			dp2[from][to] = 0L;
			lists[from].stream().filter(next -> next < to).forEach(i -> {
				calcDp(lists, fact, invFact, dp, dp2, from + 1, i);
				calcDp(lists, fact, invFact, dp, dp2, i + 1, to);
				dp2[from][to] = (dp2[from][to] + dp[from + 1][i] * dp[i + 1][to] % MOD
						* ncr(fact, invFact, (to - from - 2) / 2, (to - i - 1) / 2) % MOD) % MOD;
			});
		}
	}

	/**
	 * n C r mod MODを計算する
	 *
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param n
	 * @param r
	 * @return n C r mod MOD
	 */
	private static long ncr(long[] fact, long[] invFact, int n, int r) {
		return fact[n] * invFact[n - r] % MOD * invFact[r] % MOD;
	}
}
