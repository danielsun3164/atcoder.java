package abc.abc051_100.abc054;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			String[] a = IntStream.range(0, n).mapToObj(i -> scanner.next()).toArray(String[]::new);
			String[] b = IntStream.range(0, m).mapToObj(i -> scanner.next()).toArray(String[]::new);
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
