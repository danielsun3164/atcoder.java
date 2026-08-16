package abc.abc201_250.abc240;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc240/editorial/3422 の実装<br/>
 * https://atcoder.jp/contests/abc240/submissions/29492199 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			long[] result = new long[t];
			IntStream.range(0, t).forEach(k -> {
				@SuppressWarnings("unused")
				int n = scanner.nextInt(), m = scanner.nextInt();
				long a = 0L, b = 0L, answer = Long.MIN_VALUE;
				for (int i = 0; i < n; i++) {
					int x = scanner.nextInt();
					long y = scanner.nextLong();
					if (x > 0) {
						answer = Math.max(answer, f(a, b, x, 1L));
						answer = Math.max(answer, f(a, b, x, y));
					} else {
						answer = Math.max(answer, optimize(a, b, x, 0L, y + 1));
					}
					a = f(a, b, x, y);
					b += x * y;
				}
				result[k] = answer;
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, t).forEach(i -> sb.append(result[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * f(k)を計算する
	 *
	 * @param a
	 * @param b
	 * @param x
	 * @param k
	 * @return f(k)
	 */
	private static long f(long a, long b, int x, long k) {
		return a + b * k + x * k * (k + 1) / 2;
	}

	/**
	 * i∈(low,high)の間で、f(i)の最大値を計算する
	 *
	 * @param a
	 * @param b
	 * @param x
	 * @param low
	 * @param high
	 * @return f(i)の最大値
	 */
	private static long optimize(long a, long b, int x, long low, long high) {
		while (high - low > 2L) {
			long m1 = (low + high) / 2L, m2 = m1 + 1;
			if (f(a, b, x, m1) < f(a, b, x, m2)) {
				low = m1;
			} else {
				high = m2;
			}
		}
		return f(a, b, x, low + 1);
	}
}
