package abc.abc179;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] bottom = new int[n], right = new int[n];
			Arrays.fill(bottom, n);
			Arrays.fill(right, n);
			long result = (n - 2) * (long) (n - 2);
			int h = n, w = n;
			for (int i = 0; i < q; i++) {
				int command = scanner.nextInt(), x = scanner.nextInt();
				if (1 == command) {
					if (x < w) {
						Arrays.fill(bottom, x, w, h);
						w = x;
					}
					result -= bottom[x] - 2;
				} else {
					if (x < h) {
						Arrays.fill(right, x, h, w);
						h = x;
					}
					result -= right[x] - 2;
				}
			}
			System.out.println(result);
		}
	}
}
