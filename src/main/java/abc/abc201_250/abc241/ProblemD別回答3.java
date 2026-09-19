package abc.abc201_250.abc241;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/7444 の実装<br/>
 * https://atcoder.jp/contests/abc241/submissions/46723997 にも参考
 */
public class ProblemD別回答3 {

	public static void main(String[] args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			Query[] queries = new Query[q];

			// Addされた値を一旦保存
			long[] tmpValues = new long[q];
			int valueCount = 0;

			for (int i = 0; i < q; i++) {
				int t = scanner.nextInt();
				long x = scanner.nextLong();
				if (t == 1) {
					queries[i] = new Query(t, x, 0);
					tmpValues[valueCount++] = x;
				} else if (t == 2) {
					int k = scanner.nextInt();
					queries[i] = new Query(t, x, k);
				} else if (t == 3) {
					int k = scanner.nextInt();
					queries[i] = new Query(t, x, k);
				}
			}

			// values = Addされた値 + 0 + Long.MAX_VALUE
			long[] values = new long[valueCount + 2];
			System.arraycopy(tmpValues, 0, values, 0, valueCount);
			values[valueCount] = 0L;
			values[valueCount + 1] = Long.MAX_VALUE;

			Arrays.sort(values);

			int n = 0;
			for (long value : values) {
				if (n == 0 || values[n - 1] != value) {
					values[n++] = value;
				}
			}
			values = Arrays.copyOf(values, n);
			int[] tail = new int[n], head = new int[n], count = new int[n];
			for (int i = 0; i < n; i++) {
				tail[i] = head[i] = i;
			}

			// 最初の時点で各値が何個存在するかを数える
			for (Query query : queries) {
				if (query.type == 1) {
					count[Arrays.binarySearch(values, query.x)]++;
				}
			}

			DisjointSetUnion uf = new DisjointSetUnion(n);
			long[] ans = new long[q];
			int ansCount = 0;

			// クエリを逆順に処理
			for (int qi = q - 1; qi >= 0; qi--) {
				Query query = queries[qi];
				if (query.type == 1) {
					long x = query.x;
					int i = Arrays.binarySearch(values, x);
					count[i]--;
					if (count[i] == 0) {
						int l = head[uf.leader(i - 1)], r = tail[uf.leader(i)] + 1;
						uf.merge(l, i);
						int root = uf.leader(i);
						head[root] = l;
						tail[root] = r - 1;
					}
				} else if (query.type == 2) {
					long x = query.x;
					int k = query.k;

					int i = upperBound(values, x) - 1;
					i = head[uf.leader(i)];
					while (i > 0) {
						if (k <= count[i]) {
							break;
						}
						k -= count[i];
						i = head[uf.leader(i - 1)];
					}
					ans[ansCount++] = (i == 0) ? -1L : values[i];
				} else {
					long x = query.x;
					int r = query.k;

					int i = lowerBound(values, x) - 1;
					i = tail[uf.leader(i)] + 1;
					while (i < n - 1) {
						if (r <= count[i]) {
							break;
						}
						r -= count[i];
						i = tail[uf.leader(i)] + 1;
					}
					ans[ansCount++] = (i == n - 1) ? -1L : values[i];
				}
			}

			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			for (int i = ansCount - 1; i >= 0; i--) {
				sb.append(ans[i]).append(System.lineSeparator());
			}
			System.out.print(sb);
			System.out.flush();
		}
	}

	/**
	 * values[i] >= x となる最初の位置 Rustの partition_point(|&y| y < x) に相当
	 */
	static int lowerBound(long[] values, long x) {
		int lo = 0, hi = values.length;

		while (lo < hi) {
			int mid = (lo + hi) >>> 1;
			if (values[mid] < x) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	/**
	 * values[i] > x となる最初の位置 Rustの partition_point(|&y| y <= x) に相当
	 */
	static int upperBound(long[] values, long x) {
		int lo = 0, hi = values.length;

		while (lo < hi) {
			int mid = (lo + hi) >>> 1;
			if (values[mid] <= x) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	static class Query {
		int type;
		long x;
		int k;

		Query(int type, long x, int d) {
			this.type = type;
			this.x = x;
			k = d;
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
