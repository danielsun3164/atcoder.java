package abc.abc201_250.abc216;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(
					(n == IntStream.range(0, n).mapToObj(i -> scanner.next() + " " + scanner.next()).distinct().count())
							? "No"
							: "Yes");
		}
	}
}
