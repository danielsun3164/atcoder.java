package abc.abc049;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通り実装したソースコード<br/>
 * http://baitop.hatenadiary.jp/entry/2018/06/26/224712 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int l = scanner.nextInt();
			UnionFindTree road = new UnionFindTree(n);
			IntStream.range(0, k).forEach(i -> road.unite(scanner.nextInt() - 1, scanner.nextInt() - 1));
			UnionFindTree railway = new UnionFindTree(n);
			IntStream.range(0, l).forEach(i -> railway.unite(scanner.nextInt() - 1, scanner.nextInt() - 1));
			Map<List<Integer>, Integer> map = new HashMap<>();
			@SuppressWarnings("unchecked")
			List<Integer>[] keys = new List[n];
			IntStream.range(0, n).forEach(i -> {
				keys[i] = Arrays.asList(road.root(i), railway.root(i));
				map.put(keys[i], map.getOrDefault(keys[i], 0) + 1);
			});
			System.out.println(
					IntStream.range(0, n).mapToObj(i -> map.get(keys[i]).toString()).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * Union Find Treeの実装<br/>
	 * http://baitop.hatenadiary.jp/entry/2018/06/26/224712 を参考に作成
	 */
	private static class UnionFindTree {
		int[] parent;
		int[] rank;
		int[] sizes;

		UnionFindTree(int n) {
			parent = new int[n];
			rank = new int[n];
			sizes = new int[n];
			Arrays.fill(rank, 0);
			IntStream.range(0, n).forEach(i -> {
				parent[i] = i;
				sizes[i] = 1;
			});
		}

		int root(int x) {
			if (parent[x] == x) {
				return x;
			} else {
				return parent[x] = root(parent[x]);
			}
		}

		void unite(int x, int y) {
			x = root(x);
			y = root(y);

			if (x == y) {
				return;
			} else if (rank[x] < rank[y]) {
				parent[x] = y;
				sizes[y] += sizes[x];
			} else {
				parent[y] = x;
				sizes[x] += sizes[y];
				if (rank[x] == rank[y]) {
					rank[x]++;
				}
			}
		}

		@SuppressWarnings("unused")
		boolean isSame(int x, int y) {
			return root(x) == root(y);
		}

		@SuppressWarnings("unused")
		int size(int x) {
			return sizes[parent[x]];
		}
	}
}
