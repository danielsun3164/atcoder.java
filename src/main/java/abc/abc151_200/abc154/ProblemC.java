package abc.abc151_200.abc154;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(
					(IntStream.range(0, n).map(i -> scanner.nextInt()).distinct().count() == n) ? "YES" : "NO");
		}
	}
}
