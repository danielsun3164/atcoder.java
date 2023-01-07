package other.typical90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://github.com/E869120/kyopro_educational_90/blob/main/sol/083-02a.cpp をもとに作成
 */
public class Problem083 {

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
			int q = scanner.nextInt();
			int[] x = new int[q + 1], y = new int[q + 1];
			x[0] = y[0] = 1;
			IntStream.rangeClosed(1, q).forEach(i -> {
				x[i] = scanner.nextInt() - 1;
				y[i] = scanner.nextInt();
			});
			int b = (int) Math.sqrt(m << 1);
			Set<Integer> largeSet = new HashSet<>();
			@SuppressWarnings("unchecked")
			Set<Integer>[] largeEdges = new Set[n];
			IntStream.range(0, n).forEach(i -> largeEdges[i] = new HashSet<>());
			IntStream.range(0, n).forEach(i -> {
				if (edges[i].size() >= b) {
					largeSet.add(i);
					largeEdges[i].add(i);
					for (int next : edges[i]) {
						largeEdges[next].add(i);
					}
				}
			});
			int[] colors = new int[n], e = new int[n], eLarge = new int[n];
			Arrays.fill(colors, 1);
			Arrays.fill(e, 0);
			Arrays.fill(eLarge, 0);
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(1, q).forEach(i -> {
				sb.append(y[Math.max(e[x[i]], largeEdges[x[i]].stream().mapToInt(j -> eLarge[j]).max().orElse(0))])
						.append(System.lineSeparator());
				if (edges[x[i]].size() < b) {
					e[x[i]] = i;
					edges[x[i]].forEach(j -> e[j] = i);
				} else {
					eLarge[x[i]] = i;
				}
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
