package abc.abc101_150.abc147;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 入力数字の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println((IntStream.range(0, N).map(i -> scanner.nextInt()).sum() > 21) ? "bust" : "win");
		}
	}
}
