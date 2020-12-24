package abc.abc051_100.abc095;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc095/submissions/11235537 を参考に実装
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long c = scanner.nextLong();
			long[] x = new long[n + 1], v = new long[n + 1];
			x[0] = v[0] = 0L;
			// sumV[i]=v[1]+...+v[i]
			long[] sumV = new long[n + 1];
			sumV[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				x[i] = scanner.nextLong();
				v[i] = scanner.nextLong();
				sumV[i] = sumV[i - 1] + v[i];
			});
			long[] left = new long[n + 1], leftBack = new long[n + 1];
			left[0] = leftBack[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				left[i] = Math.max(left[i - 1], sumV[i] - x[i]);
				leftBack[i] = Math.max(leftBack[i - 1], sumV[i] - x[i] * 2);
			});
			long[] right = new long[n + 1], rightBack = new long[n + 1];
			right[0] = rightBack[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				right[i] = Math.max(right[i - 1], (sumV[n] - sumV[n - i]) - (c - x[n + 1 - i]));
				rightBack[i] = Math.max(rightBack[i - 1], (sumV[n] - sumV[n - i]) - (c - x[n + 1 - i]) * 2);
			});
			System.out.println(IntStream.rangeClosed(0, n)
					.mapToLong(i -> Math.max(left[i] + rightBack[n - i], leftBack[i] + right[n - i])).max()
					.getAsLong());
		}
	}
}
