package abc.abc101_150.abc140;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] b = IntStream.range(0, n - 1).map(i -> scanner.nextInt()).toArray();
			System.out.println(b[0] + IntStream.range(0, n - 2).map(i -> Math.min(b[i], b[i + 1])).sum() + b[n - 2]);
		}
	}
}
