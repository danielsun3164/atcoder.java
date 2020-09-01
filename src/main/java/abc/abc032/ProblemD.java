package abc.abc032;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード<br/>
 * https://atcoder.jp/contests/abc032/submissions/1585775 にも参考
 */
public class ProblemD {

	/** getResultの計算結果のマップ */
	private static final Map<List<Long>, Long> resultMap = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long W = scanner.nextLong();
			long[] v = new long[n], w = new long[n];
			IntStream.range(0, n).forEach(i -> {
				v[i] = scanner.nextLong();
				w[i] = scanner.nextLong();
			});
			long vMax = Arrays.stream(v).max().getAsLong();
			if (n <= 30) {
				System.out.println(getResult(0, W, v, w));
			} else if (vMax <= 1000) {
				System.out.println(getResultV(W, v, w, (int) vMax));
			} else {
				System.out.println(getResultW(W, v, w));
			}
		}
	}

	/**
	 * @param index 現在のindex
	 * @param maxW  重さの制限
	 * @param v     価値の配列
	 * @param w     重さの配列
	 * @return 計算結果
	 */
	private static long getResult(int index, long maxW, final long[] v, final long[] w) {
		List<Long> key = Arrays.asList((long) index, maxW);
		Long result = resultMap.get(key);
		if (null != result) {
			return result;
		}
		if (index >= v.length) {
			result = 0L;
		} else if (w[index] > maxW) {
			result = getResult(index + 1, maxW, v, w);
		} else {
			result = Math.max(getResult(index + 1, maxW, v, w), getResult(index + 1, maxW - w[index], v, w) + v[index]);
		}
		resultMap.put(key, result);
		return result;
	}

	/**
	 * @param W    重さの制限
	 * @param v    価値の配列
	 * @param w    重さの配列
	 * @param vMax vの最大値
	 * @return vを使った計算結果
	 */
	private static long getResultV(final long W, final long[] v, final long[] w, int vMax) {
		int max = v.length * vMax;
		long[] dp = new long[max + 1];
		Arrays.fill(dp, Long.MAX_VALUE >> 1);
		dp[0] = 0L;
		IntStream.range(0, v.length).forEach(i -> {
			for (int j = max; j >= v[i]; j--) {
				dp[j] = Math.min(dp[j], dp[(int) (j - v[i])] + w[i]);
			}
		});
		return IntStream.rangeClosed(0, max).map(i -> max - i).filter(i -> dp[i] <= W).findFirst().orElse(0);
	}

	/**
	 * @param W 重さの制限
	 * @param v 価値の配列
	 * @param w 重さの配列
	 * @return wを使った計算結果
	 */
	private static long getResultW(final long W, final long[] v, final long[] w) {
		int max = w.length * (int) Arrays.stream(w).max().getAsLong();
		long[] dp = new long[max + 1];
		Arrays.fill(dp, 0L);
		IntStream.range(0, w.length).forEach(i -> {
			for (int j = max; j >= w[i]; j--) {
				dp[j] = Math.max(dp[j], dp[(int) (j - w[i])] + v[i]);
			}
		});
		return dp[(int) W];
	}
}
