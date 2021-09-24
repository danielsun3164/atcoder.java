package abc.abc151_200.abc151;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt(), m = scanner.nextInt();
			int diff = Math.max(0, n * m - IntStream.range(0, n - 1).map(i -> scanner.nextInt()).sum());
			System.out.println((diff > k) ? -1 : diff);
		}
	}
}
