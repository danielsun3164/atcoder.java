package abc.abc033;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード<br/>
 * https://atcoder.jp/contests/abc033/submissions/1771102 にも参考
 */
public class ProblemD {

	/** 誤差の範囲 */
	private static final double EPS = 1.0E-9;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			long[] result = getResult(n, x, y);
			result[0] = (long) n * (n - 1) / 2 * (n - 2) / 3 - result[1] - result[2];
			System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * @param n 点の数
	 * @param x x座標の配列
	 * @param y y座標の配列
	 * @return 鋭角、直角、鈍角の数の配列
	 */
	private static long[] getResult(int n, int[] x, int[] y) {
		long[] result = new long[3];
		Arrays.fill(result, 0);
		IntStream.range(0, n).forEach(i -> calcResult(n, x, y, i, result));
		return result;
	}

	/**
	 * i番目の点につながるすべての線の角度を計算
	 * 
	 * @param n      点の数
	 * @param x      x座標の配列
	 * @param y      y座標の配列
	 * @param i      現在計算している点
	 * @param result 鋭角、直角、鈍角の数の配列
	 */
	private static void calcResult(int n, int[] x, int[] y, int i, long[] result) {
		double[] degrees = IntStream.range(0, n).filter(j -> j != i)
				.mapToDouble(j -> Math.atan2(y[j] - y[i], x[j] - x[i])).sorted().toArray();
		double[] newDegrees = new double[2 * degrees.length];
		System.arraycopy(degrees, 0, newDegrees, 0, degrees.length);
		System.arraycopy(degrees, 0, newDegrees, degrees.length, degrees.length);
		IntStream.range(degrees.length, newDegrees.length).forEach(j -> newDegrees[j] += 2 * Math.PI);
		IntStream.range(0, degrees.length).forEach(j -> {
			double t1 = newDegrees[j] + Math.PI / 2 - EPS;
			double t2 = newDegrees[j] + Math.PI / 2 + EPS;
			double t3 = newDegrees[j] + Math.PI - EPS;
			int i1 = Arrays.binarySearch(newDegrees, j + 1, j + n - 1, t1);
			int i2 = Arrays.binarySearch(newDegrees, j + 1, j + n - 1, t2);
			int i3 = Arrays.binarySearch(newDegrees, j + 1, j + n - 1, t3);
			if (i1 < 0) {
				i1 = -i1 - 1;
			}
			if (i2 < 0) {
				i2 = -i2 - 1;
			}
			if (i3 < 0) {
				i3 = -i3 - 1;
			}
			// 直角
			result[1] += i2 - i1;
			// 鈍角
			result[2] += i3 - i2;
		});
	}
}
