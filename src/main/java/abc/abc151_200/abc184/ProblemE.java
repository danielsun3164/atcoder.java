package abc.abc151_200.abc184;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {
	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** X座標の差分一覧 */
	private static final int[] XS = new int[] { 0, 0, -1, 1 };
	/** Y座標の差分一覧 */
	private static final int[] YS = new int[] { -1, 1, 0, 0 };
	/** 始点を表す文字 */
	private static final char SOURCE = 'S';
	/** 終点を表す文字 */
	private static final char GOAL = 'G';
	/** 壁を表す文字 */
	private static final char WALL = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] a = new char[h][];
			IntStream.range(0, h).forEach(i -> a[i] = scanner.next().toCharArray());
			Map<Character, List<Point>> map = new HashMap<>();
			Point s = null, g = null;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (SOURCE == a[i][j]) {
						s = new Point(i, j);
					} else if (GOAL == a[i][j]) {
						g = new Point(i, j);
					} else if (Character.isLowerCase(a[i][j])) {
						if (!map.containsKey(a[i][j])) {
							map.put(a[i][j], new ArrayList<>());
						}
						map.get(a[i][j]).add(new Point(i, j));
					}
				}
			}
			int[][] dp = new int[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(dp[i], INF));
			System.out.println(calc(dp, h, w, a, map, s, g));
		}
	}

	/**
	 *
	 *
	 * @param dp  計算結果を保存する配列
	 * @param h   高さ
	 * @param w   幅
	 * @param a   マスを表す配列
	 * @param map テレポートする座標一覧を保存するマップ
	 * @param s   起点
	 * @param g   終点
	 */
	private static int calc(int[][] dp, int h, int w, char[][] a, Map<Character, List<Point>> map, Point s, Point g) {
		Queue<Data> queue = new PriorityQueue<>((c, d) -> Integer.compare(c.v, d.v));
		dp[s.x][s.y] = 0;
		queue.add(new Data(s.x, s.y, 0));
		while (!queue.isEmpty()) {
			Data data = queue.poll();
			if (data.v == dp[data.x][data.y]) {
				for (int i = 0; i < XS.length; i++) {
					int nx = data.x + XS[i], ny = data.y + YS[i];
					if ((nx >= 0) && (ny >= 0) && (nx < h) && (ny < w) && (WALL != a[nx][ny])
							&& dp[nx][ny] > data.v + 1) {
						dp[nx][ny] = data.v + 1;
						queue.add(new Data(nx, ny, dp[nx][ny]));
						if ((nx == g.x) && (ny == g.y)) {
							return dp[nx][ny];
						}
					}
				}
				if (Character.isLowerCase(a[data.x][data.y])) {
					for (Point t : map.get(a[data.x][data.y])) {
						if (dp[t.x][t.y] > data.v + 1) {
							dp[t.x][t.y] = data.v + 1;
							queue.add(new Data(t.x, t.y, dp[t.x][t.y]));
						}
					}
					// https://atcoder.jp/contests/abc184/submissions/18300509 に参考に追加
					map.get(a[data.x][data.y]).clear();
				}
			}
		}
		return -1;
	}

	/**
	 * 座標を表すクラス
	 */
	private static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * 座標と計算結果を表すクラス
	 */
	private static class Data {
		int x, y, v;

		Data(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}
}
