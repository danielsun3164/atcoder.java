package abc029;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	private static final int SIZE = 12;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(
					IntStream.range(0, SIZE).mapToObj(i -> scanner.nextLine()).filter(s -> s.contains("r")).count());
		}
	}
}
