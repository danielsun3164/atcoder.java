package abc.abc151_200.abc160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc160/submissions/11325358 にも参考
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edgesList = new List[n];
			IntStream.range(0, n).forEach(i -> edgesList[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edgesList[a].add(b);
				edgesList[b].add(a);
			});
			long[] fact = new long[n + 1], invFact = new long[n + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[n] = powMod(fact[n], MOD - 2);
			IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			long[] dp = new long[n], answer = new long[n];
			int[] count = new int[n];
			calcCount(edgesList, fact, invFact, dp, count, 0, -1);
			calcAnswer(edgesList, fact, invFact, dp, count, answer, 0, -1);
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * n ^ m mod MODを計算する
	 *
	 * @param n
	 * @param m
	 * @return n ^ m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (1 & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}

	/**
	 * dp と countを計算する
	 *
	 * @param edgesList 辺の一覧
	 * @param fact      階乗の配列
	 * @param invFact   階乗^{-1} mod MODの配列
	 * @param dp        頂点iを根とした部分木に番号をつける組み合わせの配列
	 * @param count     各iを根とした部分木の頂点数の配列
	 * @param now       現在処理中のノード
	 * @param prev      直前処理したノード
	 */
	private static void calcCount(List<Integer>[] edgesList, long[] fact, long[] invFact, long[] dp, int[] count,
			int now, int prev) {
		dp[now] = 1L;
		int cnt = 0;
		for (int to : edgesList[now]) {
			if (to != prev) {
				calcCount(edgesList, fact, invFact, dp, count, to, now);
				cnt += count[to];
				dp[now] = dp[now] * dp[to] % MOD * invFact[count[to]] % MOD;
			}
		}
		dp[now] = dp[now] * fact[cnt] % MOD;
		count[now] = cnt + 1;
	}

	/**
	 * 結果を計算する
	 *
	 * @param edgesList 辺の一覧
	 * @param fact      階乗の配列
	 * @param invFact   階乗^{-1} mod MODの配列
	 * @param dp        頂点iを根とした部分木に番号をつける組み合わせの配列
	 * @param count     各iを根とした部分木の頂点数の配列
	 * @param answer    結果の配列
	 * @param now       現在処理中のノード
	 * @param prev      直前処理したノード
	 */
	private static void calcAnswer(List<Integer>[] edgesList, long[] fact, long[] invFact, long[] dp, int[] count,
			long[] answer, int now, int prev) {
		answer[now] = 1L;
		int cnt = 0;
		for (int to : edgesList[now]) {
			cnt += count[to];
			answer[now] = answer[now] * dp[to] % MOD * invFact[count[to]] % MOD;
		}
		answer[now] = answer[now] * fact[cnt] % MOD;

		for (int to : edgesList[now]) {
			if (to != prev) {
				count[now] = cnt - count[to] + 1;
				dp[now] = answer[now] * invFact[cnt] % MOD * powMod(dp[to], MOD - 2) % MOD * fact[count[to]] % MOD
						* fact[cnt - count[to]] % MOD;
				calcAnswer(edgesList, fact, invFact, dp, count, answer, to, now);
			}
		}
	}
}
