package abc.abc101_150.abc133;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			long s = IntStream.range(0, n).mapToLong(i -> a[i] = scanner.nextInt()).sum();
			// sum[i]=a[1]+a[3]+...+a[i]
			long[] sum = new long[n], x = new long[n];
			sum[0] = 0L;
			IntStream.range(1, n).forEach(i -> sum[i] = sum[i - 1] + ((1 == (i & 1)) ? a[i] : 0L));
			// 0番目の要素はs-2*(sum[n-1))
			x[0] = s - 2 * sum[n - 1];
			IntStream.range(1, n).forEach(i -> x[i] = 2L * a[i - 1] - x[i - 1]);
			System.out.println(Arrays.stream(x).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
