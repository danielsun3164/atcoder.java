package abc.abc177;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			UnionFindTree uft = new UnionFindTree(n);
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				uft.union(a, b);
			});
			// Union Fid Treeでグルーピングしたグループの要素数の最大値
			System.out.println(IntStream.range(0, n).map(i -> uft.count(i)).max().getAsInt());
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
			parent = new int[size];
			IntStream.range(0, size).forEach(i -> parent[i] = i);
			count = new int[size];
			Arrays.fill(count, 1);
		}

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
		@SuppressWarnings("unused")
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
