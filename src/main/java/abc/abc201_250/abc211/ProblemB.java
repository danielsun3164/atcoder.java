package abc.abc201_250.abc211;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 入力文字の数 */
	private static final int N = 4;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(
					(N == IntStream.range(0, N).mapToObj(i -> scanner.next()).distinct().count()) ? "Yes" : "No");
		}
	}
}
