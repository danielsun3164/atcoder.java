package abc.abc181;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).mapToLong(i -> {
				long a = scanner.nextLong(), b = scanner.nextLong();
				return (a + b) * (b - a + 1) / 2;
			}).sum());
		}
	}
}
