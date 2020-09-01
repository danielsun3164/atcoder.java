package abc.abc059;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemA {

	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(IntStream.range(0, N).mapToObj(i -> scanner.next().substring(0, 1).toUpperCase())
					.collect(Collectors.joining()));
		}
	}
}
