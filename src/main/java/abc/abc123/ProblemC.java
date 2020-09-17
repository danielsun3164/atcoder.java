package abc.abc123;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 交通機関の数 */
	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long min = IntStream.range(0, N).mapToLong(i -> scanner.nextLong()).min().getAsLong();
			System.out.println((n - 1) / min + N);
		}
	}
}
