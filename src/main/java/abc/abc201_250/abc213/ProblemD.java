package abc.abc201_250.abc213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			Queue<Integer>[] childrens = new Queue[n];
			IntStream.range(0, n).forEach(i -> childrens[i] = new PriorityQueue<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				childrens[a].add(b);
				childrens[b].add(a);
			});
			boolean[] visited = new boolean[n];
			Arrays.fill(visited, false);
			List<Integer> answer = new ArrayList<>();
			int[] from = new int[n];
			int now = 0;
			visited[now] = true;
			answer.add(now);
			while (true) {
				int next = now;
				while (!childrens[now].isEmpty()) {
					next = childrens[now].poll();
					if (!visited[next]) {
						break;
					}
				}
				if (!visited[next]) {
					visited[next] = true;
					from[next] = now;
					now = next;
				} else {
					if (0 == now) {
						break;
					}
					now = from[now];
				}
				answer.add(now);
			}
			System.out.println(answer.stream().map(ai -> String.valueOf(ai + 1)).collect(Collectors.joining(" ")));
		}
	}
}
