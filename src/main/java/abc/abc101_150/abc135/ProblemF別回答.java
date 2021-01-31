package abc.abc101_150.abc135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * Z algorithmでの実装
 * 
 * https://atcoder.jp/contests/abc135/submissions/6590451 にも参考
 */
public class ProblemF別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			int n = (t.length + s.length - 1) / s.length * s.length;
			// newSの後半の判定のため、計算用の長さを2倍にする
			char[] newS = new char[2 * n + t.length];
			System.arraycopy(t, 0, newS, 0, t.length);
			for (int i = 0; i < 2 * n; i += s.length) {
				System.arraycopy(s, 0, newS, i + t.length, s.length);
			}
			BitSet match = zAlgorithm(newS, t.length);
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
	 * Z Algorithmでsとtの一致性を計算する
	 * 
	 * @param s       tとsの文字列の結合
	 * @param tLength tの長さ
	 * @return sのi文字目から i + |t| − 1 文字目までの部分文字列がtと一致するか否かのbitset
	 */
	private static BitSet zAlgorithm(char[] s, int tLength) {
		int n = s.length;
		int[] r = new int[n];
		r[0] = n;
		int i = 1, j = 0;
		while (i < n) {
			while ((i + j < n) && (s[j] == s[i + j])) {
				j++;
			}
			r[i] = j;
			if (0 == j) {
				i++;
				continue;
			}
			int k = 1;
			while ((i + k < n) && (k + r[k] < j)) {
				r[i + k] = r[k];
				k++;
			}
			i += k;
			j -= k;
		}
		BitSet bitSet = new BitSet(n - tLength);
		IntStream.range(0, n - tLength).forEach(k -> bitSet.set(k, r[k + tLength] >= tLength));
		return bitSet;
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
