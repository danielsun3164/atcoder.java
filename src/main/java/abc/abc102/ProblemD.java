package abc.abc102;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] sum = new long[n + 1];
			sum[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> sum[i] = sum[i - 1] + scanner.nextInt());
			// 左と右の配列のそれぞれ区切ったところ
			int left = 1, right = 3;
			long answer = Long.MAX_VALUE;
			for (int i = 2; i <= n - 2; i++) {
				while ((left < i - 1) && (Math.abs(sum[left] - (sum[i] - sum[left])) > Math
						.abs(sum[left + 1] - (sum[i] - sum[left + 1])))) {
					left++;
				}
				while ((right < n - 1) && (Math.abs((sum[right] - sum[i]) - (sum[n] - sum[right])) > Math
						.abs((sum[right + 1] - sum[i]) - (sum[n] - sum[right + 1])))) {
					right++;
				}
				answer = Math.min(answer,
						Math.abs(max(sum[left], sum[i] - sum[left], sum[right] - sum[i], sum[n] - sum[right])
								- min(sum[left], sum[i] - sum[left], sum[right] - sum[i], sum[n] - sum[right])));
			}
			System.out.println(answer);
		}
	}

	/**
	 * 複数のlongの最大値を取得する
	 * 
	 * @param longs 複数のlong
	 * @return 複数のlongの最大値
	 */
	private static long max(long... longs) {
		if (null != longs) {
			return Arrays.stream(longs).max().getAsLong();
		}
		return 0L;
	}

	/**
	 * 複数のlongの最小値を取得する
	 * 
	 * @param longs 複数のlong
	 * @return 複数のlongの最小値
	 */
	private static long min(long... longs) {
		if (null != longs) {
			return Arrays.stream(longs).min().getAsLong();
		}
		return 0L;
	}
}
