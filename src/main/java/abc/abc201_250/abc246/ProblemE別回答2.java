package abc.abc201_250.abc246;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://blog.hamayanhamayan.com/entry/2022/04/03/015208 の実装
 */
public class ProblemE別回答2 {

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
			int[][][] dp = new int[n][n][XS.length];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> Arrays.fill(dp[i][j], INF)));
			Arrays.fill(dp[ax][ay], 0);
			Queue<Path> que = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
			IntStream.range(0, XS.length).forEach(i -> {
				int nx = ax + XS[i], ny = ay + YS[i];
				if ((nx >= 0) && (nx < n) && (ny >= 0) && (ny < n) && (BLANK == s[nx][ny])) {
					dp[nx][ny][i] = 1;
					que.add(new Path(nx, ny, 1, i));
				}
			});
			while (!que.isEmpty()) {
				Path now = que.poll();
				if ((now.toX == bx) && (now.toY == by)) {
					System.out.println(now.cost);
					return;
				}
				if (dp[now.toX][now.toY][now.direction] == now.cost) {
					for (int i = 0; i < XS.length; i++) {
						int nx = now.toX + XS[i], ny = now.toY + YS[i];
						int cost = (i == now.direction) ? 0 : 1;
						if ((nx >= 0) && (nx < n) && (ny >= 0) && (ny < n) && (s[nx][ny] == BLANK)
								&& (dp[nx][ny][i] > now.cost + cost)) {
							dp[nx][ny][i] = now.cost + cost;
							que.add(new Path(nx, ny, dp[nx][ny][i], i));
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
		int toX, toY, cost, direction;

		Path(int toX, int toY, int cost, int direction) {
			this.toX = toX;
			this.toY = toY;
			this.cost = cost;
			this.direction = direction;
		}
	}
}
