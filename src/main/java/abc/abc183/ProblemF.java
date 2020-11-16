package abc.abc183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] c = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			DisjointSetUnion dsu = new DisjointSetUnion(n, c);
			IntStream.range(0, q).forEach(i -> {
				int t = scanner.nextInt();
				if (1 == t) {
					int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
					dsu.merge(a, b);
				} else {
					int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
					System.out.println(dsu.classMap[dsu.leader(x)].getOrDefault(y, 0));
				}
			});
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/dsu.hpp をもとに作成
	 */
	private static class DisjointSetUnion {
		/** 項目数 */
		final int n;
		/** 親のidかグループのサイズ */
		final int[] parentOrSize;
		/** 各グループに所属する生徒のクラスごとの人数 */
		final Map<Integer, Integer>[] classMap;
		/** グループの数 */
		@SuppressWarnings("unused")
		int groupNum;

		/**
		 * コンストラクター
		 * 
		 * @param n 項目数
		 * @param c 各生徒の所属するクラスの配列
		 */
		@SuppressWarnings("unchecked")
		DisjointSetUnion(int n, int[] c) {
			this.n = n;
			parentOrSize = new int[n];
			Arrays.fill(parentOrSize, -1);
			classMap = new Map[n];
			IntStream.range(0, n).forEach(i -> classMap[i] = new HashMap<>());
			IntStream.range(0, n).forEach(i -> classMap[i].put(c[i], 1));
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
			// クラスごとの生徒数をマージする
			classMap[min].entrySet().stream().forEach(entry -> classMap[max].put(entry.getKey(),
					classMap[max].getOrDefault(entry.getKey(), 0) + entry.getValue()));
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
		List<List<Integer>> groups() {
			int[] leaderBuf = new int[n], size = new int[n];
			IntStream.range(0, n).forEach(i -> {
				leaderBuf[i] = leader(i);
				size[leaderBuf[i]]++;
			});
			Map<Integer, List<Integer>> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				List<Integer> list = map.get(leaderBuf[i]);
				if (null == list) {
					list = new ArrayList<>();
					map.put(leaderBuf[i], list);
				}
				list.add(i);
			});
			return map.values().stream().collect(Collectors.toList());
		}
	}
}
