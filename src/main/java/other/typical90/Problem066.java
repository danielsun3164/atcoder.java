package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem066 {

	/** 数字の最大値 */
	private static final int MAX = 100;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			double[] p = new double[MAX + 1];
			Arrays.fill(p, 0.0d);
			// sum[i] は p[i+1]+...+p[MAX]
			double[] sum = new double[MAX + 1];
			Arrays.fill(sum, 0.0d);
			// sumsum[i] は sum[i]+...+sum[MAX]
			double[] sumSum = new double[MAX + 2];
			Arrays.fill(sumSum, 0.0d);
			System.out.println(IntStream.range(0, n).mapToDouble(i_ -> {
				int l = scanner.nextInt(), r = scanner.nextInt();
				double pp = 1.0d / (r + 1 - l);
				double result = (sumSum[l] - sumSum[r + 1]) * pp;
				IntStream.rangeClosed(l, r).forEach(i -> p[i] += pp);
				IntStream.range(0, MAX).map(i -> MAX - 1 - i).forEach(i -> sum[i] = sum[i + 1] + p[i + 1]);
				IntStream.rangeClosed(0, MAX).map(i -> MAX - i).forEach(i -> sumSum[i] = sumSum[i + 1] + sum[i]);
				return result;
			}).sum());
		}
	}
}
