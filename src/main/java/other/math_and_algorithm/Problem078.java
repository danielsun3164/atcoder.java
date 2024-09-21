package other.math_and_algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem078 {

	/** 年齢の最大値 */
	private static final int MAX = 120;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			int[] dist = new int[n];
			Arrays.fill(dist, -1);
			dist[0] = 0;
			Queue<Integer> que = new ArrayDeque<>();
			que.add(0);
			while (!que.isEmpty()) {
				int now = que.poll();
				edges[now].stream().filter(next -> dist[next] < 0).forEach(next -> {
					dist[next] = Math.min(MAX, dist[now] + 1);
					que.add(next);
				});
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(dist).forEach(di -> sb.append((-1 == di) ? MAX : di).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
