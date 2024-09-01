package abc.abc201_250.abc235;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc235/editorial/3247 の実装<br/>
 * https://atcoder.jp/contests/abc235/submissions/28518864 にも参考
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 1024 */
	private static final int N = 1024;
	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length, m = scanner.nextInt();
			long mask = IntStream.range(0, m).mapToLong(i -> 1L << scanner.nextLong()).sum();
			int digits = 0;
			long spre = 0L;
			long[] sum = new long[N], count = new long[N];
			Arrays.fill(sum, 0L);
			Arrays.fill(count, 0L);
			for (int i = 0; i < n; i++) {
				long[] newSum = new long[N], newCount = new long[N];
				Arrays.fill(newSum, 0L);
				Arrays.fill(newCount, 0L);
				int c = s[i] - '0';
				for (int j = 1; j < N; j++) {
					for (int d = 0; d < TEN; d++) {
						newCount[j | 1 << d] += count[j];
						newSum[j | 1 << d] += sum[j] * TEN + count[j] * d;
					}
				}
				if (i > 0) {
					for (int d = 1; d < TEN; d++) {
						newCount[1 << d]++;
						newSum[1 << d] += d;
					}
				}
				for (int d = (i > 0) ? 0 : 1; d < c; d++) {
					newCount[digits | 1 << d]++;
					newSum[digits | 1 << d] += spre * TEN + d;
				}
				for (int j = 1; j < N; j++) {
					count[j] = newCount[j] % MOD;
					sum[j] = newSum[j] % MOD;
				}
				digits |= 1 << c;
				spre = (spre * TEN + c) % MOD;
			}
			System.out.println((IntStream.range(0, N).filter(i -> (i & mask) == mask).mapToLong(i -> sum[i]).sum()
					+ (((digits & mask) == mask) ? spre : 0L)) % MOD);
		}
	}
}
