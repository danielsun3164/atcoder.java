package abc.abc201_250.abc220;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	// TLE対応のため、メソッド呼び出し用の変数をstaticメンバー変数にする
	private static int n;
	private static int[] dis, sub;
	private static int[][] edges;
	private static long[] answers;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			n = scanner.nextInt();
			calcEdges(scanner);
			dis = new int[n];
			sub = new int[n];
			Arrays.fill(dis, 0);
			Arrays.fill(sub, 1);
			dfs(0, 0);
			answers = new long[n];
			answers[0] = Arrays.stream(dis).asLongStream().sum();
			dfs2(0, 0);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answers).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 辺の配列を計算する<br/>
	 * TLE対応のため、辺はList<Integer>[]ではなく、int[][]にする
	 *
	 * @param scanner
	 */
	private static void calcEdges(Scanner scanner) {
		int[] u = new int[n - 1], v = new int[n - 1], counts = new int[n];
		Arrays.fill(counts, 0);
		IntStream.range(0, n - 1).forEach(i -> {
			u[i] = scanner.nextInt() - 1;
			v[i] = scanner.nextInt() - 1;
			counts[u[i]]++;
			counts[v[i]]++;
		});
		edges = new int[n][];
		IntStream.range(0, n).forEach(i -> edges[i] = new int[counts[i]]);
		IntStream.range(0, n - 1).forEach(i -> {
			edges[u[i]][--counts[u[i]]] = v[i];
			edges[v[i]][--counts[v[i]]] = u[i];
		});
	}

	/**
	 * 各ノードの深さとノード以下のノード数を計算する
	 *
	 * @param now  現在計算中のノード
	 * @param prev 直前に計算したノード
	 */
	private static void dfs(int now, int prev) {
		for (int next : edges[now]) {
			if (next != prev) {
				dis[next] = dis[now] + 1;
				dfs(next, now);
				sub[now] += sub[next];
			}
		}
	}

	/**
	 * 各ノードの結果を計算する
	 *
	 * @param now  現在計算中のノード
	 * @param prev 直前に計算したノード
	 */
	private static void dfs2(int now, int prev) {
		for (int next : edges[now]) {
			if (next != prev) {
				answers[next] = answers[now] - 2 * sub[next] + n;
				dfs2(next, now);
			}
		}
	}
}
