package abc.abc201_250.abc243;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc243/editorial/3576 の実装<br/>
 * https://atcoder.jp/contests/abc243/submissions/30077746 にも参考
 */
public class ProblemEx別回答 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** 壁が使用できる文字 */
	private static final char EMPTY = '.';
	/** X座標の差分 */
	private static final int[] DX = { 1, 1, 0, -1, -1, -1, 0, 1 };
	/** Y座標の差分 */
	private static final int[] DY = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] c = new char[h][];
			for (int i = 0; i < h; i++) {
				c[i] = scanner.next().toCharArray();
			}
			Data start = get(c, 'S'), goal = get(c, 'G');
			int sx = start.first, sy = start.second, gx = goal.first, gy = goal.second;
			DisjointSetUnion dsu = new DisjointSetUnion(h * w);
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if ((i > 0) && (EMPTY != c[i][j]) && (EMPTY != c[i - 1][j])) {
						dsu.merge((i - 1) * w + j, i * w + j);
					}
					if ((j > 0) && (EMPTY != c[i][j]) && (EMPTY != c[i][j - 1])) {
						dsu.merge(i * w + j - 1, i * w + j);
					}
				}
			}
			if ((dsu.leader(sx * w + sy) == dsu.leader(gx * w + gy)) || (Math.abs(sx - gx) + Math.abs(sy - gy) <= 1)) {
				System.out.println("No");
				return;
			}
			if (2 == Math.min(h, w)) {
				if (h != 2) {
					char[][] c2 = c;
					c = new char[w][h];
					for (int i = 0; i < h; i++) {
						for (int j = 0; j < w; j++) {
							c[j][i] = c2[i][j];
						}
					}
					int tmp = w;
					w = h;
					h = tmp;
					tmp = sx;
					sx = sy;
					sy = tmp;
					tmp = gx;
					gx = gy;
					gy = tmp;
				}
				if (sy > gy) {
					int tmp = sx;
					sx = gx;
					gx = tmp;
					tmp = sy;
					sy = gy;
					gy = tmp;
				}
				int n = 0;
				for (int y = 0; y < w; y++) {
					// たて
					if ((sy < y) && (y < gy) && (EMPTY == c[0][y]) && (EMPTY == c[1][y])) {
						n++;
					}
					// ななめ
					if (y < w - 1) {
						if ((sy <= y) && (gy >= y + 1) && (EMPTY == c[0][y]) && (EMPTY == c[1][y + 1])) {
							n++;
						}
						if ((sy <= y) && (gy >= y + 1) && (EMPTY == c[1][y]) && (EMPTY == c[0][y + 1])) {
							n++;
						}
					}
				}
				if (0 == n) {
					System.out.println("No");
					return;
				} else {
					System.out.println("Yes");
					System.out.println(2 + " " + n);
					return;
				}
			}
			int[][][][] dist = new int[2][2][h + 1][w + 1];
			long[][][][] dp = new long[2][2][h + 1][w + 1];
			int cost = INF;
			long answer = 0L;
			for (int x0 = h - 1; x0 >= 0; x0--) {
				for (int y0 = 0; y0 < w; y0++) {
					if (EMPTY != c[x0][y0]) {
						continue;
					}
					init(h, dist, dp);
					Queue<int[]> que = new ArrayDeque<>();
					que.add(new int[] { 0, 0, x0, y0 });
					dist[0][0][x0][y0] = 0;
					dp[0][0][x0][y0] = 1;
					while (!que.isEmpty()) {
						int[] now = que.poll();
						int s = now[0], t = now[1], x = now[2], y = now[3];
						if (dist[s][t][x][y] >= cost + 1) {
							que.clear();
							break;
						}
						for (int i = 0; i < 8; i++) {
							int nx = x + DX[i], ny = y + DY[i];
							if ((x0 < nx || (x0 == nx && y0 <= ny)) && (nx >= 0) && (nx < h) && (ny >= 0) && (ny < w)
									&& (EMPTY == c[nx][ny])) {
								int ns = s ^ add(x, y, nx, ny, sx, sy), nt = t ^ add(x, y, nx, ny, gx, gy);
								if (dist[ns][nt][nx][ny] >= dist[s][t][x][y] + 1) {
									if (INF == dist[ns][nt][nx][ny]) {
										que.add(new int[] { ns, nt, nx, ny });
									}
									dist[ns][nt][nx][ny] = dist[s][t][x][y] + 1;
									dp[ns][nt][nx][ny] = (dp[ns][nt][nx][ny] + dp[s][t][x][y]) % MOD;
								}
							}
						}
					}
					for (int s = 0; s < 2; s++) {
						for (int t = 0; t < 2; t++) {
							if ((s != t) && (dist[s][t][x0][y0] < INF)) {
								if (cost > dist[s][t][x0][y0]) {
									cost = dist[s][t][x0][y0];
									answer = dp[s][t][x0][y0] * powMod(2, MOD - 2) % MOD;
								} else if (cost == dist[s][t][x0][y0]) {
									answer = (answer + dp[s][t][x0][y0] * powMod(2, MOD - 2)) % MOD;
								}
							}
						}
					}
				}
			}
			for (int x0 = h - 1; x0 >= 0; x0--) {
				for (int y0 = 0; y0 < w; y0++) {
					if (((x0 > 0) && (x0 < h - 1) && (y0 > 0) && (y0 < w - 1)) || (EMPTY != c[x0][y0])) {
						continue;
					}
					init(h, dist, dp);
					Queue<int[]> que = new ArrayDeque<>();
					que.add(new int[] { 0, 0, x0, y0 });
					dist[0][0][x0][y0] = 0;
					dp[0][0][x0][y0] = 1;
					while (!que.isEmpty()) {
						int[] now = que.poll();
						int s = now[0], t = now[1], x = now[2], y = now[3];
						if (dist[s][t][x][y] >= cost + 1) {
							que.clear();
							break;
						}
						for (int i = 0; i < 8; i++) {
							int nx = x + DX[i], ny = y + DY[i];
							if ((nx >= 0) && (nx < h) && (ny >= 0) && (ny < w) && (EMPTY == c[nx][ny])) {
								int ns = s ^ add(x, y, nx, ny, sx, sy), nt = t ^ add(x, y, nx, ny, gx, gy);
								if (dist[ns][nt][nx][ny] >= dist[s][t][x][y] + 1) {
									if (INF == dist[ns][nt][nx][ny]) {
										que.add(new int[] { ns, nt, nx, ny });
									}
									dist[ns][nt][nx][ny] = dist[s][t][x][y] + 1;
									dp[ns][nt][nx][ny] = (dp[ns][nt][nx][ny] + dp[s][t][x][y]) % MOD;
								}
							}
						}
					}
					for (int x = 0; x < h; x++) {
						for (int y = 0; y < w; y++) {
							if ((x > 0) && (x < h - 1) && (y > 0) && (y < w - 1)) {
								continue;
							}
							if ((x0 > x) || ((x0 == x) && (y0 > y))) {
								continue;
							}
							if (Math.abs(x - x0) + Math.abs(y - y0) <= 1) {
								continue;
							}
							for (int s = 0; s < 2; s++) {
								for (int t = 0; t < 2; t++) {
									if (dist[s][t][x][y] < INF) {
										int ss = s ^ add2(h, w, x0, y0, sx, sy) ^ add2(h, w, x, y, sx, sy),
												tt = t ^ add2(h, w, x0, y0, gx, gy) ^ add2(h, w, x, y, gx, gy);
										if (ss == tt) {
											continue;
										}
										if ((Math.abs(x - x0) == 1) && (Math.abs(y - y0) == 1)
												&& (dist[s][t][x][y] != 1)) {
											continue;
										}
										if (cost > dist[s][t][x][y] + 1) {
											cost = dist[s][t][x][y] + 1;
											answer = dp[s][t][x][y];
										} else if (cost == dist[s][t][x][y] + 1) {
											answer = (answer + dp[s][t][x][y]) % MOD;
										}
									}
								}
							}
						}
					}
				}
			}
			if (INF == cost) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
				System.out.println(cost + " " + answer);
			}
		}
	}

	private static int add(int x, int y, int nx, int ny, int sx, int sy) {
		if (x == nx) {
			return 0;
		}
		if (x > nx) {
			int tmp = nx;
			nx = x;
			x = tmp;
			tmp = ny;
			ny = y;
			y = tmp;
		}
		if ((x != sx - 1) || (nx != sx)) {
			return 0;
		}
		return (ny < sy) ? 1 : 0;
	}

	private static int add2(int h, int w, int x, int y, int sx, int sy) {
		if (0 == x) {
			if (y > sy) {
				return 0;
			}
			return (x >= sx) ? 1 : 0;
		}
		if (h - 1 == x) {
			return 1;
		}
		if (0 == y) {
			return (x >= sx) ? 1 : 0;
		}
		return 0;
	}

	private static void init(int h, int[][][][] dist, long[][][][] dp) {
		IntStream.range(0, 2).forEach(i -> IntStream.range(0, 2).forEach(j -> IntStream.range(0, h).forEach(k -> {
			Arrays.fill(dist[i][j][k], INF);
			Arrays.fill(dp[i][j][k], 0L);
		})));
	}

	/**
	 * 文字の配列から指定された文字のx座標とy座標を取得する
	 *
	 * @param c      文字の配列
	 * @param target 指定された文字
	 * @return 文字の配列から指定された文字のx座標とy座標
	 */
	private static Data get(char[][] c, char target) {
		int x = -1, y = -1;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				if (c[i][j] == target) {
					x = i;
					y = j;
					break;
				}
			}
		}
		return new Data(x, y);
	}

	/**
	 * x^a mod MODを計算する
	 *
	 * @param x
	 * @param a
	 * @return x^a mod MOD
	 */
	private static long powMod(long x, long a) {
		long result = 1L;
		x %= MOD;
		while (a > 0) {
			if (1 == (1 & a)) {
				result = result * x % MOD;
			}
			x = x * x % MOD;
			a >>= 1;
		}
		return result;
	}

	/**
	 * int型のfirst,secondを格納するクラス
	 */
	private static class Data implements Comparable<Data> {
		int first, second;

		Data(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int hashCode() {
			return Objects.hash(first, second);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Data data) {
				return (first == data.first) && (second == data.second);
			}
			return super.equals(obj);
		}

		@Override
		public int compareTo(Data data) {
			return (first == data.first) ? Integer.compare(second, data.second) : Integer.compare(first, data.first);
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/dsu.hpp のJava実装
	 */
	static class DisjointSetUnion {
		/** 項目数 */
		final int n;
		/** 親のidかグループのサイズ */
		final int[] parentOrSize;
		/** グループの数 */
		int groupNum;

		/**
		 * コンストラクター
		 *
		 * @param n 項目数
		 */
		DisjointSetUnion(int n) {
			if (!(0 <= n)) {
				throw new IllegalArgumentException("n is " + n);
			}
			this.n = n;
			parentOrSize = new int[n];
			Arrays.fill(parentOrSize, -1);
			groupNum = n;
		}

		/**
		 * aとbを同じグループにマージする
		 *
		 * @param a
		 * @param b
		 * @return マージ後のグループリーダー
		 */
		int merge(int a, int b) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			if (!((0 <= b) && (b < n))) {
				throw new IllegalArgumentException("b is " + b);
			}
			int x = leader(a), y = leader(b);
			if (x == y) {
				return x;
			}
			int max = (-parentOrSize[x] < -parentOrSize[y]) ? y : x;
			int min = (-parentOrSize[x] < -parentOrSize[y]) ? x : y;
			parentOrSize[max] += parentOrSize[min];
			parentOrSize[min] = max;
			groupNum--;
			return max;
		}

		/**
		 * aとbが同じグループに所属しているかを判定する
		 *
		 * @param a
		 * @param b
		 * @return aとbが同じグループに所属しているか
		 */
		boolean same(int a, int b) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			if (!((0 <= b) && (b < n))) {
				throw new IllegalArgumentException("b is " + b);
			}
			return leader(a) == leader(b);
		}

		/**
		 * aのグループリーダーを取得する
		 *
		 * @param a
		 * @return aのグループリーダー
		 */
		int leader(int a) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			if (parentOrSize[a] < 0) {
				return a;
			}
			return parentOrSize[a] = leader(parentOrSize[a]);
		}

		/**
		 * aの所属グループのメンバー数を取得する
		 *
		 * @param a
		 * @return aの所属グループのメンバー数
		 */
		int size(int a) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			return -parentOrSize[leader(a)];
		}

		/**
		 * @return グループの一覧
		 */
		int[][] groups() {
			// leaderBuf[i]はiのリーダー、groupSize[i]はiの所在groupのサイズ
			int[] leaderBuf = new int[n], groupSize = new int[n];
			for (int i = 0; i < n; i++) {
				leaderBuf[i] = leader(i);
				groupSize[leaderBuf[i]]++;
			}
			Set<Integer> leaderSet = new HashSet<>();
			int count = 0;
			// groupNo[i]はiの所在グループの番号、groupLeader[i]はグループiのリーダー
			int[] groupNo = new int[n], groupLeader = new int[groupNum];
			for (int i = 0; i < n; i++) {
				if (!leaderSet.contains(leaderBuf[i])) {
					groupNo[leaderBuf[i]] = count;
					groupLeader[count] = leaderBuf[i];
					count++;
					leaderSet.add(leaderBuf[i]);
				}
				groupNo[i] = groupNo[leaderBuf[i]];
			}
			int[] indexes = new int[groupNum];
			int[][] result = new int[groupNum][];
			for (int i = 0; i < groupNum; i++) {
				result[i] = new int[groupSize[groupLeader[i]]];
			}
			Arrays.fill(indexes, 0);
			for (int i = 0; i < n; i++) {
				result[groupNo[i]][indexes[groupNo[i]]++] = i;
			}
			return result;
		}
	}
}
