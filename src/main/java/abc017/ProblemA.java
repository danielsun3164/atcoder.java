package abc017;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(IntStream.range(0, 3).map(i -> scanner.nextInt() / 10 * scanner.nextInt()).sum());
		}
	}
}
