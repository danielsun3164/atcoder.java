package abc.abc026;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 誤差の範囲 */
	private static final double TOLERANCE = 0.000001d;
	/** 計算結果 */
	private static final double RESULT = 100.0d;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			double from = (100.0d - b) / a;
			double to = (100.0d + b) / a;
			System.out.println(calc(a, b, c, from, to));
		}
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 * @param from
	 * @param to
	 * @return from〜toの間に結果となる値
	 */
	private static double calc(final int a, final int b, final int c, double from, double to) {
		double middle = (from + to) / 2.0d;
		double resultMiddle = f(a, b, c, middle);
		if (isOk(resultMiddle)) {
			return middle;
		} else if (resultMiddle > 100.0d) {
			return calc(a, b, c, from, middle);
		} else {
			return calc(a, b, c, middle, to);
		}
	}

	/**
	 * @param d
	 * @return dと計算結果との誤差が許容範囲内かどうか
	 */
	private static boolean isOk(double d) {
		return Math.abs(d - RESULT) < TOLERANCE;
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 * @param t
	 * @return f(t) = a*t+b*sin(c*t*PI)
	 */
	private static double f(final int a, final int b, final int c, final double t) {
		return a * t + b * Math.sin(c * t * Math.PI);
	}
}
