package other.typical90;

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
public class Problem062 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			boolean[] usable = new boolean[n];
			Arrays.fill(usable, false);
			Queue<Integer> que = new ArrayDeque<>();
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(i);
				edges[b].add(i);
				if ((a == i) || (b == i)) {
					usable[i] = true;
					que.add(i);
				}
			});
			List<Integer> answer = new ArrayList<>();
			while (!que.isEmpty()) {
				int now = que.poll();
				answer.add(now + 1);
				for (int next : edges[now]) {
					if (!usable[next]) {
						usable[next] = true;
						que.add(next);
					}
				}
			}
			if (answer.size() != n) {
				System.out.println(-1);
			} else {
				// TLE対策のため、結果をStringBuilderに入れる
				StringBuilder sb = new StringBuilder();
				IntStream.range(0, n).map(i -> n - 1 - i)
						.forEach(i -> sb.append(answer.get(i)).append(System.lineSeparator()));
				System.out.print(sb.toString());
				System.out.flush();
			}
		}
	}
}
