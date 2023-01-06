package other.typical90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem012 {

	/** X座標の差分の一覧 */
	private static final int[] XS = { 1, -1, 0, 0 };
	/** Y座標の差分の一覧 */
	private static final int[] YS = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), n = h * w;
			BitSet bitSet = new BitSet(n);
			bitSet.clear();
			DisjointSetUnion dsu = new DisjointSetUnion(n);
			int q = scanner.nextInt();
			// TLEを回避するため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int t = scanner.nextInt();
				if (1 == t) {
					int r = scanner.nextInt() - 1, c = scanner.nextInt() - 1;
					int m = (r * w) + c;
					bitSet.set(m, true);
					IntStream.range(0, XS.length).forEach(j -> {
						int nr = r + XS[j], nc = c + YS[j];
						if ((nr >= 0) && (nr < h) && (nc >= 0) && (nc < w)) {
							int nm = (nr * w) + nc;
							if (bitSet.get(nm)) {
								dsu.merge(m, nm);
							}
						}
					});
				} else {
					int ra = scanner.nextInt() - 1, ca = scanner.nextInt() - 1;
					int rb = scanner.nextInt() - 1, cb = scanner.nextInt() - 1;
					int ma = (ra * w) + ca, mb = (rb * w) + cb;
					sb.append((bitSet.get(ma) && bitSet.get(mb) && dsu.same(ma, mb)) ? "Yes" : "No")
							.append(System.lineSeparator());
				}
			});
			System.out.print(sb.toString());
			System.out.flush();
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
		/** グループの数 */
		@SuppressWarnings("unused")
		int groupNum;

		/**
		 * コンストラクター
		 *
		 * @param n 項目数
		 */
		DisjointSetUnion(int n) {
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
