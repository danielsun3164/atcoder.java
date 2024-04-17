package abc.abc201_250.abc222;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc222/submissions/26431164 を参考に作成
 */
public class ProblemH別回答2 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long m = n << 1;
			long[] u = new long[n + 1], inv = new long[n + 1];
			Arrays.fill(u, 0L);
			Arrays.fill(inv, 1L);
			u[0] = 1L;
			IntStream.range(1, n).forEach(i -> {
				u[i] = (u[i - 1] * 3 * (m + 1 - i) % MOD + ((i > 1) ? u[i - 2] * (2 * m + 2 - i) : 0L) % MOD) % MOD
						* inv[i] % MOD;
				inv[i + 1] = MOD - inv[(int) (MOD % (i + 1))] * (MOD / (i + 1)) % MOD;
			});
			System.out.println(u[n - 1] * inv[n] % MOD);
		}
	}
}
