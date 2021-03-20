package abc.abc151_200.abc196;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long low = -INF, high = INF, add = 0;
			for (int i = 0; i < n; i++) {
				int a = scanner.nextInt(), t = scanner.nextInt();
				if (1 == t) {
					low += a;
					high += a;
					add += a;
				} else if (2 == t) {
					low = Math.max(low, a);
					high = Math.max(high, a);
				} else {
					low = Math.min(low, a);
					high = Math.min(high, a);
				}
			}
			int q = scanner.nextInt();
			for (int i = 0; i < q; i++) {
				long x = scanner.nextLong();
				System.out.println(Math.min(Math.max(x + add, low), high));
			}
		}
	}
}
