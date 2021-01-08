package abc.abc101_150.abc123;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** アンテナーの数 */
	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] n = IntStream.range(0, 5).map(i -> scanner.nextInt()).sorted().toArray();
			int k = scanner.nextInt();
			System.out.println((n[N - 1] - n[0] > k) ? ":(" : "Yay!");
		}
	}
}
