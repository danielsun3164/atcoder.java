package abc022;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] a = new int[n][2];
			int[][] b = new int[n][2];
			IntStream.range(0, n).forEach(i -> {
				a[i][0] = scanner.nextInt();
				a[i][1] = scanner.nextInt();
			});
			IntStream.range(0, n).forEach(i -> {
				b[i][0] = scanner.nextInt();
				b[i][1] = scanner.nextInt();
			});
			System.out.println(getMaxDistanceFromCenter(b) / getMaxDistanceFromCenter(a));
		}
	}

	/**
	 * @param a 座標の配列
	 * @return 重心から一覧遠い点との間の距離
	 */
	private static double getMaxDistanceFromCenter(int[][] a) {
		double[] center = getCenter(a);
		return IntStream.range(0, a.length).mapToDouble(i -> getDistance(a[i], center)).max().getAsDouble();
	}

	/**
	 * @param a 座標の配列
	 * @return 重心の座標、[0]はx座標、[1]はy座標
	 */
	private static double[] getCenter(int[][] a) {
		double[] result = new double[2];
		Arrays.fill(result, 0.0d);
		Arrays.stream(a).forEach(point -> {
			result[0] += point[0];
			result[1] += point[1];
		});
		result[0] = result[0] / a.length;
		result[1] = result[1] / a.length;
		return result;
	}

	/**
	 * @param from 座標
	 * @param to   座標
	 * @return fromとtoの間の距離
	 */
	private static double getDistance(int[] from, double[] to) {
		return Math.sqrt((from[0] - to[0]) * (from[0] - to[0]) + (from[1] - to[1]) * (from[1] - to[1]));
	}
}
