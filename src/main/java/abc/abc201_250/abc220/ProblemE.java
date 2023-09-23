package abc.abc201_250.abc220;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc220/editorial/2679 の実装
 */
public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 998_244_353;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), d = scanner.nextInt();
			long[] p2 = new long[Math.max((n << 1) + 1, d)];
			p2[0] = 1L;
			IntStream.range(1, (n << 1) + 1).forEach(i -> p2[i] = (p2[i - 1] << 1) % MOD);
			long answer = 0L;
			if (1 != d) {
				for (int i = 0; i < n; i++) {
					answer = (answer + p2[i] * p2[d - 2] % MOD * f(n - 1 - i, d)) % MOD;
				}
			}
			for (int i = 0; i < n - d; i++) {
				answer = (answer + p2[i] * p2[d] % MOD) % MOD;
			}
			System.out.println((answer << 1) % MOD);
		}
	}

	/**
	 * 1以上b以下の2数で和をxにする
	 *
	 * @param b
	 * @param x
	 * @return 1以上b以下の2数で和をxにした値
	 */
	private static long f(long b, long x) {
		return Math.max(0L, b - Math.abs(x - (b + 1)));
	}
}
