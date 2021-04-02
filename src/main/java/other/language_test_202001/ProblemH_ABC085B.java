package other.language_test_202001;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemH_ABC085B {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).map(i -> scanner.nextInt()).distinct().count());
		}
	}
}
