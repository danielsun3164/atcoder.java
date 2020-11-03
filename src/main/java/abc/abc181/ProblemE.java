package abc.abc181;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[] h = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[] w = IntStream.range(0, m).mapToLong(i -> scanner.nextLong()).toArray();
			Arrays.sort(h);
			long[] diff = new long[n];
			diff[0] = 0L;
			IntStream.range(1, n).forEach(i -> diff[i] = h[i] - h[i - 1]);
			// sum1は(0,1)、(2,3)のペアの差分の合計，sum2は(1,2)、(3,4)のペアの差分の合計
			long[] sum1 = new long[n], sum2 = new long[n];
			sum1[0] = sum2[0] = 0L;
			for (int i = 1; i < n; i++) {
				if (0 == (i & 1)) {
					sum1[i] = sum1[i - 1];
					sum2[i] = sum2[i - 1] + diff[i];
				} else {
					sum1[i] = sum1[i - 1] + diff[i];
					sum2[i] = sum2[i - 1];
				}
			}
			System.out
					.println(IntStream.range(0, m).mapToLong(i -> getResult(n, h, w[i], sum1, sum2)).min().getAsLong());
		}
	}

	/**
	 * 与えれたwからペアの身長差合計の最小値を計算する
	 * 
	 * @param n    人数
	 * @param h    身長の配列
	 * @param w    先生の身長
	 * @param sum1 (0,1)、(2,3)のペアの差分の合計
	 * @param sum2 (1,2)、(3,4)のペアの差分の合計
	 * @return 与えれたwからペアの身長差合計の最小値
	 */
	private static long getResult(int n, long[] h, long w, long[] sum1, long[] sum2) {
		int index = Arrays.binarySearch(h, w);
		if (index >= 0) {
			return sum2[n - 1] - sum2[index] + sum1[index];
		} else {
			index = ~index;
			index &= Integer.MAX_VALUE - 1;
			return Math.abs(w - h[index]) + sum2[n - 1] - sum2[index] + sum1[index];
		}
	}
}
