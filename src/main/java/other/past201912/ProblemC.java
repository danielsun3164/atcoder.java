package other.past201912;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 入力数字の数 */
	private static final int N = 6;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = IntStream.range(0, N).map(i -> scanner.nextInt()).sorted().toArray();
			System.out.println(a[3]);
		}
	}
}
