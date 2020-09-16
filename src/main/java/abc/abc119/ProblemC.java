package abc.abc119;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemC {

	/** 大きい値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			int[] l = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(dfs(0, 0, 0, 0, n, a, b, c, l));
		}
	}

	/**
	 * 目的を達成するための最小の必要なMP
	 * 
	 * @param current 現在何番目の竹を処理しているか
	 * @param d       長さaを作るための竹の現在の長さ
	 * @param e       長さbを作るための竹の現在の長さ
	 * @param f       長さcを作るための竹の現在の長さ
	 * @param n       竹の数
	 * @param a
	 * @param b
	 * @param c
	 * @param l       竹の長さの配列
	 * @return 目的を達成するための最小の必要なMP
	 */
	private static int dfs(int current, int d, int e, int f, final int n, final int a, final int b, final int c,
			final int[] l) {
		if (current == n) {
			if (min(d, e, f) > 0) {
				return Math.abs(d - a) + Math.abs(e - b) + Math.abs(f - c) - 30;
			} else {
				return INF;
			}
		}
		// 現在の竹を処理しない
		int ret0 = dfs(current + 1, d, e, f, n, a, b, c, l);
		// 現在の竹をdに接続する
		int ret1 = dfs(current + 1, d + l[current], e, f, n, a, b, c, l) + 10;
		// 現在の竹をeに接続する
		int ret2 = dfs(current + 1, d, e + l[current], f, n, a, b, c, l) + 10;
		// 現在の竹をfに接続する
		int ret3 = dfs(current + 1, d, e, f + l[current], n, a, b, c, l) + 10;
		return min(ret0, ret1, ret2, ret3);
	}

	/**
	 * @param x 配列
	 * @return 配列の最小値
	 */
	private static int min(int... x) {
		return Arrays.stream(x).min().getAsInt();
	}
}
