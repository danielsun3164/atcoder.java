package abc.abc151_200.abc176;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 道を表す文字 */
	private static final char ROAD = '.';

	/** 移動のX座標差分配列 */
	private static final int[] MOVE_XS = new int[] { 1, -1, 0, 0 };
	/** 移動のY座標差分配列 */
	private static final int[] MOVE_YS = new int[] { 0, 0, 1, -1 };
	/** ワープのX座標差分配列 */
	private static final int[] WARP_XS = new int[] { 1, 1, 1, 1, -1, -1, -1, -1, 2, 2, 2, 2, 2, -2, -2, -2, -2, -2, 0,
			0 };
	/** ワープのY座標差分配列 */
	private static final int[] WARP_YS = new int[] { 1, -1, 2, -2, 1, -1, 2, -2, 0, 1, -1, 2, -2, 0, 1, -1, 2, -2, 2,
			-2 };

	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int ch = scanner.nextInt() - 1, cw = scanner.nextInt() - 1;
			int dh = scanner.nextInt() - 1, dw = scanner.nextInt() - 1;
			boolean[][] road = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> {
				char[] s = scanner.next().toCharArray();
				IntStream.range(0, w).forEach(j -> road[i][j] = (ROAD == s[j]));
			});
			int[][] dp = new int[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(dp[i], INF));
			setDp(dp, h, w, ch, cw, road);
			System.out.println((INF == dp[dh][dw]) ? -1 : dp[dh][dw]);
		}
	}

	/**
	 * 個々のマスに移動するための最小コストの配列の値をセットする
	 *
	 * @param dp   個々のマスに移動するための最小コストの配列
	 * @param h    縦幅
	 * @param w    横幅
	 * @param ch   開始時点
	 * @param cw   開始時点
	 * @param road 道路を表す配列
	 */
	private static void setDp(int[][] dp, int h, int w, int ch, int cw, boolean[][] road) {

		dp[ch][cw] = 0;
		Queue<Masu> queue = new PriorityQueue<>();
		queue.add(new Masu(ch, cw, 0));
		while (!queue.isEmpty()) {
			Masu masu = queue.poll();
			int nx = masu.x, ny = masu.y;
			if (masu.cost == dp[nx][ny]) {
				// 移動
				for (int i = 0; i < MOVE_XS.length; i++) {
					int newX = nx + MOVE_XS[i], newY = ny + MOVE_YS[i];
					if ((newX >= 0) && (newX < h) && (newY >= 0) && (newY < w) && road[newX][newY]) {
						if (dp[newX][newY] > dp[nx][ny]) {
							dp[newX][newY] = dp[nx][ny];
							queue.add(new Masu(newX, newY, dp[newX][newY]));
						}
					}
				}
				// ワープ
				for (int i = 0; i < WARP_XS.length; i++) {
					int newX = nx + WARP_XS[i], newY = ny + WARP_YS[i];
					if ((newX >= 0) && (newX < h) && (newY >= 0) && (newY < w) && road[newX][newY]) {
						if (dp[newX][newY] > dp[nx][ny] + 1) {
							dp[newX][newY] = dp[nx][ny] + 1;
							queue.add(new Masu(newX, newY, dp[newX][newY]));
						}
					}
				}
			}
		}
	}

	/**
	 * マスを表すクラス
	 */
	private static class Masu implements Comparable<Masu> {
		/** X座標 */
		int x;
		/** Y座標 */
		int y;
		/** ワープ数 */
		int cost;

		/**
		 * コンストラクタ
		 *
		 * @param x
		 * @param y
		 * @param cost
		 */
		Masu(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Masu masu) {
			return Integer.compare(cost, masu.cost);
		}
	}
}
