package abc.abc185;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), t = scanner.nextInt();
			int[] a = new int[m + 1], b = new int[m + 1];
			a[0] = b[0] = 0;
			IntStream.rangeClosed(1, m).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
			});
			long x = n;
			for (int i = 1; i <= m; i++) {
				// 電池が減る
				x -= a[i] - b[i - 1];
				if (x <= 0) {
					System.out.println("No");
					return;
				}
				// 充電
				x += b[i] - a[i];
				if (x > n) {
					x = n;
				}
			}
			x -= t - b[m];
			if (x <= 0) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		}
	}
}
