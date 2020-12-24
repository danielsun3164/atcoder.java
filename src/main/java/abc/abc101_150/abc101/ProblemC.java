package abc.abc101_150.abc101;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			IntStream.range(0, n).forEach(i -> scanner.nextInt());
			// ceiling((n-1)/(k-1))
			System.out.println((n - 1 + k - 1 - 1) / (k - 1));
		}
	}
}
