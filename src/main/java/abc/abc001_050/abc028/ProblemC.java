package abc.abc001_050.abc028;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	/** 数字の数 */
	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = IntStream.range(0, N).map(i -> scanner.nextInt()).toArray();
			System.out.println(Math.max(a[N - 1] + a[N - 3] + a[N - 4], a[N - 1] + a[N - 2] + a[N - 5]));
		}
	}
}
