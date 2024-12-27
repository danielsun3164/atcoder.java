package other.math_and_algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem046 {

	/** 壁を表す文字 */
	private static final char WALL = '#';
	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** Y座標の差分一覧 */
	private static final int[] YS = { 0, 0, -1, 1 };
	/** X座標の差分一覧 */
	private static final int[] XS = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt(), c = scanner.nextInt(), sy = scanner.nextInt() - 1, sx = scanner.nextInt() - 1,
					gy = scanner.nextInt() - 1, gx = scanner.nextInt() - 1;
			char[][] s = new char[r][];
			IntStream.range(0, r).forEach(i -> s[i] = scanner.next().toCharArray());
			int[][] d = new int[r][c];
			IntStream.range(0, r).forEach(i -> Arrays.fill(d[i], INF));
			d[sy][sx] = 0;
			Queue<Block> que = new ArrayDeque<>();
			que.add(new Block(sy, sx));
			while (!que.isEmpty()) {
				Block now = que.poll();
				IntStream.range(0, YS.length).forEach(i -> {
					int ny = now.y + YS[i], nx = now.x + XS[i];
					if ((WALL != s[ny][nx]) && (d[ny][nx] > d[now.y][now.x] + 1)) {
						d[ny][nx] = d[now.y][now.x] + 1;
						que.add(new Block(ny, nx));
					}
				});
			}
			System.out.println(d[gy][gx]);
		}
	}

	/**
	 * y,xを格納するクラス
	 */
	private static class Block {
		int y, x;

		Block(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
