package abc.abc151_200.abc189;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt() * 100;
			int[] v = new int[n], p = new int[n];
			IntStream.range(0, n).forEach(i -> {
				v[i] = scanner.nextInt();
				p[i] = scanner.nextInt();
			});
			int now = 0;
			for (int i = 0; i < n; i++) {
				now += v[i] * p[i];
				if (now > x) {
					System.out.println(i + 1);
					return;
				}
			}
			System.out.println(-1);
		}
	}
}
