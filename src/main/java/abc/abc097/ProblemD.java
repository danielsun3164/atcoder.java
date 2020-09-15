package abc.abc097;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc097/submissions/14902578 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] q = new int[n];
			IntStream.range(0, n).forEach(i -> q[scanner.nextInt() - 1] = i);
			UnionFindTree uft = new UnionFindTree(n);
			IntStream.range(0, m).forEach(i -> uft.union(scanner.nextInt() - 1, scanner.nextInt() - 1));
			System.out.println(IntStream.range(0, n).filter(i -> uft.same(q[i], i)).count());
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
		@SuppressWarnings("unused")
		public int count(int x) {
			return count[find(x)];
		}
	}
}
