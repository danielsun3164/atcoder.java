package abc042;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt();
			int w = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			// 階乗の配列
			long[] frac = new long[h + w - 1];
			frac[0] = 1;
			IntStream.range(1, frac.length).forEach(i -> frac[i] = frac[i - 1] * i % MOD);
			// 階乗^-1の配列
			long[] reverseFrac = new long[h + w - 1];
			reverseFrac[h + w - 2] = powMod(frac[h + w - 2], MOD - 2);
			IntStream.range(1, reverseFrac.length).map(i -> reverseFrac.length - i - 1)
					.forEach(i -> reverseFrac[i] = reverseFrac[i + 1] * (i + 1) % MOD);
			long answer = 0L;
			for (int i = b; i < w; i++) {
				answer += frac[h - a - 1 + i] * reverseFrac[h - a - 1] % MOD * reverseFrac[i] % MOD
						* frac[a + w - 2 - i] % MOD * reverseFrac[a - 1] % MOD * reverseFrac[w - 1 - i] % MOD;
				answer %= MOD;
			}
			System.out.println(answer);
		}
	}

	/**
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (m & 1)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
