package abc.abc101_150.abc102;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			NavigableSet<Integer> set = new TreeSet<>();
			IntStream.range(0, n).forEach(i -> set.add(scanner.nextInt()));
			System.out.println(set.last() - set.first());
		}
	}
}
