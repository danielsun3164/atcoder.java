package abc.abc201_250.abc239;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc239/editorial/3357 のmapを使った解法の実装
 */
public class ProblemEx別回答 {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			System.out.println(solve(n, m, new HashMap<>()));
		}
	}

	/**
	 * n,mの結果を計算
	 *
	 * @param n
	 * @param m
	 * @param memo
	 * @return n,mの結果
	 */
	private static long solve(int n, int m, Map<Integer, Long> memo) {
		if (memo.containsKey(m)) {
			return memo.get(m);
		}
		long result = 0L;
		int l;
		for (int r = m; r > 0; r = l) {
			int q = m / r;
			l = m / (q + 1);
			if (q != m) {
				result = (result + solve(n, q, memo) * (Math.min(n, r) - Math.min(n, l)) % MOD) % MOD;
			}
		}
		result = (n + result) * powMod(n - 1, MOD - 2) % MOD;
		memo.put(m, result);
		return result;
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
