package abc.abc151_200.abc165;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			int[] a = new int[q], b = new int[q], c = new int[q], d = new int[q];
			IntStream.range(0, q).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
				c[i] = scanner.nextInt();
				d[i] = scanner.nextInt();
			});
			System.out.println(calcMax(n, m, q, a, b, c, d));
		}
	}

	/**
	 * 得点の最大値を計算する
	 * 
	 * @param n 数列の数字の数
	 * @param m 数列の数字の最大値
	 * @param q 条件の組み数
	 * @param a 条件aの配列
	 * @param b 条件bの配列
	 * @param c 条件cの配列
	 * @param d 条件dの配列
	 * @return 得点の最大値
	 */
	private static int calcMax(final int n, final int m, final int q, final int[] a, final int[] b, final int[] c,
			final int[] d) {
		int[] array = new int[n];
		Arrays.fill(array, 1);
		int result = 0;
		while (array[0] <= m) {
			result = Math.max(result, calc(array, q, a, b, c, d));
			increase(array, n, m, n - 1);
		}
		return result;
	}

	/**
	 * 配列の得点を計算する
	 * 
	 * @param array 配列
	 * @param q     条件の組み数
	 * @param a     条件aの配列
	 * @param b     条件bの配列
	 * @param c     条件cの配列
	 * @param d     条件dの配列
	 * @return 配列の得点
	 */
	private static int calc(final int[] array, final int q, final int[] a, final int[] b, final int[] c,
			final int[] d) {
		return IntStream.range(0, q).filter(i -> array[b[i]] - array[a[i]] == c[i]).map(i -> d[i]).sum();
	}

	/**
	 * 配列のindex番を一つ上がる
	 * 
	 * @param array 配列
	 * @param n     数列の数字の数
	 * @param m     数列の数字の最大値
	 * @param index 上がるインデックス
	 */
	private static void increase(int[] array, final int n, final int m, final int index) {
		array[index]++;
		if ((array[index] > m) && (index > 0)) {
			increase(array, n, m, index - 1);
			array[index] = array[index - 1];
		}
	}
}
