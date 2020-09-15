package abc.abc078;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt(), z = scanner.nextInt(), w = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			if (1 == n) {
				System.out.println(Math.abs(a[n - 1] - w));
			} else {
				System.out.println(Math.max(Math.abs(a[n - 1] - w), Math.abs(a[n - 1] - a[n - 2])));
			}
		}
	}
}
