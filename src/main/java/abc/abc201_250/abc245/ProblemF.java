package abc.abc201_250.abc245;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc245/editorial/3652 の実装
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			int[] out = new int[n];
			Arrays.fill(out, 0);
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[v].add(u);
				out[u]++;
			});
			Queue<Integer> que = new ArrayDeque<>();
			IntStream.range(0, n).filter(i -> 0 == out[i]).forEach(i -> que.add(i));
			int answer = n;
			while (!que.isEmpty()) {
				int now = que.poll();
				answer--;
				for (int prev : edges[now]) {
					out[prev]--;
					if (0 == out[prev]) {
						que.add(prev);
					}
				}
			}
			System.out.println(answer);
		}
	}
}
