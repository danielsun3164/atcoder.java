package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem071 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			double[] a = new double[n], b = new double[n], c = new double[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextDouble();
				b[i] = scanner.nextDouble();
				c[i] = scanner.nextDouble();
			});
			System.out.println(IntStream.range(0, n).mapToDouble(
					i -> IntStream.range(i + 1, n).filter(j -> a[i] * b[j] != a[j] * b[i]).mapToDouble(j -> {
						double px = (c[i] * b[j] - c[j] * b[i]) / (a[i] * b[j] - a[j] * b[i]),
								py = (c[i] * a[j] - c[j] * a[i]) / (b[i] * a[j] - b[j] * a[i]);
						return check(n, a, b, c, px, py) ? px + py : 0.0d;
					}).max().orElse(0.0d)).max().getAsDouble());
		}
	}

	/**
	 * x,yがすべてのa,b,cに対して、ax+by<=c が満たしているかを判定する
	 *
	 * @param n 配列の要素数
	 * @param a
	 * @param b
	 * @param c
	 * @param x
	 * @param y
	 * @return x,yがすべてのa,b,cに対して、ax+by<=c が満たしているか
	 */
	private static boolean check(int n, double[] a, double[] b, double[] c, double x, double y) {
		return 0 == IntStream.range(0, n).filter(i -> a[i] * x + b[i] * y > c[i]).count();
	}
}
