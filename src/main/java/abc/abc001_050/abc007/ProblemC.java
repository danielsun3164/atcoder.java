package abc.abc001_050.abc007;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 空きマスを表す文字 */
	private static final char EMPTY = '.';
	/** 移動の際のX座標の差分の配列 */
	private static final int[] XS = new int[] { -1, 1, 0, 0 };
	/** 移動の際のY座標の差分の配列 */
	private static final int[] YS = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int R = scanner.nextInt(), C = scanner.nextInt();
			int sx = scanner.nextInt() - 1, sy = scanner.nextInt() - 1;
			int gx = scanner.nextInt() - 1, gy = scanner.nextInt() - 1;
			boolean[][] c = new boolean[R][C];
			IntStream.range(0, R).forEach(i -> {
				char[] s = scanner.next().toCharArray();
				IntStream.range(0, C).forEach(j -> c[i][j] = EMPTY == s[j]);
			});
			int[][] r = new int[R][C];
			IntStream.range(0, R).forEach(i -> IntStream.range(0, C).forEach(j -> r[i][j] = Integer.MAX_VALUE));
			r[sx][sy] = 0;
			calcResult(R, C, r, c, sx, sy);
			System.out.println(r[gx][gy]);
		}
	}

	/**
	 * 計算結果の配列を記入
	 *
	 * @param R  迷路の行数
	 * @param C  迷路の列数
	 * @param r  計算結果の配列
	 * @param c  迷路のマスデータの配列
	 * @param sx マスのX座標
	 * @param sy マスのY座標
	 */
	private static void calcResult(final int R, final int C, final int[][] r, final boolean[][] c, int sx, int sy) {
		Queue<Data> queue = new PriorityQueue<>();
		queue.add(new Data(sx, sy, r[sx][sy]));
		while (!queue.isEmpty()) {
			Data data = queue.poll();
			int x = data.x, y = data.y;
			if (data.r == r[x][y]) {
				IntStream.range(0, XS.length).forEach(i -> {
					int nx = x + XS[i], ny = y + YS[i];
					if ((nx >= 0) && (nx < R) && (ny >= 0) && (ny < C) && (c[nx][ny]) && (r[nx][ny] > r[x][y] + 1)) {
						r[nx][ny] = r[x][y] + 1;
						queue.add(new Data(nx, ny, r[nx][ny]));
					}
				});
			}
		}
	}

	/**
	 * x,yとrを表すクラス
	 */
	private static class Data implements Comparable<Data> {
		int x, y, r;

		Data(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

		@Override
		public int compareTo(Data data) {
			return Integer.compare(r, data.r);
		}
	}
}
