package abc.abc201_250.abc239;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc239/editorial/3385 の実装<br/>
 * https://atcoder.jp/contests/abc239/submissions/29474794 にも参考
 */
public class ProblemE {

	// TLE対策のため、すべての変数をメンバー変数で計算する
	/** 辺の一覧の配列 */
	private static List<Integer>[] edges;
	/** 各ノードの数値の配列 */
	private static int[] x;
	/** p */
	private static int[][] p;
	/** kの最大値 */
	private static int maxK;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			x = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			int[] v = new int[q], k = new int[q];
			maxK = IntStream.range(0, q).map(i -> {
				v[i] = scanner.nextInt() - 1;
				return k[i] = scanner.nextInt();
			}).max().getAsInt();
			p = new int[n][];
			calcP(0, -1);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q)
					.forEach(i -> sb.append(p[v[i]][p[v[i]].length - k[i]]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 各ノードのpを計算する
	 *
	 * @param now  現在計算中のノード
	 * @param prev 親ノード
	 */
	private static void calcP(int now, int prev) {
		Queue<Integer> que = new PriorityQueue<>();
		que.add(x[now]);
		for (int next : edges[now]) {
			if (prev != next) {
				calcP(next, now);
				for (int pi : p[next]) {
					que.add(pi);
					if (que.size() > maxK) {
						que.poll();
					}
				}
			}
		}
		p[now] = que.stream().mapToInt(Integer::intValue).sorted().toArray();
	}
}
