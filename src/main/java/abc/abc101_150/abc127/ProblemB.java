package abc.abc101_150.abc127;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 処理する年数 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt(), d = scanner.nextInt(), x = scanner.nextInt();
			IntStream.range(0, N).reduce(x, (first, second) -> {
				int newX = r * first - d;
				System.out.println(newX);
				return newX;
			});
		}
	}
}
