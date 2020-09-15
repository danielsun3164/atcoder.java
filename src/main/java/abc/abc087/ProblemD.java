package abc.abc087;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc087/submissions/5890910 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			UnionFind uf = new UnionFind(n);
			boolean result = true;
			for (int i = 0; i < m; i++) {
				int l = scanner.nextInt() - 1, r = scanner.nextInt() - 1, d = scanner.nextInt();
				if (uf.same(l, r)) {
					if (uf.diff(l, r) != d) {
						result = false;
						break;
					}
				} else {
					uf.unite(l, r, d);
				}
			}
			System.out.println(result ? "Yes" : "No");
		}
	}

	/**
	 * Union Findの実装<br/>
	 * https://atcoder.jp/contests/abc087/submissions/5890910 を参考に作成
	 */
	private static class UnionFind {
		int[] par;
		int[] rank;
		int[] diff_weight;

		UnionFind(int n) {
			par = new int[n];
			rank = new int[n];
			diff_weight = new int[n];
			IntStream.range(0, n).forEach(i -> {
				par[i] = i;
				rank[i] = 0;
				diff_weight[i] = 0;
			});
		}

		int find(int x) {
			if (par[x] == x) {
				return x;
			}
			int r = find(par[x]);
			diff_weight[x] += diff_weight[par[x]];
			return par[x] = r;
		}

		int weight(int x) {
			find(x);
			return diff_weight[x];
		}

		boolean same(int x, int y) {
			return find(x) == find(y);
		}

		void unite(int x, int y, int w) {
			w += weight(x);
			w -= weight(y);
			x = find(x);
			y = find(y);
			if (x == y)
				return;
			if (rank[x] < rank[y]) {
				int tmp = x;
				x = y;
				y = tmp;
				w -= w;
			}
			par[y] = x;
			diff_weight[y] = w;
			return;
		}

		int diff(int x, int y) {
			return weight(y) - weight(x);
		}
	}
}
