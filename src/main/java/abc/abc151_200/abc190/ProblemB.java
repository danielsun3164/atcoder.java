package abc.abc151_200.abc190;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), s = scanner.nextInt(), d = scanner.nextInt();
			System.out.println((IntStream.range(0, n).filter(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt();
				return (x < s) && (y > d);
			}).count() > 0) ? "Yes" : "No");
		}
	}
}
