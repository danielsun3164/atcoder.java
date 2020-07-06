package abc166;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] h = new int[n];
			IntStream.range(0, n).forEach(i -> h[i] = scanner.nextInt());
			Set<Integer> set = IntStream.range(0, n).boxed().collect(Collectors.toSet());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				if (h[a] < h[b]) {
					set.remove(a);
				} else if (h[a] > h[b]) {
					set.remove(b);
				} else {
					// h[a]==h[b]
					set.remove(a);
					set.remove(b);
				}
			});
			System.out.println(set.size());
		}
	}
}
