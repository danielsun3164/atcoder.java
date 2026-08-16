package abc.abc201_250.abc240;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			int[] l = new int[n], r = new int[n];
			Arrays.fill(l, -1);
			Arrays.fill(r, -1);
			int result = 0;
			for (int i = 0; i < n; i++) {
				if (-1 == l[i]) {
					result = calc(edges, l, r, i, -1, result + 1);
				}
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, n).forEach(i -> sb.append(l[i] + " " + r[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * lとrの配列に再帰的に結果を記入する
	 *
	 * @param edges  辺の一覧
	 * @param l      結果のlの配列
	 * @param r      結果のrの配列
	 * @param now    現在処理中のノード
	 * @param prev   直前処理していたノード
	 * @param result lとrの配列に記入する値
	 * @return 記入後に記入すべき値
	 */
	private static int calc(List<Integer>[] edges, int[] l, int[] r, int now, int prev, int result) {
		l[now] = result;
		boolean first = true;
		for (Integer next : edges[now]) {
			if (next != prev) {
				result = calc(edges, l, r, next, now, first ? result : result + 1);
				if (first) {
					first = false;
				}
			}
		}
		return r[now] = result;
	}
}
