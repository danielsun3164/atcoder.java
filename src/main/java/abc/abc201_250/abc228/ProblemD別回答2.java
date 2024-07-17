package abc.abc201_250.abc228;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc228/editorial/2962 の実装<br/>
 * https://atcoder.jp/contests/abc228/submissions/27408315 にも参考
 */
public class ProblemD別回答2 {

	/** 2^20 */
	private static final int N = 1 << 20;
	/** マスク */
	private static final int MASK = N - 1;
	/** intのbit数 */
	private static final int W = Integer.SIZE;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			long[] a = new long[N];
			Arrays.fill(a, -1L);
			DecrementalPredecessor set = new DecrementalPredecessor(N);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int t = scanner.nextInt();
				long x = scanner.nextLong();
				if (1 == t) {
					int h = (int) (x & MASK);
					h = set.successor(h - 1);
					if (N == h) {
						h = set.successor(-1);
					}
					a[h] = x;
					set.erase(h);
				} else {
					sb.append(a[(int) (x & MASK)]).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	static class DecrementalPredecessor {
		int n;
		int[] small;
		DisjointSetUnion large;

		DecrementalPredecessor(int n) {
			this.n = n;
			int b = n / W, t = n % W;
			small = new int[b + 1];
			Arrays.fill(small, ~0);
			large = new DisjointSetUnion(b + 2);
			small[b] = ~((~0) << t);
			if (0 == t) {
				large.merge(b, b + 1);
			}
		}

		boolean erase(int x) {
			int b = x / W, t = x % W;
			if (0 == (small[b] & (1 << t))) {
				return false;
			}
			small[b] &= ~(1 << t);
			if (0 == small[b]) {
				large.merge(b, b + 1);
			}
			return true;
		}

		int universeSize() {
			return n;
		}

		int predecessor(int x) {
			x++;
			int b = x / W, t = x % W;
			int m = small[b] & ~((~0) << t);
			if (0 != m) {
				return b * W + W - 1 - Integer.numberOfTrailingZeros(m);
			}
			b = large.left(b);
			if (0 == b) {
				return -1;
			}
			b--;
			return b * W + W - 1 - Integer.numberOfTrailingZeros(small[b]);
		}

		int successor(int x) {
			x++;
			int b = x / W, t = x % W;
			int m = small[b] & ((~0) << t);
			if (0 != m) {
				return b * W + Integer.numberOfTrailingZeros(m);
			}
			b = large.right(b + 1);
			if (b == small.length) {
				return n;
			}
			return b * W + Integer.numberOfTrailingZeros(small[b]);
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/dsu.hpp のJava実装<br/>
	 * https://atcoder.jp/contests/abc228/submissions/27408315 の実装も追加
	 */
	static class DisjointSetUnion {
		/** 項目数 */
		final int n;
		/** 親のidかグループのサイズ */
		final int[] parentOrSize;
		final int[] l, r;
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
			l = new int[n];
			r = new int[n];
			IntStream.range(0, n).forEach(i -> l[i] = r[i] = i);
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
			if (-parentOrSize[x] < -parentOrSize[y]) {
				l[y] = l[x];
			} else {
				r[x] = r[y];
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

		int left(int x) {
			return l[leader(x)];
		}

		int right(int x) {
			return r[leader(x)];
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
