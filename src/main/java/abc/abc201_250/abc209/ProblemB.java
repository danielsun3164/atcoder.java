package abc.abc201_250.abc209;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt();
			int sum = IntStream.range(0, n).map(i -> scanner.nextInt()).sum();
			System.out.println(((x + n / 2) >= sum) ? "Yes" : "No");
		}
	}
}
