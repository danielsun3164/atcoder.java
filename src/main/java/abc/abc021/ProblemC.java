package abc.abc021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc021/submissions/5253485 を参考に作成
 */
public class ProblemC {

	private static final int MOD = 1_000_000_007;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = scanner.nextInt() - 1;
			int b = scanner.nextInt() - 1;
			int m = scanner.nextInt();
			// ノードとノードの間に辺があるかを定義する配列
			boolean hasEdges[][] = new boolean[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(hasEdges[i], false));
			IntStream.range(0, m).forEach(i -> {
				int from = scanner.nextInt() - 1;
				int to = scanner.nextInt() - 1;
				hasEdges[from][to] = hasEdges[to][from] = true;
			});
			// aから個々のノードへのルートの数の配列
			int[] output = new int[n];
			Arrays.fill(output, 0);
			// 起点の結果を記入
			output[a] = 1;
			// 各ノードがアクセス済かの配列
			boolean[] visited = new boolean[n];
			Arrays.fill(visited, false);
			visited[a] = true;
			// アクセスしたルートを保存するQueue
			Queue<Integer> queue = new ArrayDeque<>();
			queue.add(a);
			while (true) {
				IntStream.range(0, queue.size()).forEach(i -> {
					IntStream.range(0, n).filter(j -> (hasEdges[queue.peek()][j] && !visited[j]))
							.forEach(j -> output[j] = (output[j] + output[queue.peek()]) % MOD);
					queue.remove();
				});
				IntStream.range(0, n).filter(i -> (output[i] != 0 && !visited[i])).forEach(i -> {
					queue.add(i);
					visited[i] = true;
				});
				if (visited[b]) {
					System.out.println(output[b]);
					return;
				}
			}
		}
	}
}
