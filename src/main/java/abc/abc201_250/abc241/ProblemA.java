package abc.abc201_250.abc241;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {
	/** aの数 */
	private static final int N = 10;
	/** ボタンを押す回数 */
	private static final int M = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = IntStream.range(0, N).map(i -> scanner.nextInt()).toArray();
			System.out.println(IntStream.range(0, M).reduce(0, (s, i) -> a[s]));
		}
	}
}
