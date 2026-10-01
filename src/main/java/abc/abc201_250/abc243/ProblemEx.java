package abc.abc201_250.abc243;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc243/editorial/3546 の実装<br/>
 * https://atcoder.jp/contests/abc243/submissions/30025568 にも参考
 */
public class ProblemEx {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;
	/** 壁が使用できる文字 */
	private static final char EMPTY = '.';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] c = new char[h][];
			IntStream.range(0, h).forEach(i -> c[i] = scanner.next().toCharArray());
			Data start = get(c, 'S'), goal = get(c, 'G');
			int sx = start.first, sy = start.second, gx = goal.first, gy = goal.second;
			NavigableSet<Data> path = new TreeSet<>(), uv = new TreeSet<>(), u = new TreeSet<>();
			{
				int i = sx, j = sy;
				while (i < gx) {
					i++;
					path.add(new Data(i, j));
				}
				while (i > gx) {
					i--;
					path.add(new Data(i, j));
				}
				while (j < gy) {
					j++;
					path.add(new Data(i, j));
				}
				while (j > gy) {
					j--;
					path.add(new Data(i, j));
				}
				path.remove(new Data(gx, gy));
			}
			path.forEach(data -> IntStream.rangeClosed(-1, 1).forEach(di -> IntStream.rangeClosed(-1, 1).forEach(dj -> {
				Data newData = new Data(data.first + di, data.second + dj);
				if (!path.contains(newData)) {
					uv.add(newData);
				}
			})));
			uv.remove(new Data(sx, sy));
			uv.remove(new Data(gx, gy));
			if (uv.size() > 0) {
				Data first = uv.getFirst();
				dfs(uv, u, first.first, first.second);
			}
			@SuppressWarnings("unchecked")
			List<Pair<Data, Integer>>[][] g = new List[h + 1][w + 1];
			IntStream.rangeClosed(0, h)
					.forEach(i -> IntStream.rangeClosed(0, w).forEach(j -> g[i][j] = new ArrayList<>()));
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).filter(j -> c[i][j] == EMPTY).forEach(j -> {
				if ((i + 1 < h) && (c[i + 1][j] == EMPTY)) {
					int state = calcState(path, u, i, j, i + 1, j);
					g[i][j].add(new Pair<>(new Data(i + 1, j), state));
					g[i + 1][j].add(new Pair<>(new Data(i, j), state));
				}
				if ((j + 1 < w) && (c[i][j + 1] == EMPTY)) {
					int state = calcState(path, u, i, j, i, j + 1);
					g[i][j].add(new Pair<>(new Data(i, j + 1), state));
					g[i][j + 1].add(new Pair<>(new Data(i, j), state));
				}
				if ((i + 1 < h) && (j + 1 < w) && (c[i + 1][j + 1] == EMPTY)) {
					int state = calcState(path, u, i, j, i + 1, j + 1);
					g[i][j].add(new Pair<>(new Data(i + 1, j + 1), state));
					g[i + 1][j + 1].add(new Pair<>(new Data(i, j), state));
				}
				if ((i > 0) && (j + 1 < w) && (c[i - 1][j + 1] == EMPTY)) {
					int state = calcState(path, u, i, j, i - 1, j + 1);
					g[i][j].add(new Pair<>(new Data(i - 1, j + 1), state));
					g[i - 1][j + 1].add(new Pair<>(new Data(i, j), state));
				}
			}));
			{
				List<Pair<Data, Data>> list = new ArrayList<>();
				IntStream.range(0, h).forEach(i -> {
					if (EMPTY == c[i][0]) {
						list.add(new Pair<>(new Data(i, 0), new Data(i, -1)));
					}
					if (EMPTY == c[i][w - 1]) {
						list.add(new Pair<>(new Data(i, w - 1), new Data(i, w)));
					}
				});
				IntStream.range(0, w).forEach(j -> {
					if (EMPTY == c[0][j]) {
						list.add(new Pair<>(new Data(0, j), new Data(-1, j)));
					}
					if (EMPTY == c[h - 1][j]) {
						list.add(new Pair<>(new Data(h - 1, j), new Data(h, j)));
					}
				});
				IntStream.range(0, list.size()).forEach(i -> IntStream.range(0, i).forEach(j -> {
					Data p1 = list.get(i).first, w1 = list.get(i).second, p2 = list.get(j).first,
							w2 = list.get(j).second;
					int state1 = calcState(path, u, p1.first, p1.second, w1.first, w1.second),
							state2 = calcState(path, u, p2.first, p2.second, w2.first, w2.second);
					int state = state1 ^ state2;
					g[p1.first][p1.second].add(new Pair<>(p2, state));
					g[p2.first][p2.second].add(new Pair<>(p1, state));
				}));
			}
			IntStream.range(0, h).forEach(
					i -> IntStream.range(0, w).forEach(j -> g[i][j] = g[i][j].stream().distinct().sorted().toList()));

			long answer1 = INF, answer2 = 0L;
			boolean[][] banned = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(banned[i], false));
			long[][][] dist = new long[h][w][2], dp = new long[h][w][2];
			for (Data data : path) {
				IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> {
					Arrays.fill(dist[i][j], INF);
					Arrays.fill(dp[i][j], 0L);
				}));
				int ii = data.first, jj = data.second;
				dist[ii][jj][0] = 0L;
				dp[ii][jj][0] = 1L;
				Queue<int[]> que = new ArrayDeque<>();
				que.add(new int[] { ii, jj, 0 });
				while (!que.isEmpty()) {
					int[] v = que.poll();
					int curi = v[0], curj = v[1], state = v[2];
					long curDist = dist[curi][curj][state], curDp = dp[curi][curj][state];
					g[curi][curj].forEach(pair -> {
						int dsti = pair.first.first, dstj = pair.first.second, delta = pair.second;
						if (!banned[dsti][dstj]) {
							int next = state ^ delta;
							if (curDist + 1 < dist[dsti][dstj][next]) {
								dist[dsti][dstj][next] = curDist + 1;
								dp[dsti][dstj][next] = curDp;
								que.add(new int[] { dsti, dstj, next });
							} else if (curDist + 1 == dist[dsti][dstj][next]) {
								dp[dsti][dstj][next] = (dp[dsti][dstj][next] + curDp) % MOD;
							}
						}
					});
				}
				if (dist[ii][jj][1] < answer1) {
					answer1 = dist[ii][jj][1];
					answer2 = dp[ii][jj][1];
				} else if (dist[ii][jj][1] == answer1) {
					answer2 = (answer2 + dp[ii][jj][1]) % MOD;
				}
				banned[ii][jj] = true;
			}
			if (INF == answer1) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
				System.out.println(answer1 + " " + (answer2 * powMod(2, MOD - 2) % MOD));
			}
		}
	}

	private static void dfs(NavigableSet<Data> uv, NavigableSet<Data> u, int i, int j) {
		u.add(new Data(i, j));
		IntStream.rangeClosed(-1, 1).forEach(di -> IntStream.rangeClosed(-1, 1).forEach(dj -> {
			int k = i + di, l = j + dj;
			Data newData = new Data(k, l);
			if (uv.contains(newData) && !u.contains(newData)) {
				dfs(uv, u, k, l);
			}
		}));
	}

	/**
	 * stateを計算する
	 *
	 * @param path
	 * @param u
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 * @return state
	 */
	private static int calcState(NavigableSet<Data> path, NavigableSet<Data> u, int i, int j, int k, int l) {
		Data data1 = new Data(i, j), data2 = new Data(k, l);
		return ((path.contains(data1) && u.contains(data2)) || (path.contains(data2) && u.contains(data1))) ? 1 : 0;
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
	 * ジェネリック型のfirst,secondを格納するクラス
	 */
	private static class Pair<S extends Comparable<S>, T extends Comparable<T>> implements Comparable<Pair<S, T>> {
		S first;
		T second;

		Pair(S first, T second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int hashCode() {
			return Objects.hash(first, second);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Pair pair) {
				return first.equals(pair.first) && second.equals(pair.second);
			}
			return super.equals(obj);
		}

		@Override
		public int compareTo(Pair<S, T> p) {
			return (first.equals(p.first)) ? second.compareTo(p.second) : first.compareTo(p.first);
		}
	}
}
