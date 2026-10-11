package abc.abc201_250.abc244;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			NavigableSet<Integer> set = IntStream.rangeClosed(1, (n << 1) | 1).boxed()
					.collect(Collectors.toCollection(TreeSet::new));
			System.out.println(set.pollFirst());
			while (!set.isEmpty()) {
				set.remove(scanner.nextInt());
				System.out.println(set.pollFirst());
			}
		}
	}
}
