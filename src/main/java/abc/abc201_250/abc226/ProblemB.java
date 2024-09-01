package abc.abc201_250.abc226;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Set<List<Integer>> set = new HashSet<>();
			IntStream.range(0, n).forEach(i -> {
				int l = scanner.nextInt();
				set.add(IntStream.range(0, l).map(j -> scanner.nextInt()).boxed().toList());
			});
			System.out.println(set.size());
		}
	}
}
