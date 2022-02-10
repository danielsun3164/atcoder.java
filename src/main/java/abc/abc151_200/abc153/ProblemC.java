package abc.abc151_200.abc153;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			System.out.println(
					IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).sorted().limit(Math.max(n - k, 0)).sum());
		}
	}
}
