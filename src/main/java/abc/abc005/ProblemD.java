package abc.abc005;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] d = new int[n][n];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> d[i][j] = scanner.nextInt()));
			int q = scanner.nextInt();
			int[] p = new int[q];
			IntStream.range(0, q).forEach(i -> p[i] = scanner.nextInt());
			int[] r = getResult(d);
			Arrays.stream(p).map(i -> r[i]).forEach(System.out::println);
		}
	}

	/**
	 * @param d たこ焼き器の美味しさの配列
	 * @return たこ焼き器最大美味しさの結果配列
	 */
	private static int[] getResult(int[][] d) {
		int n = d.length;
		int[] r = new int[n * n + 1];
		int max = r[0] = 0;
		int[][] s = calcSum(d);
		for (int i = 1; i <= n * n; i++) {
			max = Math.max(max, getResult(i, n, s));
			r[i] = max;
		}
		return r;
	}

	/**
	 * @param d たこ焼き器の美味しさの配列
	 * @return たこ焼き器の美味しさ合計値配列．[i][j]の項目は[i][j]から一番右下の場所までの長方形のエリアの美味しさの合計値
	 */
	private static int[][] calcSum(int[][] d) {
		int n = d.length;
		int[][] s = new int[n + 1][n + 1];
		IntStream.rangeClosed(0, n).forEach(i -> s[i][n] = s[n][i] = 0);
		for (int i = n - 1; i >= 0; i--) {
			// 毎行最後の項目の合計値を計算
			s[i][n - 1] = s[i + 1][n - 1] + d[i][n - 1];
			for (int j = n - 1; j >= 0; j--) {
				s[i][j] = s[i + 1][j] + s[i][j + 1] + d[i][j] - s[i + 1][j + 1];
			}
		}
		return s;
	}

	/**
	 * @param max たこ焼きを焼く最大数
	 * @param n   たこ焼き器の辺長
	 * @param s   たこ焼き器の美味しさ合計値配列
	 * @return たこ焼き器最大美味しさ
	 */
	private static int getResult(int max, int n, int[][] s) {
		int result = IntStream.rangeClosed((max - 1) / n + 1, Math.min(max, n)).filter(i -> (0 == max % i))
				.map(i -> getResult(i, max / i, n, s)).max().orElse(0);
		return result;
	}

	/**
	 * @param w 横の個数
	 * @param h 縦の個数
	 * @param n たこ焼き器の辺長
	 * @param s たこ焼き器の美味しさ合計値配列
	 * @return たこ焼き器最大美味しさ
	 */
	private static int getResult(int w, int h, int n, int[][] s) {
		int result = IntStream.range(0, n - w + 1)
				.map(i -> IntStream.range(0, n - h + 1).map(j -> sum(i, j, w, h, s)).max().getAsInt()).max().getAsInt();
		return result;
	}

	/**
	 * @param x たこ焼き器の横index
	 * @param y たこ焼き器の縦index
	 * @param w 横の個数
	 * @param h 縦の個数
	 * @param s たこ焼き器の美味しさ合計値配列
	 * @return たこ焼き器の指定された場所の合計美味しさ
	 */
	private static int sum(int x, int y, int w, int h, int[][] s) {
		return s[x][y] - s[x + w][y] - s[x][y + h] + s[x + w][y + h];
	}
}
