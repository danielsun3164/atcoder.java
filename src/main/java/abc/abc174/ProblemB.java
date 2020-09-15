package abc.abc174;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 判定条件を解説通りに実装
 */
public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long d = scanner.nextLong();
			System.out.println(IntStream.range(0, n).filter(i -> {
				long x = scanner.nextLong(), y = scanner.nextLong();
				return (x * x + y * y) <= d * d;
			}).count());
		}
	}
}
