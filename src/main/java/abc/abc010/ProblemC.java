package abc.abc010;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int txa = scanner.nextInt();
			int tya = scanner.nextInt();
			int txb = scanner.nextInt();
			int tyb = scanner.nextInt();
			int t = scanner.nextInt();
			int v = scanner.nextInt();
			// 移動できる距離
			int d = t * v;
			int n = scanner.nextInt();
			int[] x = new int[n];
			int[] y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			boolean found = false;
			for (int i = 0; i < n; i++) {
				if (Math.sqrt((x[i] - txa) * (x[i] - txa) + (y[i] - tya) * (y[i] - tya))
						+ Math.sqrt((x[i] - txb) * (x[i] - txb) + (y[i] - tyb) * (y[i] - tyb)) <= d) {
					found = true;
					break;
				}
			}
			System.out.println(found ? "YES" : "NO");
		}
	}
}
