package abc.abc151_200.abc193;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).mapToLong(i -> {
				long a = scanner.nextLong(), p = scanner.nextLong(), x = scanner.nextLong();
				return (x > a) ? p : 0L;
			}).filter(i -> i != 0L).min().orElse(-1L));
		}
	}
}
