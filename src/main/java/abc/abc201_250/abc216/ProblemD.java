package abc.abc201_250.abc216;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Map<Integer, List<Queue<Integer>>> map = new HashMap<>();
			Queue<Integer> que = new ArrayDeque<>();
			int[] count = new int[n];
			Arrays.fill(count, 0);
			IntStream.range(0, m).forEach(i -> {
				int k = scanner.nextInt();
				Queue<Integer> q = new ArrayDeque<>();
				IntStream.range(0, k).forEach(j -> q.add(scanner.nextInt() - 1));
				int first = q.peek();
				count[first]++;
				if (count[first] >= 2) {
					que.add(first);
				}
				List<Queue<Integer>> list = map.get(first);
				if (null == list) {
					list = new ArrayList<>();
					map.put(first, list);
				}
				list.add(q);
			});
			while (!que.isEmpty()) {
				int now = que.poll();
				List<Queue<Integer>> nList = map.get(now);
				for (Queue<Integer> q : nList) {
					q.poll();
					if (!q.isEmpty()) {
						int first = q.peek();
						count[first]++;
						if (count[first] >= 2) {
							que.add(first);
						}
						List<Queue<Integer>> list = map.get(first);
						if (null == list) {
							list = new ArrayList<>();
							map.put(first, list);
						}
						list.add(q);
					}
				}
				map.remove(now);
			}
			System.out.println(map.isEmpty() ? "Yes" : "No");
		}
	}
}
