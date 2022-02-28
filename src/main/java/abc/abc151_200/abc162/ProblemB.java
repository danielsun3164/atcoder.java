package abc.abc151_200.abc162;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(
					IntStream.rangeClosed(1, n).filter(i -> (0 != i % 3) && (0 != i % 5)).mapToLong(i -> i).sum());
		}
	}
}
