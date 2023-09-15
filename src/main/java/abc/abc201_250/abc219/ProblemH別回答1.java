package abc.abc201_250.abc219;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc219/editorial/2669 解法の実装
 */
public class ProblemH別回答1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(scanner.nextLong(), scanner.nextLong()))
					.sorted().toArray(Data[]::new);
			long[] x = new long[n], a = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = datas[i].x;
				a[i] = datas[i].a;
			});
			long[][][] dpL = new long[n][n][], dpR = new long[n][n][];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(dpL[i], new long[] {});
				Arrays.fill(dpR[i], new long[] {});
			});
			dpL[0][n - 1] = new long[] { 0L };
			dpR[0][n - 1] = new long[] { 0L };
			IntStream.range(0, n).forEach(l -> IntStream.rangeClosed(1, n - l).map(r -> n - r).forEach(r -> {
				dpL[l][r] = mergeSlope(dpL[l][r], slideSlope(dpR[l][r], x[r] - x[l]));
				dpR[l][r] = mergeSlope(dpR[l][r], slideSlope(dpL[l][r], x[r] - x[l]));
				dpL[l][r] = addLine(dpL[l][r], a[l]);
				dpR[l][r] = addLine(dpR[l][r], a[r]);
				if (l != r) {
					dpL[l + 1][r] = mergeSlope(dpL[l + 1][r], slideSlope(dpL[l][r], x[l + 1] - x[l]));
					dpR[l][r - 1] = mergeSlope(dpR[l][r - 1], slideSlope(dpR[l][r], x[r] - x[r - 1]));
				}
			}));
			System.out.println(IntStream.range(0, n)
					.mapToLong(s -> Arrays.stream(slideSlope(dpL[s][s], Math.abs(x[s]))).max().getAsLong()).max()
					.getAsLong());
		}
	}

	/**
	 * aの値をd移動した場合の結果配列を計算する
	 *
	 * @param a
	 * @param d
	 * @return aの値をd移動した場合の結果配列
	 */
	private static long[] slideSlope(long[] a, long d) {
		long[] result = new long[a.length];
		IntStream.range(0, a.length).forEach(i -> result[i] = a[i] - i * d);
		return result;
	}

	/**
	 * aの配列とbの配列を結合して、それぞれ最大値を残る
	 *
	 * @param a
	 * @param b
	 * @return aの配列とbの配列を結合した結果
	 */
	private static long[] mergeSlope(long[] a, long[] b) {
		long[] result = new long[Math.max(a.length, b.length)];
		Arrays.fill(result, 0L);
		IntStream.range(0, a.length).forEach(i -> result[i] = Math.max(result[i], a[i]));
		IntStream.range(0, b.length).forEach(i -> result[i] = Math.max(result[i], b[i]));
		return result;
	}

	/**
	 * aの配列に値を追加する
	 *
	 * @param a
	 * @param p
	 * @return 値を追加した配列
	 */
	private static long[] addLine(long[] a, long p) {
		int pd = 0;
		long value = -1;
		for (int i = 0; i < a.length; i++) {
			long pValue = a[i] - p * i;
			if (pValue > value) {
				value = pValue;
				pd = i;
			}
		}
		long[] result = new long[a.length + 1];
		System.arraycopy(a, 0, result, 0, pd + 1);
		IntStream.range(pd, a.length).forEach(i -> result[i + 1] = a[i] + p);
		return result;
	}

	/**
	 * x, aを格納するクラス
	 */
	private static class Data implements Comparable<Data> {
		long x, a;

		Data(long x, long a) {
			super();
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(Data o) {
			if (x == o.x) {
				return Long.compare(a, o.a);
			}
			return Long.compare(x, o.x);
		}
	}
}
