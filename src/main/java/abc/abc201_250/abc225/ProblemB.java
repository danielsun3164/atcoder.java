package abc.abc201_250.abc225;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			NavigableSet<Integer> set = IntStream.range(0, n).map(i -> edges[i].size()).boxed()
					.collect(Collectors.toCollection(TreeSet::new));
			System.out.println(((2 == set.size()) && set.first().equals(1) && set.last().equals(n - 1)) ? "Yes" : "No");
		}
	}
}
