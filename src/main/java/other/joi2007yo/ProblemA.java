package other.joi2007yo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 科目数 */
	private static final int N = 4;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(Math.max(IntStream.range(0, N).map(i -> scanner.nextInt()).sum(),
					IntStream.range(0, N).map(i -> scanner.nextInt()).sum()));
		}
	}
}
