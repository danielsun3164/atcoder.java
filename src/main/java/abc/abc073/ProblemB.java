package abc.abc073;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).map(i -> {
				int l = scanner.nextInt(), r = scanner.nextInt();
				return r - l + 1;
			}).sum());
		}
	}
}
