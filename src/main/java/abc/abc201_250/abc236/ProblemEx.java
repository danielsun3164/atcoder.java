package abc.abc201_250.abc236;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc236/editorial/3289 の実装<br/>
 * https://atcoder.jp/contests/abc236/submissions/28703931 にも参考
 */
public class ProblemEx {

	/** mod対象数字 */
	private static final int MOD = 998_244_353;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long m = scanner.nextLong();
			long[] d = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray(), edges = new long[n + 1],
					comp = new long[1 << n];
			edges[1] = 1L;
			IntStream.rangeClosed(2, n).forEach(i -> edges[i] = (MOD - edges[i - 1]) * (i - 1) % MOD);
			IntStream.range(1, 1 << n).forEach(bit -> {
				long lcm = 1L;
				for (int i = 0; i < n; i++) {
					if (1 == (1 & (bit >> i))) {
						lcm /= gcd(lcm, d[i]);
						if (lcm > m / d[i]) {
							lcm = m + 1;
							break;
						}
						lcm *= d[i];
					}
				}
				comp[bit] = (m / lcm) % MOD * edges[Integer.bitCount(bit)] % MOD;
			});
			long[] count = new long[1 << n];
			Arrays.fill(count, 0L);
			IntStream.range(1, 1 << n).forEach(bit -> {
				int min = Integer.numberOfTrailingZeros(bit);
				count[bit] = comp[bit];
				for (int sub = (bit - 1) & bit; sub > 0; sub = (sub - 1) & bit) {
					if (1 == (1 & (sub >> min))) {
						count[bit] = (count[bit] + comp[sub] * count[bit & ~sub] % MOD) % MOD;
					}
				}
			});
			System.out.println(count[(1 << n) - 1]);
		}
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0L == b) ? a : gcd(b, a % b);
	}
}
