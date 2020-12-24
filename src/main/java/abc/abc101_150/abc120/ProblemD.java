package abc.abc101_150.abc120;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[] result = new long[m];
			result[m - 1] = n * (long) (n - 1) / 2;
			int[] a = new int[m], b = new int[m];
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
			});
			UnionFindTree uft = new UnionFindTree(n);
			IntStream.range(1, m).map(i -> m - i).forEach(i -> {
				if (uft.same(a[i], b[i])) {
					result[i - 1] = result[i];
				} else {
					result[i - 1] = result[i] - uft.count(a[i]) * uft.count(b[i]);
					uft.union(a[i], b[i]);
				}
			});
			Arrays.stream(result).forEach(System.out::println);
		}
	}

	/**
	 * Union Find Treeの実装<br/>
	 * https://atcoder.jp/contests/abc040/submissions/4708654 を参考に作成
	 */
	private static class UnionFindTree {
		int[] parent;
		int[] count;

		UnionFindTree(int size) {
			parent = IntStream.range(0, size).toArray();
			count = new int[size];
			Arrays.fill(count, 1);
		}

		/**
		 * @param x
		 * @return xのroot
		 */
		int find(int x) {
			if (parent[x] == x) {
				return x;
			} else {
				int v = find(parent[x]);
				parent[x] = v;
				return v;
			}
		}

		/**
		 * @param x
		 * @param y
		 * @return xとyがつながっているかどうか
		 */
		boolean same(int x, int y) {
			return find(x) == find(y);
		}

		/**
		 * xとyを結合する
		 * 
		 * @param x
		 * @param y
		 */
		void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX == rootY) {
				return;
			}
			parent[rootX] = rootY;
			parent[x] = rootY;
			count[rootY] += count[rootX];
		}

		/**
		 * @param x
		 * @return xと結ぶ都市の数
		 */
		public int count(int x) {
			return count[find(x)];
		}
	}
}
