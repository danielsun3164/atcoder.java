package abc.abc201_250.abc243;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc243/submissions/30016698 にも参考
 */
public class ProblemG {

	/** dpのサイズ */
	private static final int N = 100_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long[] dp = new long[N + 1], dpSum = new long[N + 1];
			dp[1] = dpSum[1] = 1L;
			IntStream.rangeClosed(2, N).forEach(i -> {
				dp[i] = dpSum[(int) isqrt(i)];
				dpSum[i] = dpSum[i - 1] + dp[i];
			});
			int t = scanner.nextInt();
			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			while (t-- > 0) {
				long x = scanner.nextLong(), x2 = isqrt(x), x4 = isqrt(x2);
				sb.append(LongStream.rangeClosed(1, x4).map(i -> (x2 - i * i + 1) * dp[(int) i]).sum())
						.append(System.lineSeparator());
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
