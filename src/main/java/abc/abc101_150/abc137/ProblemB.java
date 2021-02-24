package abc.abc101_150.abc137;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt(), x = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(x - k + 1, x + k - 1).mapToObj(String::valueOf)
					.collect(Collectors.joining(" ")));
		}
	}
}
