package abc.abc028;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	/** 数字の数 */
	private static final int SIZE = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = new int[SIZE];
			IntStream.range(0, SIZE).forEach(i -> a[i] = scanner.nextInt());
			System.out.println(
					Math.max(a[SIZE - 1] + a[SIZE - 3] + a[SIZE - 4], a[SIZE - 1] + a[SIZE - 2] + a[SIZE - 5]));
		}
	}
}
