package abc.abc201_250.abc243;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc243/submissions/30016708 にも参考
 */
public class ProblemG別回答 {

	/** dpのサイズ */
	private static final int N = 100_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long[] dp = new long[N + 1], dpSum1 = new long[N + 1], dpSum2 = new long[N + 1];
			dp[1] = dpSum1[1] = 1L;
			IntStream.rangeClosed(2, N).forEach(i -> {
				dp[i] = dpSum1[(int) isqrt(i)];
				dpSum1[i] = dpSum1[i - 1] + dp[i];
				dpSum2[i] = dpSum2[i - 1] + dp[i] * ((long) i * i - 1);
			});
			int t = scanner.nextInt();
			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			while (t-- > 0) {
				long x = scanner.nextLong(), x2 = isqrt(x), x4 = isqrt(x2);
				sb.append(x2 * dpSum1[(int) x4] - dpSum2[(int) x4]).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 平方根を計算する
	 *
	 * @param n
	 * @return 平方根
	 */
	private static long isqrt(long n) {
		long sqrtN = (long) (Math.sqrt(n) - 1);
		while (sqrtN + 1 <= n / (sqrtN + 1)) {
			sqrtN++;
		}
		return sqrtN;
	}
}
