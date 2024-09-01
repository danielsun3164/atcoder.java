package abc.abc201_250.abc224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc224/editorial/2814 の実装
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int h = scanner.nextInt(), w = scanner.nextInt(), n = scanner.nextInt();
			int[] r = new int[n], c = new int[n], a = new int[n];
			NavigableMap<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
			IntStream.range(0, n).forEach(i -> {
				r[i] = scanner.nextInt();
				c[i] = scanner.nextInt();
				a[i] = scanner.nextInt();
				if (!map.containsKey(a[i])) {
					map.put(a[i], new ArrayList<>());
				}
				map.get(a[i]).add(i);
			});
			int[] dp = new int[n];
			Map<Integer, Integer> rMax = new HashMap<>(), cMax = new HashMap<>();
			map.entrySet().forEach(entry -> {
				entry.getValue().forEach(i -> dp[i] = Math.max(rMax.getOrDefault(r[i], 0), cMax.getOrDefault(c[i], 0)));
				entry.getValue().forEach(i -> {
					rMax.put(r[i], Math.max(rMax.getOrDefault(r[i], 0), dp[i] + 1));
					cMax.put(c[i], Math.max(cMax.getOrDefault(c[i], 0), dp[i] + 1));
				});
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(dp).forEach(dpi -> sb.append(dpi).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
