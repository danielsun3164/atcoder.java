package abc.abc201_250.abc207;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 誤差 */
	private static final double EPS = 1E-6d;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n], b = new int[n], c = new int[n], d = new int[n];
			input(scanner, n, a, b);
			input(scanner, n, c, d);
			// a[0]とb[0]がともに0にならないようにする
			IntStream.range(0, n).forEach(i -> {
				if ((0 != a[i]) || (0 != b[i])) {
					swap(a, 0, i);
					swap(b, 0, i);
				}
			});
			for (int i = 0; i < n; i++) {
				double angle = Math.atan2(d[i], c[i]) - Math.atan2(b[0], a[0]);
				boolean flag = true;
				for (int j = 0; j < n; j++) {
					double newA = (a[j] * Math.cos(angle)) - (b[j] * Math.sin(angle)),
							newB = (a[j] * Math.sin(angle)) + (b[j] * Math.cos(angle));
					boolean flag2 = false;
					for (int k = 0; k < n; k++) {
						if ((Math.abs(newA - c[k]) <= EPS) && (Math.abs(newB - d[k]) <= EPS)) {
							flag2 = true;
							break;
						}
					}
					flag &= flag2;
				}
				if (flag) {
					System.out.println("Yes");
					return;
				}
			}
			System.out.println("No");
		}
	}

	/**
	 * 配列xとyを入力する
	 *
	 * @param scanner
	 * @param n       配列の長さ
	 * @param x
	 * @param y
	 */
	private static void input(Scanner scanner, int n, int[] x, int[] y) {
		IntStream.range(0, n).forEach(i -> {
			x[i] = scanner.nextInt();
			y[i] = scanner.nextInt();
		});
		int xSum = Arrays.stream(x).sum(), ySum = Arrays.stream(y).sum();
		IntStream.range(0, n).forEach(i -> {
			x[i] = (x[i] * n) - xSum;
			y[i] = (y[i] * n) - ySum;
		});
	}

	/**
	 * 配列aのi番目とj番目の要素を交換する
	 *
	 * @param a 配列
	 * @param i
	 * @param j
	 */
	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
