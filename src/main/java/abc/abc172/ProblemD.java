package abc.abc172;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(1, n).mapToLong(i -> {
				int y = n / i;
				return i * (long) y * (y + 1) / 2;
			}).sum());
		}
	}
}
