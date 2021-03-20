package abc.abc101_150.abc144;

import java.util.Scanner;

/**
 * 解説通りに作成したソースコード
 *
 * 解説2の実装<br/>
 * https://atcoder.jp/contests/abc144/submissions/8133804 にも参考
 */
public class ProblemD別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), x = scanner.nextInt();
			System.out.println(f(a, b, x) / Math.PI * 180.0d);
		}
	}

	/**
	 * 底辺a、高さb、容量xのときの角度を計算する
	 *
	 * @param a 底辺
	 * @param b 高さ
	 * @param x 水の容量
	 * @return 角度
	 */
	private static double f(int a, int b, int x) {
		if (x * 2.0d > a * b * a) {
			return Math.atan(2.0d * (a * b * a - x) / a / a / a);
		} else {
			return Math.atan(b * b * a / 2.0d / x);
		}
	}
}
