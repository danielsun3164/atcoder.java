package abc.abc101_150.abc128;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			Set<Integer>[] sets = new Set[m];
			IntStream.range(0, m).forEach(i -> {
				int k = scanner.nextInt();
				sets[i] = IntStream.range(0, k).map(j -> scanner.nextInt()).boxed().collect(Collectors.toSet());
			});
			int[] p = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			int[] counts = new int[m];
			System.out.println(IntStream.range(0, 1 << n).filter(i -> {
				Arrays.fill(counts, 0);
				IntStream.range(0, n).filter(j -> (i & (1 << j)) > 0).forEach(j -> {
					IntStream.range(0, m).forEach(k -> counts[k] += sets[k].contains(j + 1) ? 1 : 0);
				});
				return m == IntStream.range(0, m).filter(j -> p[j] == (1 & counts[j])).count();
			}).count());
		}
	}
}
