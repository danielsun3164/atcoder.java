package abc.abc011;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc011/submissions/4385355 と https://atcoder.jp/contests/abc011/submissions/3044267
 * を参考に作成
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), d = scanner.nextInt();
			int x = Math.abs(scanner.nextInt()), y = Math.abs(scanner.nextInt());
			if ((0 == (x % d)) && (0 == (y % d))) {
				int xd = x / d;
				int yd = y / d;
				double[][] probability = getProbabilityNCk(n, n);
				System.out.println(IntStream.rangeClosed(0, n)
						.filter(i -> (xd <= i) && (yd <= (n - i)) && (0 == ((i - xd) % 2) && (0 == ((n - i - yd) % 2))))
						.mapToDouble(i -> probability[n][i] * probability[i][(i + xd) / 2]
								* probability[n - i][(n - i + yd) / 2])
						.sum());
			} else {
				System.out.println(0.0d);
			}
		}
	}

	/**
	 * @param n
	 * @param k
	 * @return n_C_k / 2.0^n の配列
	 */
	private static double[][] getProbabilityNCk(int n, int k) {
		double[][] ans = new double[n + 1][k + 1];
		ans[0][0] = 1.0;
		IntStream.rangeClosed(1, n).forEach(i -> ans[i][0] = ans[i - 1][0] / 2.0);
		IntStream.range(0, n).forEach(i -> IntStream.range(0, k).forEach(j -> {
			if (i < j) {
				ans[i][j] = 0.0;
			} else {
				ans[i + 1][j + 1] = (ans[i][j] + ans[i][j + 1]) / 2.0;
			}
		}));
		return ans;
	}
}
