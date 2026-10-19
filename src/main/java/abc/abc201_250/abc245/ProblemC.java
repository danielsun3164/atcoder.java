package abc.abc201_250.abc245;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray(),
					b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			boolean[][] ok = new boolean[n][2];
			IntStream.range(0, n).forEach(i -> Arrays.fill(ok[i], false));
			ok[0][0] = ok[0][1] = true;
			for (int i = 1; i < n; i++) {
				if (ok[i - 1][0]) {
					ok[i][0] = ok[i][0] || (Math.abs(a[i] - a[i - 1]) <= k);
					ok[i][1] = ok[i][1] || (Math.abs(b[i] - a[i - 1]) <= k);
				}
				if (ok[i - 1][1]) {
					ok[i][0] = ok[i][0] || (Math.abs(a[i] - b[i - 1]) <= k);
					ok[i][1] = ok[i][1] || (Math.abs(b[i] - b[i - 1]) <= k);
				}
				if (!ok[i][0] && !ok[i][1]) {
					System.out.println("No");
					return;
				}
			}
			System.out.println("Yes");
		}
	}
}
