package abc.abc201_250.abc247;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc247/editorial/3736 の解法2包除原理の実装
 */
public class ProblemE別回答1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			boolean[] ns = new boolean[n], xs = new boolean[n], ys = new boolean[n], xys = new boolean[n];
			Arrays.fill(ns, false);
			Arrays.fill(xs, false);
			Arrays.fill(ys, false);
			Arrays.fill(xys, false);
			IntStream.range(0, n).forEach(i -> {
				if (!((y <= a[i]) && (a[i] <= x))) {
					ns[i] = xs[i] = ys[i] = xys[i] = true;
				}
				if (x == a[i]) {
					xs[i] = xys[i] = true;
				}
				if (y == a[i]) {
					ys[i] = xys[i] = true;
				}
			});
			System.out.println(f(ns) - f(xs) - f(ys) + f(xys));
		}
	}

	/**
	 * 〇〇を含まない列の数を計算する
	 *
	 * @param a
	 * @return 〇〇を含まない列の数
	 */
	private static long f(boolean[] a) {
		long result = 0, s = 0;
		for (boolean x : a) {
			if (x) {
				result += s * (s + 1) / 2;
				s = 0;
			} else {
				s++;
			}
		}
		result += s * (s + 1) / 2;
		return result;
	}
}
