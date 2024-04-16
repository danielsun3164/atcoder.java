package abc.abc201_250.abc222;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc222/submissions/26423813 を参考に作成
 */
public class ProblemH {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** ceo */
	private static final long[][] COE = { { 0L, 30L, MOD - 21, MOD - 270, 189L },
			{ MOD - 480, 3012L, MOD - 6858, 6642L, MOD - 2268 },
			{ MOD - 1800, 9900L, MOD - 18100, 12400L, MOD - 2800 } };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] answer = new long[n + 1];
			Arrays.fill(answer, 0L);
			answer[1] = 1L;
			for (int i = 2; i <= n; i++) {
				long sum = 0L;
				for (int j = 1; j < COE.length; j++) {
					sum = (sum + f(COE[j], i) * answer[i - j] % MOD) % MOD;
				}
				answer[i] = sum * (MOD - powMod(f(COE[0], i), MOD - 2)) % MOD;
			}
			System.out.println(answer[n]);
		}
	}

	private static long f(long[] coe, int n) {
		long answer = 0L;
		for (int i = coe.length - 1; i >= 0; i--) {
			answer = (answer * n % MOD + coe[i]) % MOD;
		}
		return answer;
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
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
