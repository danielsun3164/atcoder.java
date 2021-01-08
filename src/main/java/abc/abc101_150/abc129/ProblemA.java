package abc.abc101_150.abc129;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 空港間の飛行ルートの数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = IntStream.range(0, N).map(i -> scanner.nextInt()).toArray();
			System.out.println(Arrays.stream(a).sum() - Arrays.stream(a).max().getAsInt());
		}
	}
}
