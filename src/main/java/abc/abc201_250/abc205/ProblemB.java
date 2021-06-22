package abc.abc201_250.abc205;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			TreeSet<Integer> set = new TreeSet<>();
			IntStream.range(0, n).forEach(i -> set.add(scanner.nextInt()));
			System.out.println(((1 == set.first()) && (n == set.last()) && (n == set.size())) ? "Yes" : "No");
		}
	}
}
