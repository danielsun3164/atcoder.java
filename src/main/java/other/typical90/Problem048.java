package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem048 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] c = new int[n << 1];
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt(), b = scanner.nextInt();
				c[i << 1] = b;
				c[(i << 1) | 1] = a - b;
			});
			Arrays.sort(c);
			System.out.println(IntStream.range(0, n << 1).skip((n << 1) - k).mapToLong(i -> c[i]).sum());
		}
	}
}
