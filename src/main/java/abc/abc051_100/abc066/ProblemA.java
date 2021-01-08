package abc.abc051_100.abc066;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** ベルの種類数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(IntStream.range(0, N).map(i -> scanner.nextInt()).sorted().limit(2).sum());
		}
	}
}
