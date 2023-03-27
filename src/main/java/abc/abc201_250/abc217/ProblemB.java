package abc.abc201_250.abc217;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemB {

	/** 入力可能単語 */
	private static final Set<String> DICTIONARY = Set.of("ABC", "ARC", "AGC", "AHC");
	/** 入力単語数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			NavigableSet<String> set = new TreeSet<>(DICTIONARY);
			IntStream.range(0, N).forEach(i -> set.remove(scanner.next()));
			System.out.println(set.first());
		}
	}
}
