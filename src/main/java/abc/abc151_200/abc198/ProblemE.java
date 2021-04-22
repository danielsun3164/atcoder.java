package abc.abc151_200.abc198;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] c = new int[n];
			int maxC = IntStream.range(0, n).map(i -> c[i] = scanner.nextInt()).max().getAsInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			int[] cCounts = new int[maxC + 1];
			Arrays.fill(cCounts, 0);
			boolean[] ok = new boolean[n], visited = new boolean[n];
			Arrays.fill(ok, false);
			Arrays.fill(visited, false);
			process(0, c, edges, cCounts, ok, visited);
			IntStream.rangeClosed(1, n).filter(i -> ok[i - 1]).forEach(System.out::println);
		}
	}

	/**
	 * 各頂点が条件に満たしているかどうかを計算する
	 *
	 * @param now     現在処理中の頂点
	 * @param c       色の配列
	 * @param edges   各頂点の次に接続する頂点の一覧の配列
	 * @param cCounts 現在の頂点まで各色の出現回数の配列
	 * @param ok      各頂点が条件に満たしているかどうかの配列
	 * @param visited 各頂点が処理済かどうかの配列
	 */
	private static void process(int now, int[] c, List<Integer>[] edges, int[] cCounts, boolean[] ok,
			boolean[] visited) {
		if (0 == cCounts[c[now]]) {
			ok[now] = true;
		}
		cCounts[c[now]]++;
		visited[now] = true;
		for (int next : edges[now]) {
			if (!visited[next]) {
				process(next, c, edges, cCounts, ok, visited);
			}
		}
		cCounts[c[now]]--;
	}
}
