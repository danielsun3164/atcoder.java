package abc.abc051_100.abc095;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			int x = scanner.nextInt(), y = scanner.nextInt();
			int max = Math.max(x, y);
			max = (1 == (max & 1)) ? max + 1 : max;
			System.out.println(IntStream.rangeClosed(0, max)
					.map(i -> i * 2 * c + Math.max(x - i, 0) * a + Math.max(y - i, 0) * b).min().getAsInt());
		}
	}
}
