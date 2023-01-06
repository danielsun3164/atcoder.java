package other.typical90;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/typical90/submissions/23648457 を参考に高速化処理を実施
 */
public class Problem043 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** X座標の差分の一覧 */
	private static final int[] XS = { 1, -1, 0, 0 };
	/** Y座標の差分の一覧 */
	private static final int[] YS = { 0, 0, 1, -1 };
	/** 壁を表す文字 */
	private static final char WALL = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int rs = scanner.nextInt() - 1, cs = scanner.nextInt() - 1, rt = scanner.nextInt() - 1,
					ct = scanner.nextInt() - 1;
			char[][] s = new char[h][];
			IntStream.range(0, h).forEach(i -> s[i] = scanner.next().toCharArray());
			int n = XS.length;
			int[][][] dp = new int[h][w][n];
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> Arrays.fill(dp[i][j], INF)));
			Arrays.fill(dp[rs][cs], 0);
			Deque<Node> que = new ArrayDeque<>();
			IntStream.range(0, n).forEach(i -> {
				int nx = rs + XS[i], ny = cs + YS[i];
				if ((nx >= 0) && (nx < h) && (ny >= 0) && (ny < w) && (WALL != s[nx][ny])) {
					if (dp[nx][ny][i] > dp[rs][cs][i]) {
						dp[nx][ny][i] = dp[rs][cs][i];
						que.add(new Node(nx, ny, i));
					}
				}
			});
			while (!que.isEmpty()) {
				Node now = que.poll();
				if ((rt == now.x) && (ct == now.y)) {
					System.out.println(Arrays.stream(dp[rt][ct]).min().getAsInt());
					return;
				}
				IntStream.range(0, n).forEach(i -> {
					int nx = now.x + XS[i], ny = now.y + YS[i];
					if ((nx >= 0) && (nx < h) && (ny >= 0) && (ny < w) && (WALL != s[nx][ny])) {
						int diff = (i == now.direction) ? 0 : 1;
						if (dp[nx][ny][i] > dp[now.x][now.y][now.direction] + diff) {
							dp[nx][ny][i] = dp[now.x][now.y][now.direction] + diff;
							if (0 == diff) {
								que.addFirst(new Node(nx, ny, i));
							} else {
								que.addLast(new Node(nx, ny, i));
							}
						}
					}
				});
			}
		}
	}

	/**
	 * X座標,Y座標,方向を格納するクラス
	 */
	private static class Node {
		int x, y, direction;

		Node(int x, int y, int direction) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}
}
