package abc.abc151_200.abc170;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 入力数字の数 */
	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(IntStream.rangeClosed(1, N).filter(i -> 0 == scanner.nextInt())
					.reduce((first, second) -> second).getAsInt());
		}
	}
}
