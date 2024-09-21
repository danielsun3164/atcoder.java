package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem100 {

	/** 初期化状態 */
	private static final double[][] INIT = { { 1.0d, 1.0d, 1.0d } };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				double x = scanner.nextDouble(), y = scanner.nextDouble(), z = scanner.nextDouble();
				int t = scanner.nextInt();
				double[][] answer = multiple(INIT,
						pow(new double[][] { { 1.0 - x, 0.0, x }, { y, 1.0 - y, 0.0 }, { 0.0, z, 1.0 - z } }, t));
				sb.append(Arrays.stream(answer[0]).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
						.append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 行列a x 行列bを計算する
	 *
	 * @param a
	 * @param b
	 * @return 行列a x 行列bの結果
	 */
	private static double[][] multiple(double[][] a, double[][] b) {
		double[][] result = new double[a.length][b[0].length];
		IntStream.range(0, a.length).forEach(i -> IntStream.range(0, b[i].length).forEach(
				j -> result[i][j] = IntStream.range(0, a[i].length).mapToDouble(k -> a[i][k] * b[k][j]).sum()));
		return result;
	}

	/**
	 * 行列d ^ tを計算する
	 *
	 * @param d
	 * @param t
	 * @return 行列d ^ t
	 */
	private static double[][] pow(double[][] d, int t) {
		int n = d.length;
		double[][] result = new double[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(result[i], 0.0d);
			result[i][i] = 1.0d;
		}
		while (t > 0) {
			if (1 == (1 & t)) {
				result = multiple(result, d);
			}
			d = multiple(d, d);
			t >>= 1;
		}
		return result;
	}
}
