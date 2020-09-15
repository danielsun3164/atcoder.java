package abc.abc093;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), k = scanner.nextInt();
			Set<Integer> set = new HashSet<>();
			IntStream.range(a, Math.min(a + k, b)).forEach(set::add);
			IntStream.rangeClosed(Math.max(b - k + 1, a), b).forEach(set::add);
			set.stream().sorted().forEach(System.out::println);
		}
	}
}
