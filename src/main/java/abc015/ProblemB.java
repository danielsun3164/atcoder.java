package abc015;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((int) Math.ceil(
					IntStream.range(0, n).map(i -> scanner.nextInt()).filter(i -> (0 != i)).average().getAsDouble()));
		}
	}
}
