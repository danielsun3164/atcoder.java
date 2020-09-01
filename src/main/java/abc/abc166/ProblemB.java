package abc.abc166;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			Set<Integer> set = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toSet());
			IntStream.range(0, k).forEach(i -> {
				int d = scanner.nextInt();
				IntStream.range(0, d).forEach(j -> set.remove(scanner.nextInt()));
			});
			System.out.println(set.size());
		}
	}
}
