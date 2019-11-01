package abc068;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説どおりに作成したソースコード
 */
public class ProblemD {

	private static final int N = 50;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long k = scanner.nextLong();
			long[] a = new long[N];
			IntStream.range(0, N).forEach(i -> a[i] = k / N + i);
			LongStream.range(0, k % N).forEach(l -> calcReverse(a, (int) (l % N)));
			System.out.println(N);
			IntStream.range(0, N - 1).forEach(i -> System.out.print(a[i] + " "));
			System.out.println(a[N - 1]);
		}
	}

	/**
	 * 指定された操作の逆操作を実施
	 * 
	 * @param a     操作対象の配列
	 * @param index 足し算をするindex
	 */
	private static void calcReverse(final long[] a, final int index) {
		a[index] += N + 1;
		IntStream.range(0, N).forEach(i -> a[i]--);
	}
}
