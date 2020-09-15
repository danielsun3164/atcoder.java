package abc.abc087;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), x = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(0, a)
					.map(i -> (int) IntStream.rangeClosed(0, b)
							.filter(j -> (x >= (i * 500 + j * 100)) && (x <= (i * 500 + j * 100 + c * 50))).count())
					.sum());
		}
	}
}
