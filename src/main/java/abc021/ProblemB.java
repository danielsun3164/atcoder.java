package abc021;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// n
			scanner.nextInt();
			Set<Integer> set = new HashSet<>();
			// a
			set.add(scanner.nextInt());
			// b
			set.add(scanner.nextInt());
			int k = scanner.nextInt();
			IntStream.range(0, k).forEach(i -> set.add(scanner.nextInt()));
			System.out.println((set.size() == k + 2) ? "YES" : "NO");
		}
	}
}
