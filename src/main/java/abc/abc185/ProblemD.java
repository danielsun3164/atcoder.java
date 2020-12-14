package abc.abc185;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[m + 2], d = new int[m + 1];
			a[0] = 0;
			a[m + 1] = n + 1;
			IntStream.rangeClosed(1, m).forEach(i -> a[i] = scanner.nextInt());
			Arrays.sort(a);
			if (n == m) {
				System.out.println(0);
				return;
			}
			int min = IntStream.rangeClosed(0, m).map(i -> d[i] = a[i + 1] - a[i] - 1).filter(di -> 0 != di).min()
					.getAsInt();
			System.out.println(Arrays.stream(d).map(di -> (di + min - 1) / min).sum());
		}
	}
}
