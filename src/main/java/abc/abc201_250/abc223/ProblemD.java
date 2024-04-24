package abc.abc201_250.abc223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			int[] counts = new int[n];
			Arrays.fill(counts, 0);
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				counts[b]++;
			});
			Map<Integer, NavigableSet<Integer>> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				if (!map.containsKey(counts[i])) {
					map.put(counts[i], new TreeSet<>());
				}
				map.get(counts[i]).add(i);
			});
			int[] answers = new int[n];
			int index = 0;
			while (map.containsKey(0) && !map.get(0).isEmpty()) {
				int now = map.get(0).pollFirst();
				answers[index++] = now + 1;
				process(now, edges, counts, map);
			}
			if (n == index) {
				System.out.println(Arrays.stream(answers).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
			} else {
				System.out.println(-1);
			}
		}
	}

	/**
	 * 現在処理している数字の関連データを更新する
	 *
	 * @param now    現在処理している数字
	 * @param edges  数字の前後関係の一覧
	 * @param counts 数字の前提数字の数
	 * @param map    前提数字の数と数字の一覧のマップ
	 */
	private static void process(int now, List<Integer>[] edges, int[] counts, Map<Integer, NavigableSet<Integer>> map) {
		for (int next : edges[now]) {
			map.get(counts[next]--).remove(next);
			if (!map.containsKey(counts[next])) {
				map.put(counts[next], new TreeSet<>());
			}
			map.get(counts[next]).add(next);
		}
	}
}
