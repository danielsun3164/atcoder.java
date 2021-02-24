package abc.abc101_150.abc135;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(
					(IntStream.range(0, n).filter(i -> scanner.nextInt() != (i + 1)).count() <= 2) ? "YES" : "NO");
		}
	}
}
