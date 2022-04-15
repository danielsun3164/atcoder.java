package other.atc002;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** X座標の差分一覧 */
	private static final int[] XS = { 1, -1, 0, 0 };
	/** Y座標の差分一覧 */
	private static final int[] YS = { 0, 0, 1, -1 };
	/** ブロックを表す文字 */
	private static final char BLOCK = '#';
	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt(), c = scanner.nextInt();
			// xとyの表記は問題の表記と逆
			int sx = scanner.nextInt() - 1, sy = scanner.nextInt() - 1;
			int gx = scanner.nextInt() - 1, gy = scanner.nextInt() - 1;
			char[][] s = new char[r][];
			IntStream.range(0, r).forEach(i -> s[i] = scanner.next().toCharArray());
			int[][] dp = new int[r][c];
			IntStream.range(0, r).forEach(i -> Arrays.fill(dp[i], INF));
			Queue<Node> que = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
			dp[sx][sy] = 0;
			que.add(new Node(sx, sy, 0));
			while (!que.isEmpty()) {
				Node now = que.poll();
				if ((gx == now.x) && (gy == now.y)) {
					break;
				}
				for (int i = 0; i < XS.length; i++) {
					int nx = now.x + XS[i], ny = now.y + YS[i];
					if ((nx >= 0) && (nx < r) && (ny >= 0) && (ny < c) && (BLOCK != s[nx][ny])) {
						if (dp[nx][ny] > now.cost + 1) {
							dp[nx][ny] = now.cost + 1;
							que.add(new Node(nx, ny, now.cost + 1));
						}
					}
				}
			}
			System.out.println(dp[gx][gy]);
		}
	}

	/**
	 * ノードを表すクラス
	 */
	private static final class Node {
		int x, y, cost;

		Node(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
