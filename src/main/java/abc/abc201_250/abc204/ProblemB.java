package abc.abc201_250.abc204;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).map(i -> Math.max(0, scanner.nextInt() - 10)).sum());
		}
	}
}
