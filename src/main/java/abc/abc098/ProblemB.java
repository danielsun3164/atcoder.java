package abc.abc098;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			System.out.println(IntStream.range(1, n).map(i -> {
				Set<Integer> leftSet = IntStream.range(0, i).map(j -> s[j]).boxed().collect(Collectors.toSet());
				Set<Integer> rightSet = IntStream.range(i, n).map(j -> s[j]).boxed().collect(Collectors.toSet());
				leftSet.retainAll(rightSet);
				return leftSet.size();
			}).max().getAsInt());
		}
	}
}
