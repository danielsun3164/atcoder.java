package abc.abc201_250.abc214;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int s = scanner.nextInt(), t = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(0, s)
					.map(i -> IntStream.rangeClosed(0, s - i)
							.map(j -> (int) IntStream.rangeClosed(0, s - i - j).filter(k -> i * j * k <= t).count())
							.sum())
					.sum());
		}
	}
}
