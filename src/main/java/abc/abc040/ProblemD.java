package abc.abc040;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			Route[] routes = new Route[m];
			IntStream.range(0, m).forEach(
					i -> routes[i] = new Route(scanner.nextInt() - 1, scanner.nextInt() - 1, scanner.nextInt()));
			Arrays.sort(routes);
			int q = scanner.nextInt();
			Question[] questions = new Question[q];
			int[] answers = new int[q];
			IntStream.range(0, q)
					.forEach(i -> questions[i] = new Question(scanner.nextInt() - 1, scanner.nextInt(), i));
			Arrays.sort(questions, (x, y) -> y.w - x.w);
			UnionFindTree uft = new UnionFindTree(n);
			int routeIndex = 0;
			for (Question question : questions) {
				while (question.w < routes[routeIndex].y) {
					uft.union(routes[routeIndex].a, routes[routeIndex].b);
					if (routeIndex < m - 1) {
						routeIndex++;
					} else {
						break;
					}
				}
				answers[question.no] = uft.count(question.v);
			}
			Arrays.stream(answers).forEach(System.out::println);
		}
	}

	/**
	 * 道路を表すクラス
	 */
	private static class Route implements Comparable<Route> {
		/** 始点の都市 */
		int a;
		/** 終点の都市 */
		int b;
		/** 道路の建造年数 */
		int y;

		Route(int a, int b, int y) {
			super();
			this.a = a;
			this.b = b;
			this.y = y;
		}

		@Override
		public int compareTo(Route o) {
			return o.y - this.y;
		}
	}

	/**
	 * 問題を表すクラス
	 */
	private static class Question {
		/** 開始都市 */
		int v;
		/** 最低限製造年数-1 */
		int w;
		/** No. */
		int no;

		Question(int v, int w, int no) {
			super();
			this.v = v;
			this.w = w;
			this.no = no;
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
