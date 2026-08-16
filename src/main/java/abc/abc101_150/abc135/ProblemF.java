package abc.abc101_150.abc135;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * KMP法での実装
 *
 * https://atcoder.jp/contests/abc135/submissions/6588731 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			int n = (t.length + s.length - 1) / s.length * s.length;
			char[] newS = new char[n];
			for (int i = 0; i < n; i += s.length) {
				System.arraycopy(s, 0, newS, i, s.length);
			}
			BitSet match = kmp(newS, t);
			DisjointSetUnion dsu = new DisjointSetUnion(n);
			for (int i = 0; i < n; i++) {
				if (match.get(i)) {
					int j = (i + t.length) % n;
					if (!dsu.same(i, j)) {
						dsu.merge(i, j);
					} else {
						System.out.println(-1);
						return;
					}
				}
			}
			System.out.println(IntStream.range(0, n).map(i -> dsu.size(i)).max().getAsInt() - 1);
		}
	}

	/**
	 * KMP法でsとtの一致性を計算する
	 *
	 * @param s
	 * @param t
	 * @return sのi文字目から i + |t| − 1 文字目までの部分文字列がtと一致するか否かのbitset
	 */
	private static BitSet kmp(char[] s, char[] t) {
		int[] table = createTable(t);
		int i = 0, j = 0, n = s.length;
		BitSet bitSet = new BitSet(n);
		while (i < n + t.length) {
			if (s[i % n] == t[j]) {
				i++;
				j++;
				if (j == t.length) {
					int idx = i - t.length;
					if (idx > n) {
						break;
					}
					bitSet.set(idx, true);
					j = table[j];
				}
			} else {
				if (j != 0) {
					j = table[j];
				} else {
					i++;
				}
			}
		}
		return bitSet;
	}

	/**
	 * KMP法用ずらし表の生成
	 *
	 * @param t 検索対象文字列
	 * @return KMP法用ずらし表
	 */
	private static int[] createTable(char[] t) {
		int n = t.length;
		int[] table = new int[n + 1];
		table[0] = -1;
		for (int i = 0; i < n; i++) {
			int m = table[i];
			while ((m != -1) && (t[i] != t[m])) {
				m = table[m];
			}
			table[i + 1] = m + 1;
		}
		return table;
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
