package abc.abc201_250.abc227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc227/editorial/9952 の解説の実装<br/>
 * https://atcoder.jp/contests/abc227/submissions/53210191 にも参考
 */
public class ProblemH別回答 {

	/** マスの幅 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[][] a = IntStream.range(0, N).mapToObj(i -> IntStream.range(0, N).map(j -> scanner.nextInt()).toArray())
					.toArray(int[][]::new);
			int[][] b = new int[N][N - 1], c = new int[N - 1][N];
			int pMax = a[0][0] << 1, qMax = a[0][2] << 1, pqMax = a[0][1] << 1;
			for (int p = 0; p <= pMax; p++) {
				for (int q = 0; (q <= qMax) && (p + q <= pqMax); q++) {
					b[0][0] = p;
					b[0][1] = q;
					c[0][0] = (a[0][0] << 1) - p;
					c[0][1] = (a[0][1] << 1) - p - q;
					c[0][2] = (a[0][2] << 1) - q;
					int rMin = Math.max(0, (a[1][0] - a[2][0]) * 2 - c[0][0]),
							sMin = Math.max(0, (a[1][2] - a[2][2]) * 2 - c[0][2]), rMax = a[1][0] * 2 - c[0][0],
							sMax = a[1][2] * 2 - c[0][2], rsMax = a[1][1] * 2 - c[0][1];
					for (int r = rMin; r <= rMax; r++) {
						for (int s = sMin; (s <= sMax) && (r + s <= rsMax); s++) {
							b[1][0] = r;
							b[1][1] = s;
							c[1][0] = a[1][0] * 2 - c[0][0] - r;
							c[1][1] = a[1][1] * 2 - c[0][1] - r - s;
							c[1][2] = a[1][2] * 2 - c[0][2] - s;
							b[2][0] = a[2][0] * 2 - c[1][0];
							b[2][1] = a[2][2] * 2 - c[1][2];
							if (c[1][1] + b[2][0] + b[2][1] != a[2][1] * 2) {
								continue;
							}
							DisjointSetUnion dsu = new DisjointSetUnion(N * N);
							for (int i = 0; i < N; i++) {
								for (int j = 0; j < N - 1; j++) {
									int x = i * N + j, y = x + 1;
									if (b[i][j] > 0) {
										dsu.merge(x, y);
									}
									x = j * N + i;
									y = x + N;
									if (c[j][i] > 0) {
										dsu.merge(x, y);
									}
								}
							}
							if (N * N != dsu.size(0)) {
								continue;
							}

							int[][] g = new int[N * N][N * N];
							IntStream.range(0, N * N).forEach(i -> Arrays.fill(g[i], 0));
							for (int i = 0; i < N; i++) {
								for (int j = 0; j < N - 1; j++) {
									int x = i * N + j, y = x + 1;
									g[x][y] += b[i][j];
									g[y][x] += b[i][j];
									x = j * N + i;
									y = x + N;
									g[x][y] += c[j][i];
									g[y][x] += c[j][i];
								}
							}
							int[] t = calc(N * N, g);
							StringBuilder sb = new StringBuilder();
							IntStream.range(0, t.length - 1).forEach(i -> sb.append(switch (t[i + 1] - t[i]) {
							case -1 -> 'L';
							case 1 -> 'R';
							case -3 -> 'U';
							default -> 'D';
							}));
							System.out.println(sb.toString());
							return;
						}
					}
				}
			}

			System.out.println("NO");
		}
	}

	/**
	 * 終点までたどるルートを計算する
	 *
	 * @param n
	 * @param g
	 * @return 終点までたどるルート
	 */
	private static int[] calc(int n, int[][] g) {
		List<Integer> result = new ArrayList<>();

		int s = -1;
		for (int i = 0; i < n; i++) {
			int deg = 0;
			for (int j = 0; j < n; j++) {
				deg += g[i][j];
			}
			if (1 == (deg & 1)) {
				s = i;
				break;
			}
		}
		if (-1 == s) {
			s = 0;
		}
		dfs(n, g, result, s);
		int m = result.size();
		return IntStream.range(0, m).map(i -> result.get(m - 1 - i)).toArray();
	}

	/**
	 * 終点までたどるルートを再帰的に計算する
	 *
	 * @param n      ノード数
	 * @param g      たどる可能性のあるパス一覧
	 * @param result 終点までたどるルート
	 * @param x      現在計算中のノード
	 */
	private static void dfs(int n, int[][] g, List<Integer> result, int x) {
		for (int y = 0; y < n; y++) {
			if (g[x][y] > 0) {
				g[x][y]--;
				g[y][x]--;
				dfs(n, g, result, y);
			}
		}
		result.add(x);
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/dsu.hpp のJava実装
	 */
	private static class DisjointSetUnion {
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
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
		int[][] groups() {
			// leaderBuf[i]はiのリーダー、groupSize[i]はiの所在groupのサイズ
			int[] leaderBuf = new int[n], groupSize = new int[n];
			IntStream.range(0, n).forEach(i -> {
				leaderBuf[i] = leader(i);
				groupSize[leaderBuf[i]]++;
			});
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
