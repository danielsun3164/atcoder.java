package abc.abc151_200.abc167;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 大きい値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), x = scanner.nextInt();
			int[][] a = new int[n][m];
			int[] c = new int[n];
			IntStream.range(0, n).forEach(i -> {
				c[i] = scanner.nextInt();
				IntStream.range(0, m).forEach(j -> a[i][j] = scanner.nextInt());
			});
			int[] current = new int[m];
			Arrays.fill(current, 0);
			int result = getResult(n, m, x, c, a, current, 0);
			System.out.println((result >= INF) ? -1 : result);
		}
	}

	/**
	 * 目標を達成するのに必要な金額の最小値を計算する
	 * 
	 * @param n
	 * @param m
	 * @param x
	 * @param c
	 * @param a
	 * @param current 現在の状態の配列
	 * @param index   現在処理している参考書のインデックス
	 * @return 目標を達成するのに必要な金額の最小値
	 */
	private static int getResult(final int n, final int m, final int x, final int[] c, final int[][] a,
			final int[] current, final int index) {
		boolean ok = true;
		for (int i = 0; i < m; i++) {
			if (current[i] < x) {
				ok = false;
				break;
			}
		}
		if (ok) {
			return 0;
		}
		if (index >= n) {
			return INF;
		}
		return Math.min(getResult(n, m, x, c, a, current, index + 1),
				getResult(n, m, x, c, a, add(current, a[index]), index + 1) + c[index]);
	}

	/**
	 * 配列aと配列bの和の配列を計算する
	 * 
	 * @param a 配列a
	 * @param b 配列b
	 * @return 配列aと配列bの和の配列
	 */
	private static int[] add(final int[] a, final int[] b) {
		int[] result = new int[a.length];
		IntStream.range(0, a.length).forEach(i -> result[i] = a[i] + b[i]);
		return result;
	}
}
