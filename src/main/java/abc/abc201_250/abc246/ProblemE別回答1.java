package abc.abc201_250.abc246;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc246/editorial/3728 の実装
 */
public class ProblemE別回答1 {

	/** 遷移するX座標の差分 */
	private static final int[] XS = { 1, 1, -1, -1 };
	/** 遷移するY座標の差分 */
	private static final int[] YS = { 1, -1, 1, -1 };
	/** 何も置いていないマスを表す文字 */
	private static final char BLANK = '.';
	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int ax = scanner.nextInt() - 1, ay = scanner.nextInt() - 1;
			int bx = scanner.nextInt() - 1, by = scanner.nextInt() - 1;
			char[][] s = new char[n][];
			IntStream.range(0, n).forEach(i -> s[i] = scanner.next().toCharArray());
			int[][] d = new int[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(d[i], INF));
			d[ax][ay] = 0;
			Deque<Path> que = new ArrayDeque<>();
			que.add(new Path(ax, ay));
			while (!que.isEmpty()) {
				Path now = que.poll();
				for (int i = 0; i < XS.length; i++) {
					int nx = now.x, ny = now.y;
					while (true) {
						nx += XS[i];
						ny += YS[i];
						if (!((nx >= 0) && (nx < n) && (ny >= 0) && (ny < n) && (s[nx][ny] == BLANK))) {
							break;
						}
						if (d[nx][ny] > d[now.x][now.y] + 1) {
							d[nx][ny] = d[now.x][now.y] + 1;
							que.add(new Path(nx, ny));
						}
						if (d[nx][ny] <= d[now.x][now.y]) {
							break;
						}
					}
				}
			}
			System.out.println((INF == d[bx][by]) ? -1 : d[bx][by]);
		}
	}

	/**
	 * 遷移するマスを表すクラス
	 */
	private static class Path {
		int x, y;

		Path(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
