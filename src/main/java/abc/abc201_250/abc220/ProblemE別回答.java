package abc.abc201_250.abc220;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc220/editorial/2929 の実装
 */
public class ProblemE別回答 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), d = scanner.nextInt();
			long[] p2 = new long[Math.max((n << 1) + 1, d + 1)];
			Arrays.fill(p2, 1L);
			IntStream.range(1, (n << 1) + 1).forEach(i -> p2[i] = (p2[i - 1] << 1) % MOD);
			long answer = 0L;
			for (int i = 0; i < n; i++) {
				long f1d = (i + d < n) ? p2[d + 1] : 0L;
				long f2d = 0L;
				if ((2 * (n - 1 - i) < d) || (1 == d)) {
					f2d = 0L;
				} else if (i + d < n) {
					f2d = p2[d - 1] * (d - 1) % MOD;
				} else {
					f2d = p2[d - 1] * (2 * (n - i) - d - 1 + MOD) % MOD;
				}
				answer = (answer + p2[i] * (f1d + f2d) % MOD) % MOD;
			}
			System.out.println(answer);
		}
	}
}
