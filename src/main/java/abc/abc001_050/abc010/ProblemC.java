package abc.abc001_050.abc010;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int txa = scanner.nextInt(), tya = scanner.nextInt(), txb = scanner.nextInt(), tyb = scanner.nextInt();
			int t = scanner.nextInt(), v = scanner.nextInt();
			// 移動できる距離
			int d = t * v, n = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			boolean found = false;
			for (int i = 0; i < n; i++) {
				if (Math.hypot(x[i] - txa, y[i] - tya) + Math.hypot(x[i] - txb, y[i] - tyb) <= d) {
					found = true;
					break;
				}
			}
			System.out.println(found ? "YES" : "NO");
		}
	}
}
