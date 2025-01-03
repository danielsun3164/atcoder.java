package abc.abc201_250.abc233;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc233/editorial/3164 の実装<br/>
 * https://atcoder.jp/contests/abc233/submissions/28096309 にも参考
 */
public class ProblemF {

	private static List<Integer> ax;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] p = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			int m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Edge>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			DisjointSetUnion dsu = new DisjointSetUnion(n);
			Data[] ab = IntStream.range(0, m).mapToObj(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				if (!dsu.same(a, b)) {
					dsu.merge(a, b);
					edges[a].add(new Edge(b, i));
					edges[b].add(new Edge(a, i));
				}
				return new Data(a, b);
			}).toArray(Data[]::new);
			List<Integer> jun = new ArrayList<>();
			boolean[] used = new boolean[n];
			Arrays.fill(used, false);
			IntStream.range(0, n).filter(i -> !used[i]).forEach(i -> {
				used[i] = true;
				Queue<Integer> que = new ArrayDeque<>();
				que.add(i);
				while (!que.isEmpty()) {
					int now = que.poll();
					jun.add(now);
					for (Edge edge : edges[now]) {
						if (!used[edge.to]) {
							used[edge.to] = true;
							que.add(edge.to);
						}
					}
				}
			});
			Collections.reverse(jun);
			List<Integer> answer = new ArrayList<>();
			for (int x : jun) {
				if (x != p[x]) {
					ax = new ArrayList<>();
					List<Integer> result = new ArrayList<>();
					dfs(x, x, -1, p, edges, result);
					if (ax.isEmpty()) {
						System.out.println(-1);
						return;
					}
					Collections.reverse(ax);
					for (int axi : ax) {
						answer.add(axi);
						swap(p, ab[axi]);
					}
				}
			}
			System.out.println(answer.size());
			System.out.println(answer.stream().map(ai -> String.valueOf(ai + 1)).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * xにたどっていくための経路を再帰的に計算する
	 *
	 * @param x      目標値
	 * @param now    現在の処理対象
	 * @param prev   直前の処理対象
	 * @param p      配列
	 * @param edges  辺の一覧
	 * @param result 一時結果を格納するリスト
	 */
	private static void dfs(int x, int now, int prev, int[] p, List<Edge>[] edges, List<Integer> result) {
		if (x == p[now]) {
			ax.clear();
			ax.addAll(result);
			return;
		}
		for (Edge edge : edges[now]) {
			if (prev != edge.to) {
				result.add(edge.index);
				dfs(x, edge.to, now, p, edges, result);
				result.remove(result.size() - 1);
			}
		}
	}

	/**
	 * 配列pのdata.a番目の要素とdata.b番目の要素を交換する
	 *
	 * @param p
	 * @param data
	 */
	private static void swap(int[] p, Data data) {
		int temp = p[data.a];
		p[data.a] = p[data.b];
		p[data.b] = temp;
	}

	/**
	 * to, indexを格納するクラス
	 */
	private static class Edge {
		int to, index;

		Edge(int to, int index) {
			this.to = to;
			this.index = index;
		}
	}

	/**
	 * a,bを格納するクラス
	 */
	private static class Data {
		int a, b;

		Data(int a, int b) {
			this.a = a;
			this.b = b;
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
		@SuppressWarnings("unused")
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
