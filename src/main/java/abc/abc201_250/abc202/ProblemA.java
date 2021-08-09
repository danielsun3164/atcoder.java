package abc.abc201_250.abc202;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 数字の数 */
	private static int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(21 - IntStream.range(0, N).map(i -> scanner.nextInt()).sum());
		}
	}
}
