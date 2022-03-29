package abc.abc201_250.abc213;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc213/submissions/24839074 にも参考
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), p = 1 << n;
			int[] e = new int[p];
			Arrays.fill(e, 0);
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				e[(1 << a) | (1 << b)] = 1;
			});
			for (int i = 1; i < p; i <<= 1) {
				for (int j = 0; j < p; j++) {
					if (0 == (j & i)) {
						e[j | i] += e[j];
					}
				}
			}
			// pow2[i] = 2^i mod MOD
			long[] pow2 = new long[m + 1];
			pow2[0] = 1L;
			IntStream.range(0, m).forEach(i -> pow2[i + 1] = pow2[i] * 2L % MOD);
			long[] g = new long[p], f = new long[p];
			IntStream.range(0, p).forEach(i -> g[i] = pow2[e[i]]);
			IntStream.range(1, p).forEach(i -> {
				int ctz = Integer.numberOfTrailingZeros(i);
				f[i] = g[i];
				for (int j = i - 1; j >= 0; j--) {
					j &= i;
					if (1 == (1 & (j >> ctz))) {
						f[i] = (f[i] - f[j] * g[i ^ j] % MOD + MOD) % MOD;
					}
				}
			});
			int full = p - 1;
			long[] answer = new long[n];
			Arrays.fill(answer, 0L);
			IntStream.range(1, n).forEach(node -> {
				int mask = (1 << node) | 1;
				IntStream.range(0, p).filter(i -> mask == (i & mask))
						.forEach(i -> answer[node] = (answer[node] + f[i] * g[full ^ i] % MOD) % MOD);
			});
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(1, n).forEach(i -> sb.append(answer[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
