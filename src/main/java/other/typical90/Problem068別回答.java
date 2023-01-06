package other.typical90;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem068別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] t = new int[q], x = new int[q], y = new int[q];
			long[] v = new long[q];
			IntStream.range(0, q).forEach(i -> {
				t[i] = scanner.nextInt();
				x[i] = scanner.nextInt() - 1;
				y[i] = scanner.nextInt() - 1;
				v[i] = scanner.nextLong();
			});
			long[] sum = new long[n - 1];
			Arrays.fill(sum, 0L);
			IntStream.range(0, q).filter(i -> 0 == t[i]).forEach(i -> sum[x[i]] = v[i]);
			long[] pot = new long[n];
			Arrays.fill(pot, 0L);
			IntStream.range(0, n - 1).forEach(i -> pot[i + 1] = sum[i] - pot[i]);
			NavigableSet<Integer> set = IntStream.range(-1, n).boxed()
					.collect(Collectors.toCollection(() -> new TreeSet<>()));
			// TLE対応のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				if (0 == t[i]) {
					set.remove(x[i]);
				} else {
					int l = Math.min(x[i], y[i]), r = Math.max(x[i], y[i]);
					Integer lowerBound = set.ceiling(l);
					if (lowerBound > r - 1) {
						sb.append((0 == (1 & (r - l))) ? (pot[y[i]] + (v[i] - pot[x[i]]))
								: (pot[y[i]] - (v[i] - pot[x[i]])));
					} else {
						sb.append("Ambiguous");
					}
					sb.append(System.lineSeparator());
				}
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
