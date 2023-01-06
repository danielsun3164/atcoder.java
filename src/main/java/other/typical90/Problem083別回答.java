package other.typical90;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://github.com/E869120/kyopro_educational_90/blob/main/sol/083-02b.cpp をもとに作成
 */
public class Problem083別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			Set<Integer>[] edges = new Set[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new HashSet<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			int q = scanner.nextInt();
			int[] x = new int[q], y = new int[q];
			IntStream.range(0, q).forEach(i -> {
				x[i] = scanner.nextInt() - 1;
				y[i] = scanner.nextInt();
			});
			int b = (int) Math.sqrt(q);
			int[] colors = new int[n], indexes = new int[n];
			Arrays.fill(colors, 1);
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, b).forEach(i -> {
				int ql = i * q / b, qr = (i + 1) * q / b;
				IntStream.range(ql, qr).forEach(j -> {
					int currentColor = colors[x[j]];
					for (int k = j - 1; k >= ql; k--) {
						if (x[j] == x[k] || edges[x[k]].contains(x[j])) {
							currentColor = y[k];
							break;
						}
					}
					sb.append(currentColor).append(System.lineSeparator());
				});
				IntStream.range(ql, qr).forEach(j -> indexes[x[j]] = j);
				IntStream.range(ql, qr).filter(j -> j == indexes[x[j]]).forEach(j -> {
					colors[x[j]] = y[j];
					edges[x[j]].forEach(k -> colors[k] = y[j]);
				});
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
