package abc.abc101_150.abc134;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = new int[n];
			for (int i = n - 1; i >= 0; i--) {
				b[i] = a[i];
				for (int j = i + i + 1; j < n; j += (i + 1)) {
					b[i] ^= b[j];
				}
				b[i] &= 1;
			}
			System.out.println(Arrays.stream(b).filter(bi -> bi > 0).count());
			IntStream.range(0, n).filter(i -> b[i] > 0).forEach(i -> System.out.println(i + 1));
		}
	}
}
