package abc.abc013;

import java.util.Scanner;
import java.util.stream.LongStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), h = scanner.nextLong();
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong(), d = scanner.nextLong(),
					e = scanner.nextLong();
			LongStream.rangeClosed(0, n).map(x -> {
				long y = (((n - x) * e - h - b * x) < 0) ? 0L : ((n - x) * e - h - b * x) / (d + e) + 1L;
				return (x + y <= n) ? (x * a + y * c) : Long.MAX_VALUE;
			}).min().ifPresent(System.out::println);
		}
	}
}
