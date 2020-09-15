package abc.abc019;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 数字の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] array = IntStream.range(0, N).map(i -> scanner.nextInt()).sorted().toArray();
			System.out.println(array[1]);
		}
	}
}
