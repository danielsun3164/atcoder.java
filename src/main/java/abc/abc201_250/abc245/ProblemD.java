package abc.abc201_250.abc245;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, n + 1).map(i -> scanner.nextInt()).toArray(),
					c = IntStream.range(0, m + n + 1).map(i -> scanner.nextInt()).toArray(), b = new int[m + 1];
			IntStream.iterate(m, i -> i >= 0, i -> i - 1)
					.forEach(i -> b[i] = (c[i + n]
							- IntStream.rangeClosed(i + 1, Math.min(m, i + n)).map(j -> b[j] * a[i + n - j]).sum())
							/ a[n]);
			System.out.println(Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
