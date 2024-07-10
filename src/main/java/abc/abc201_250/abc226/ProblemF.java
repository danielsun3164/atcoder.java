package abc.abc201_250.abc226;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc226/editorial/2878 の実装<br/>
 * https://atcoder.jp/contests/abc226/submissions/27241706 にも参考
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	private static long answer;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] fact = new long[(n << 1) + 1], invFact = new long[(n << 1) + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n << 1).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[n << 1] = powMod(fact[n << 1], MOD - 2);
			IntStream.range(0, n << 1).map(i -> (n << 1) - 1 - i)
					.forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			answer = 0L;
			dfs(fact, invFact, k, n, 0, 0, 1L, fact[n]);
			System.out.println(answer);
		}
	}

	/**
	 * 結果を再帰的に計算する
	 *
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param k       結果計算時のべき乗
	 * @param rest    残りの数
	 * @param now     現在の計算対象
	 * @param c
	 * @param lcm     最小公倍数
	 * @param ways    ケース数
	 */
	private static void dfs(long[] fact, long[] invFact, int k, int rest, int now, int c, long lcm, long ways) {
		if ((now != 0) && (rest >= now)) {
			dfs(fact, invFact, k, rest - now, now, c + 1, lcm, ways);
		}
		if (now > 0) {
			ways = ways * powMod(fact[now - 1], c) % MOD;
		}
		ways = ways * powMod(invFact[now], c) % MOD * invFact[c] % MOD;
		if (0 == rest) {
			answer = (answer + powMod(lcm, k) * ways % MOD) % MOD;
			return;
		}
		for (int j = now + 1; j <= rest; j++) {
			dfs(fact, invFact, k, rest - j, j, 1, lcm(lcm, j), ways);
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
	 * a と bの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return 最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0L == b) ? a : gcd(b, a % b);
	}

	/**
	 * a と bの最小公倍数を計算する
	 *
	 * @param a
	 * @param b
	 * @return 最小公倍数
	 */
	private static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
}
