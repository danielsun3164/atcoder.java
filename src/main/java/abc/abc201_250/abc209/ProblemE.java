package abc.abc201_250.abc209;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String[] s = IntStream.range(0, n).mapToObj(i -> scanner.next()).toArray(String[]::new);
			Map<String, Set<Integer>> map = new HashMap<>(), preMap = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				String key = s[i].substring(0, 3);
				Set<Integer> set = map.get(key);
				if (null == set) {
					set = new HashSet<>();
					map.put(key, set);
				}
				set.add(i);
				key = s[i].substring(s[i].length() - 3);
				set = preMap.get(key);
				if (null == set) {
					set = new HashSet<>();
					preMap.put(key, set);
				}
				set.add(i);
			});
			@SuppressWarnings("unchecked")
			Set<Integer>[] edges = new Set[n], preEdges = new Set[n];
			IntStream.range(0, n).forEach(i -> {
				edges[i] = map.getOrDefault(s[i].substring(s[i].length() - 3), new HashSet<>());
				preEdges[i] = preMap.getOrDefault(s[i].substring(0, 3), new HashSet<>());
			});
			int[] result = new int[n];
			Arrays.fill(result, -1);
			Queue<Integer> que = new ArrayDeque<>();
			int[] cnt = IntStream.range(0, n).map(i -> edges[i].size()).toArray();
			IntStream.range(0, n).filter(i -> 0 == cnt[i]).forEach(i -> {
				result[i] = 1;
				que.add(i);
			});
			while (!que.isEmpty()) {
				int now = que.poll();
				for (int prev : preEdges[now]) {
					if (-1 == result[prev]) {
						cnt[prev]--;
						if (1 == result[now]) {
							result[prev] = 2;
							que.add(prev);
						} else if (0 == cnt[prev]) {
							result[prev] = 1;
							que.add(prev);
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, n)
					.forEach(i -> sb.append((1 == result[i]) ? "Takahashi" : ((2 == result[i]) ? "Aoki" : "Draw"))
							.append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
