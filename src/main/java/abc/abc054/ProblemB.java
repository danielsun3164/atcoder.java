package abc.abc054;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			String[] a = new String[n];
			String[] b = new String[m];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.next());
			IntStream.range(0, m).forEach(i -> b[i] = scanner.next());
			boolean found = false;
			main: for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					if (containsAt(a, b, i, j)) {
						found = true;
						break main;
					}
				}
			}
			System.out.println(found ? "Yes" : "No");
		}
	}

	/**
	 * @param a
	 * @param b
	 * @param x
	 * @param y
	 * @return aの[x][y]からのm x mの部分はbと同じかどうか
	 */
	private static boolean containsAt(String[] a, String[] b, int x, int y) {
		int m = b.length;
		for (int i = 0; i < m; i++) {
			if (!a[x + i].substring(y, y + m).equals(b[i])) {
				return false;
			}
		}
		return true;
	}
}
