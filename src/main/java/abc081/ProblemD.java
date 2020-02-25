package abc081;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			if (isIncreasing(a)) {
				System.out.println(0);
				return;
			}
			int maxValue = 0, maxIndex = 0;
			int minValue = Integer.MAX_VALUE, minIndex = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] > maxValue) {
					maxValue = a[i];
					maxIndex = i + 1;
				}
				if (a[i] < minValue) {
					minValue = a[i];
					minIndex = i + 1;
				}
			}
			if ((maxValue <= 0) || (minValue >= 0)) {
				System.out.println(n - 1);
				// すべてが負の数か正の数の場合
				printSteps(n, (maxValue <= 0));
			} else {
				int fromIndex = (Math.abs(maxValue) > Math.abs(minValue)) ? maxIndex : minIndex;
				System.out.println(2 * n - 1);
				printAddSteps(n, fromIndex);
				printSteps(n, (fromIndex == minIndex));
			}
		}
	}

	/**
	 * @param a 入力配列
	 * @return 入力配列は単調増加かどうか
	 */
	static boolean isIncreasing(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 長さnの数列の計算ステップを出力する
	 * 
	 * @param n       数列の長さ
	 * @param reverse 逆順かどうか
	 */
	private static void printSteps(int n, boolean reverse) {
		if (reverse) {
			IntStream.range(1, n).map(i -> n - i).forEach(i -> System.out.println((i + 1) + " " + i));
		} else {
			IntStream.range(1, n).forEach(i -> System.out.println(i + " " + (i + 1)));
		}
	}

	/**
	 * 数列のすべてにindexの数字を足す計算ステップを出力する
	 * 
	 * @param n     数列の長さ
	 * @param index 加算もととなるindex
	 */
	private static void printAddSteps(int n, int index) {
		IntStream.rangeClosed(1, n).forEach(i -> System.out.println(index + " " + i));
	}
}
