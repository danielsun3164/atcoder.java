package abc.abc201_250.abc222;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc222/submissions/37678511 を参考に作成
 */
public class ProblemH別回答 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long n2 = n << 1, p0 = n2 * 3, p1 = 1;
			for (int i = 1; i <= n - 1; i++) {
				long p2 = p1, k = i;
				p1 = p0;
				p0 = (3 * ((n2 - k + MOD) % MOD) % MOD * p1 % MOD + k * ((n2 * 2 - k + 1 + MOD) % MOD) % MOD * p2 % MOD)
						% MOD;
			}
			long fact = 1L;
			for (int i = 1; i <= n; i++) {
				fact = fact * i % MOD;
			}
			System.out.println(p1 * powMod(fact, MOD - 2) % MOD);
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
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
