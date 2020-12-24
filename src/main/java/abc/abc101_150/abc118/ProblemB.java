package abc.abc101_150.abc118;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt(), m = scanner.nextInt();
			Set<Integer> commonSet = new HashSet<>();
			IntStream.range(0, n).forEach(i -> {
				int k = scanner.nextInt();
				Set<Integer> set = IntStream.range(0, k).map(j -> scanner.nextInt()).boxed()
						.collect(Collectors.toSet());
				if (0 == i) {
					commonSet.addAll(set);
				} else {
					commonSet.retainAll(set);
				}
			});
			System.out.println(commonSet.size());
		}
	}
}
