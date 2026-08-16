package abc.abc201_250.abc233;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://kazun-kyopro.hatenablog.com/entry/ABC/233/F の実装<br/>
 * https://atcoder.jp/contests/abc233/submissions/28133493 にも参考
 */
public class ProblemF別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] p = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			int m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] e = new List[n];
			IntStream.range(0, n).forEach(i -> e[i] = new ArrayList<>());
			DisjointSetUnion dsu1 = new DisjointSetUnion(n);
			Map<Long, Integer> map = new HashMap<>();
			Data[] h = IntStream.range(0, m).mapToObj(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				dsu1.merge(a, b);
				e[a].add(b);
				e[b].add(a);
				map.put(encode(n, a, b), i);
				return new Data(a, b);
			}).toArray(Data[]::new);
			for (int i = 0; i < n; i++) {
				if (!dsu1.same(i, p[i])) {
					System.out.println(-1);
					return;
				}
			}
			@SuppressWarnings("unchecked")
			NavigableSet<Integer>[] f = new NavigableSet[n];
			IntStream.range(0, n).forEach(i -> f[i] = new TreeSet<>());
			DisjointSetUnion dsu2 = new DisjointSetUnion(n);
			IntStream.range(0, n).forEach(a -> e[a].stream().filter(b -> !dsu2.same(a, b)).forEach(b -> {
				dsu2.merge(a, b);
				f[a].add(b);
				f[b].add(a);
			}));
			Deque<Integer> r = new ArrayDeque<>();
			IntStream.range(0, n).filter(i -> 1 == f[i].size()).forEach(i -> r.addLast(i));
			List<Integer> answer = new ArrayList<>();
			while (!r.isEmpty()) {
				int now = r.pollFirst();
				if (f[now].size() > 0) {
					int index = IntStream.range(0, n).filter(j -> now == p[j]).findFirst().getAsInt();
					List<Integer> s = dfs(n, f, map, now, index);
					s.forEach(c -> swap(p, h[c]));
					answer.addAll(s);
					int k = f[now].pollFirst();
					f[k].remove(now);
					if (1 == f[k].size()) {
						r.addLast(k);
					}
				}
			}
			System.out.println(answer.size());
			System.out.println(answer.stream().map(ai -> String.valueOf(ai + 1)).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * n,a,bからキーとなるlong値を計算する
	 *
	 * @param n
	 * @param a
	 * @param b
	 * @return キーとなるlong値
	 */
	private static long encode(long n, long a, long b) {
		return Math.max(a, b) * (n + 10L) + Math.min(a, b);
	}

	/**
	 * 現在の数字からパスを再帰的に計算する
	 *
	 * @param n
	 * @param f
	 * @param map
	 * @param x     現在の数字
	 * @param index
	 * @return パス
	 */
	private static List<Integer> dfs(int n, NavigableSet<Integer>[] f, Map<Long, Integer> map, int x, int index) {
		int[] t = new int[n];
		Arrays.fill(t, -1);
		t[x] = 0;
		Deque<Integer> que = new ArrayDeque<>();
		que.addLast(x);
		while (!que.isEmpty() && (-1 == t[index])) {
			int a = que.pollFirst();
			f[a].stream().filter(b -> -1 == t[b]).forEach(b -> {
				que.addLast(b);
				t[b] = a;
			});
		}
		int b = index;
		List<Integer> result = new ArrayList<>();
		while (b != x) {
			result.add(map.get(encode(n, b, t[b])));
			b = t[b];
		}
		return result;
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
	 * a,bを格納するクラス
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
