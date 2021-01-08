package abc.abc151_200.abc187;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			Set<String>[] sets = new Set[2];
			IntStream.range(0, 2).forEach(i -> sets[i] = new HashSet<>());
			IntStream.range(0, n).forEach(i -> {
				String s = scanner.next();
				if ('!' == s.charAt(0) && s.length() > 1) {
					sets[1].add(s.substring(1));
				} else {
					sets[0].add(s);
				}
			});
			sets[0].retainAll(sets[1]);
			System.out.println(sets[0].stream().findFirst().orElse("satisfiable"));
		}
	}
}
