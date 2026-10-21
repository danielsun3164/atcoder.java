package abc.abc201_250.abc246;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc246/editorial/3702 の実装
 */
public class ProblemE {

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
			int[][][] d = new int[n][n][XS.length];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> Arrays.fill(d[i][j], INF)));
			boolean[][][] fl = new boolean[n][n][XS.length];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> Arrays.fill(fl[i][j], false)));
			Arrays.fill(d[ax][ay], 0);
			Deque<Path> que = new ArrayDeque<>();
			IntStream.range(0, XS.length).forEach(i -> {
				int nx = ax + XS[i], ny = ay + YS[i];
				if ((nx >= 0) && (nx < n) && (ny >= 0) && (ny < n) && (BLANK == s[nx][ny])) {
					d[nx][ny][i] = 1;
					que.addLast(new Path(nx, ny, i));
				}
			});
			while (!que.isEmpty()) {
				Path now = que.poll();
				if ((now.x == bx) && (now.y == by)) {
					System.out.println(d[now.x][now.y][now.direction]);
					return;
				}
				if (!fl[now.x][now.y][now.direction]) {
					fl[now.x][now.y][now.direction] = true;
					for (int i = 0; i < XS.length; i++) {
						int nx = now.x + XS[i], ny = now.y + YS[i];
						int cost = (i == now.direction) ? 0 : 1;
						if ((nx >= 0) && (nx < n) && (ny >= 0) && (ny < n) && (s[nx][ny] == BLANK)
								&& (d[nx][ny][i] > d[now.x][now.y][now.direction] + cost)) {
							d[nx][ny][i] = d[now.x][now.y][now.direction] + cost;
							if (i == now.direction) {
								que.addFirst(new Path(nx, ny, i));
							} else {
								que.addLast(new Path(nx, ny, i));
							}
						}
					}
				}
			}
			System.out.println(-1);
		}
	}

	/**
	 * 遷移するパスを表すクラス
	 */
	private static class Path {
		int x, y, direction;

		Path(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}
}
