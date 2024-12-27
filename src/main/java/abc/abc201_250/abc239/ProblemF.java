package abc.abc201_250.abc239;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc239/editorial/3388 の実装<br/>
 * https://atcoder.jp/contests/abc239/submissions/29229844 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] d = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			DisjointSetUnion dsu = new DisjointSetUnion(n);
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				dsu.merge(a, b);
				d[a]--;
				d[b]--;
			});
			@SuppressWarnings("unchecked")
			Deque<Integer>[] temp = new Deque[n];
			IntStream.range(0, n).forEach(i -> temp[i] = new ArrayDeque<>());
			if (IntStream.range(0, n).filter(i -> d[i] < 0).count() > 0) {
				System.out.println(-1);
				return;
			}
			IntStream.range(0, n).forEach(i -> IntStream.range(0, d[i]).forEach(j -> temp[dsu.leader(i)].add(i)));
			List<Deque<Integer>> c2 = new ArrayList<>();
			Deque<Integer> c1 = new ArrayDeque<>();
			IntStream.range(0, n).forEach(i -> {
				if (1 == temp[i].size()) {
					c1.addLast(temp[i].pollFirst());
				} else if (temp[i].size() > 1) {
					c2.add(temp[i]);
				}
			});
			List<Data> answer = new ArrayList<>();
			for (Deque<Integer> v : c2) {
				while (v.size() > 1) {
					if (c1.isEmpty()) {
						System.out.println(-1);
						return;
					}
					dsu.merge(v.peekFirst(), c1.peekLast());
					answer.add(new Data(v.pollFirst(), c1.pollLast()));
				}
				c1.addLast(v.pollLast());
			}
			if (2 != c1.size()) {
				System.out.println(-1);
				return;
			}
			dsu.merge(c1.peekFirst(), c1.peekLast());
			answer.add(new Data(c1.pollFirst(), c1.pollLast()));
			if (n != dsu.size(0)) {
				System.out.println(-1);
				return;
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			answer.forEach(data -> sb.append(data.first + 1).append(" ").append(data.second + 1)
					.append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * first, secondを格納するクラス
	 */
	private static class Data {
		int first, second;

		Data(int first, int second) {
			this.first = first;
			this.second = second;
		}
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
