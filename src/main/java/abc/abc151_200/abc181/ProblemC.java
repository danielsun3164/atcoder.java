package abc.abc151_200.abc181;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			for (int i = 0; i < n - 2; i++) {
				for (int j = i + 1; j < n - 1; j++) {
					for (int k = j + 1; k < n; k++) {
						if ((x[j] - x[i]) * (y[k] - y[i]) == (y[j] - y[i]) * (x[k] - x[i])) {
							System.out.println("Yes");
							return;
						}
					}
				}
			}
			System.out.println("No");
		}
	}
}
