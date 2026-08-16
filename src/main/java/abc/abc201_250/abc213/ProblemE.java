package abc.abc201_250.abc213;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 普通の移動のx座標とy座標の差分 */
	private static final int[] X1S = { -1, 0, 0, 1 };
	private static final int[] Y1S = { 0, -1, 1, 0 };
	/** 破壊による移動のx座標とy座標の差分 */
	private static final int[] X2S = { -2, -2, -2, -1, -1, -1, -1, -1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2 };
	private static final int[] Y2S = { -1, 0, 1, -2, -1, 0, 1, 2, -2, -1, 1, 2, -2, -1, 0, 1, 2, -1, 0, 1 };
	/** 道路を表す文字 */
	private static final char ROAD = '.';
	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] s = new char[h][];
			IntStream.range(0, h).forEach(i -> s[i] = scanner.next().toCharArray());
			int[][] dp = new int[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(dp[i], INF));
			dp[0][0] = 0;
			Queue<Masu> que = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
			que.add(new Masu(0, 0, 0));
			while (!que.isEmpty()) {
				Masu now = que.poll();
				if (dp[now.x][now.y] == now.cost) {
					IntStream.range(0, X1S.length).forEach(k -> {
						int nx = now.x + X1S[k], ny = now.y + Y1S[k];
						if ((nx >= 0) && (nx < h) && (ny >= 0) && (ny < w) && (ROAD == s[nx][ny])) {
							if (dp[nx][ny] > dp[now.x][now.y]) {
								dp[nx][ny] = dp[now.x][now.y];
								que.add(new Masu(nx, ny, dp[nx][ny]));
							}
						}
					});
					IntStream.range(0, X2S.length).forEach(k -> {
						int nx = now.x + X2S[k], ny = now.y + Y2S[k];
						if ((nx >= 0) && (nx < h) && (ny >= 0) && (ny < w)) {
							if (dp[nx][ny] > dp[now.x][now.y] + 1) {
								dp[nx][ny] = dp[now.x][now.y] + 1;
								que.add(new Masu(nx, ny, dp[nx][ny]));
							}
						}
					});
				}
			}
			System.out.println(dp[h - 1][w - 1]);
		}
	}

	/**
	 * マスを表すクラス
	 */
	private static class Masu {
		/** X座標 */
		int x;
		/** Y座標 */
		int y;
		/** たどり着くための破壊数 */
		int cost;

		Masu(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
