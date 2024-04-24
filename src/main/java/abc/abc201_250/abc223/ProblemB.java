package abc.abc201_250.abc223;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			NavigableSet<String> set = IntStream.range(0, s.length()).mapToObj(i -> s.substring(i) + s.substring(0, i))
					.collect(Collectors.toCollection(TreeSet::new));
			System.out.println(set.first());
			System.out.println(set.last());
		}
	}
}
