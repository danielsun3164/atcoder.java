package abc173;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n + 1];
			a[0] = 0;
			IntStream.rangeClosed(1, n).forEach(i -> a[i] = scanner.nextInt());
			Arrays.sort(a);
			System.out.println(IntStream.range(1, n).mapToLong(k -> a[n - k / 2]).sum());
		}
	}
}
