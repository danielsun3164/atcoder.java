package abc.abc151_200.abc199;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int maxA = IntStream.range(0, n).map(i -> scanner.nextInt()).max().getAsInt();
			int minB = IntStream.range(0, n).map(i -> scanner.nextInt()).min().getAsInt();
			System.out.println(Math.max(0, (minB - maxA) + 1));
		}
	}
}
