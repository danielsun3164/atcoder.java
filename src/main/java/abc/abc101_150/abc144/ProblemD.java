package abc.abc101_150.abc144;

import java.util.Scanner;

/**
 * 解説通りに作成したソースコード
 *
 * 解説1の実装<br/>
 * https://atcoder.jp/contests/abc144/submissions/8133803 にも参考
 */
public class ProblemD {

	/** 誤差（求められる誤差より細かい必要あり） */
	private static final double TOLERANCE = 10E-7d;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), x = scanner.nextInt();
			double left = 0.0d, right = 90.0d;
			while (right - left >= TOLERANCE) {
				double med = (left + right) / 2.0d;
				double f = f(a, b, med);
				if (f > x) {
					right = med;
				} else {
					left = med;
				}
			}
			System.out.println(90.0d - left);
		}
	}

	/**
	 * 底辺a、高さb、角度thetaのときの水の容量
	 *
	 * @param a     底辺
	 * @param b     高さ
	 * @param theta 角度
	 * @return 水の容量
	 */
	private static double f(int a, int b, double theta) {
		double tan = Math.tan(Math.PI * theta / 180.d);
		return (b * tan > a) ? a * (b - a / tan / 2.0d) * a : b * b * tan / 2.0 * a;
	}
}
