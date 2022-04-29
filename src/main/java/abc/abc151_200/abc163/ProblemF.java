package abc.abc151_200.abc163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc163/submissions/12185855 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] c = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			long[] count = new long[n], answer = new long[n];
			Arrays.fill(count, 0L);
			Arrays.fill(answer, n * (long) (n + 1) / 2);
			dfs(c, edges, count, answer, 0, -1);
			IntStream.range(0, n).filter(i -> i != c[0]).forEach(i -> {
				long k = n - count[i];
				answer[i] -= k * (k + 1) / 2;
			});
			// Arrays.stream(c).forEach(ci -> answer[ci]++);
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 各色の結果を再帰的に計算する
	 *
	 * @param c      各ノードの色の配列
	 * @param edges  辺の一覧の配列
	 * @param count  各色のノードをを含む子供の数の配列
	 * @param answer 結果の配列
	 * @param now    現在処理されているノード
	 * @param prev   直前処理されたノード
	 * @return 現在のノードを含む子供数
	 */
	private static long dfs(int[] c, List<Integer>[] edges, long[] count, long[] answer, int now, int prev) {
		long size = 1, before = count[c[now]];
		for (int next : edges[now]) {
			if (prev != next) {
				long p = count[c[now]];
				// next以下のノード数を求める
				long d = dfs(c, edges, count, answer, next, now);
				size += d;
				// next以下の親の色がc[now]でないノードの総数
				long k = d - (count[c[now]] - p);
				answer[c[now]] -= k * (k + 1) / 2;
			}
		}
		count[c[now]] = before + size;
		return size;
	}
}
