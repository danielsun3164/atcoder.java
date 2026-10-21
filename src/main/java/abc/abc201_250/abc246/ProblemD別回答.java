package abc.abc201_250.abc246;

import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://drken1215.hatenablog.com/entry/2022/04/03/144800 の実装
 */
public class ProblemD別回答 {

	/** aとbの最大値 */
	private static final long MAX = 1_000_000L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			System.out.println(LongStream.rangeClosed(0, MAX).map(a -> solve(n, a)).min().getAsLong());
		}
	}

	/**
	 * aが固定の場合、n以上となるf(a,b)の最小値
	 *
	 * @param n
	 * @param a
	 * @return f(a,b)の最小値
	 */
	private static long solve(long n, long a) {
		long low = -1, high = MAX;
		while (high - low > 1) {
			long b = (low + high) >> 1;
			if (fn(a, b) >= n) {
				high = b;
			} else {
				low = b;
			}
		}
		return fn(a, high);
	}

	/**
	 * f(a,b)を計算する
	 *
	 * @param a
	 * @param b
	 * @return f(a,b)
	 */
	private static long fn(long a, long b) {
		return a * a * a + a * a * b + a * b * b + b * b * b;
	}
}
