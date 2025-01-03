package abc.abc151_200.abc155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc155/submissions/10311958 にも参考
 */
public class ProblemF {

	/** Aの最大値 */
	private static final int INF = 1_000_000_005;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Data[] datas = new Data[n + 1];
			datas[n] = new Data(INF, 0);
			IntStream.range(0, n).forEach(i -> {
				datas[i] = new Data(scanner.nextInt(), scanner.nextInt());
			});
			Arrays.sort(datas, (a, b) -> Integer.compare(a.a, b.a));
			int[] x = new int[n + 1];
			x[0] = datas[0].b;
			IntStream.rangeClosed(1, n).forEach(i -> x[i] = datas[i - 1].b ^ datas[i].b);
			@SuppressWarnings("unchecked")
			List<Edge>[] edges = new List[n + 1];
			IntStream.range(0, n + 1).forEach(i -> edges[i] = new ArrayList<>());
			DisjointSetUnion dsu = new DisjointSetUnion(n + 1);
			IntStream.range(0, m).forEach(i -> {
				int l = lowerBound(datas, scanner.nextInt()), r = lowerBound(datas, scanner.nextInt() + 1);
				if (!dsu.same(l, r)) {
					dsu.merge(l, r);
					edges[l].add(new Edge(l, r, i + 1));
					edges[r].add(new Edge(r, l, i + 1));
				}
			});
			int[] count = new int[n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> count[dsu.leader(i)] += x[i]);
			for (int i = 0; i <= n; i++) {
				if (1 == (count[i] & 1)) {
					System.out.println(-1);
					return;
				}
			}
			Set<Integer> answer = new TreeSet<>();
			IntStream.rangeClosed(0, n).filter(i -> i == dsu.leader(i)).forEach(i -> {
				if (dfs(x, edges, answer, i, -1)) {
					answer.add(i);
					x[i] ^= 1;
				}
			});
			System.out.println(answer.size());
			System.out.println(answer.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * 配列の指定された値以上のデータのインデックスを取得する
	 *
	 * @param datas 配列
	 * @param value 値
	 * @return 配列の指定された値以上のデータのインデックス
	 */
	private static int lowerBound(Data[] datas, int value) {
		int index = Arrays.binarySearch(datas, new Data(value, 0), (a, b) -> Integer.compare(a.a, b.a));
		return (index < 0) ? ~index : index;
	}

	/**
	 * 結果を再帰的に計算する
	 *
	 * @param x      diffの一覧
	 * @param edges  辺の一覧
	 * @param answer 結果の一覧
	 * @param now    現在の処理対象
	 * @param prev   直前の処理対象
	 * @return 結果が変わるかどうか
	 */
	private static boolean dfs(int[] x, List<Edge>[] edges, Set<Integer> answer, int now, int prev) {
		for (Edge edge : edges[now]) {
			if (edge.to != prev) {
				if (dfs(x, edges, answer, edge.to, now)) {
					answer.add(edge.index);
					x[now] ^= 1;
				}
			}
		}
		return x[now] == 1;
	}

	/**
	 * a,b を格納するクラス
	 */
	private static class Data {
		int a, b;

		Data(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
	}

	/**
	 * from,to,index を格納するクラス
	 */
	private static class Edge {
		@SuppressWarnings("unused")
		int from, to, index;

		Edge(int from, int to, int index) {
			super();
			this.from = from;
			this.to = to;
			this.index = index;
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
