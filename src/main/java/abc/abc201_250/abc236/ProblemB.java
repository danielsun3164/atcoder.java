package abc.abc201_250.abc236;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(
					n * (n + 1L) * 2L - IntStream.range(0, 4 * n - 1).mapToLong(i -> scanner.nextLong()).sum());
		}
	}
}
