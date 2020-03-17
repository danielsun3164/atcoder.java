package abc086;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] t = new int[n + 1], x = new int[n + 1], y = new int[n + 1];
			t[0] = x[0] = y[0] = 0;
			IntStream.rangeClosed(1, n).forEach(i -> {
				t[i] = scanner.nextInt();
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			boolean ok = true;
			for (int i = 1; i <= n; i++) {
				int diff = (t[i] - t[i - 1]) - Math.abs(x[i] - x[i - 1]) - Math.abs(y[i] - y[i - 1]);
				if (diff < 0 || ((diff & 1) == 1)) {
					ok = false;
					break;
				}
			}
			System.out.println(ok ? "Yes" : "No");
		}
	}
}
