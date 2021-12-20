package abc.abc151_200.abc153;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), n = scanner.nextInt();
			System.out.println((h > IntStream.range(0, n).map(i -> scanner.nextInt()).sum()) ? "No" : "Yes");
		}
	}
}
