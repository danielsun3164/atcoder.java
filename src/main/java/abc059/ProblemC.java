package abc059;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextLong());
			// sum1=[1,-1,...], sum2=[-1,1,...]
			int[] sum1 = new int[n], sum2 = new int[n];
			Arrays.fill(sum1, 1);
			Arrays.fill(sum2, -1);
			IntStream.range(0, n / 2).forEach(i -> {
				sum1[2 * i + 1] = -1;
				sum2[2 * i + 1] = 1;
			});
			System.out.println(Math.min(getResult(a, sum1), getResult(a, sum2)));
		}
	}

	/**
	 * @param a   数値配列
	 * @param sum 変更したい合計値の配列
	 * @return 変更が必要なステップ数
	 */
	private static long getResult(final long[] a, final int[] sum) {
		int n = a.length;
		long now = 0, result = 0;
		for (int i = 0; i < n; i++) {
			now += a[i];
			if (sum[i] * now <= 0) {
				result += Math.abs(sum[i] - now);
				now = sum[i];
			}
		}
		return result;
	}
}
