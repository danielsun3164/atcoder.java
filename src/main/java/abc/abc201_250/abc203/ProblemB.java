package abc.abc201_250.abc203;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(1, n)
					.map(i -> IntStream.rangeClosed(1, k).map(j -> (100 * i) + j).sum()).sum());
		}
	}
}
