package abc078;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			scanner.nextInt();
			int w = scanner.nextInt();

			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());

			if (1 == n) {
				System.out.println(Math.abs(a[n - 1] - w));
			} else {
				System.out.println(Math.max(Math.abs(a[n - 1] - w), Math.abs(a[n - 1] - a[n - 2])));
			}
		}
	}
}
