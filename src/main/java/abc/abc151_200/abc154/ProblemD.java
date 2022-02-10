package abc.abc151_200.abc154;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] p = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			double now = IntStream.range(0, k).mapToDouble(i -> (p[i] + 1.0d) / 2.0d).sum();
			double answer = now;
			for (int i = k; i < n; i++) {
				now = now - (p[i - k] + 1.0d) / 2.0d + (p[i] + 1.0d) / 2.0d;
				answer = Math.max(answer, now);
			}
			System.out.println(answer);
		}
	}
}
