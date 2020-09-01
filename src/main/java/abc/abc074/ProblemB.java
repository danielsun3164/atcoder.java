package abc.abc074;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			System.out.println(IntStream.range(0, n).map(i -> {
				int x = scanner.nextInt();
				return Math.min(x, k - x) * 2;
			}).sum());
		}
	}
}
