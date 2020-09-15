package abc.abc069;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[][] result = new int[h][w];
			int color = 1, currentX = 0, currentY = 0;
			for (int ai : a) {
				while (currentY + ai >= w) {
					// 改行が発生する
					fill(result, currentX, currentY, w, color);
					currentX++;
					ai -= (w - currentY);
					currentY = 0;
				}
				fill(result, currentX, currentY, currentY + ai, color);
				currentY += ai;
				color++;
			}
			IntStream.range(0, h).forEach(i -> println(result[i], i));
		}
	}

	/**
	 * 結果配列にx座標のy座標開始〜y座標終了-1までに色を塗る
	 * 
	 * @param result 結果配列
	 * @param x      x座標
	 * @param yStart y座標開始
	 * @param yEnd   y座標終了
	 * @param color  色
	 */
	private static void fill(int[][] result, int x, int yStart, int yEnd, int color) {
		for (int i = yStart; i < yEnd; i++) {
			result[x][i] = color;
		}
	}

	/**
	 * 数列を出力する
	 * 
	 * @param a      出力する数列
	 * @param lineNo 行数
	 */
	private static void println(int[] a, int lineNo) {
		if (0 == (lineNo & 1)) {
			// lineNoが偶数の場合，左から右へ出力する
			System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		} else {
			// 右から左へ出力する
			System.out.println(IntStream.range(0, a.length).mapToObj(i -> String.valueOf(a[a.length - 1 - i]))
					.collect(Collectors.joining(" ")));
		}
	}
}
