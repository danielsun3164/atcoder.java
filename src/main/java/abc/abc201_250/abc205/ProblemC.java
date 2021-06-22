package abc.abc201_250.abc205;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			int ans = compare(a, b, c);
			System.out.println((0 == ans) ? "=" : ((ans < 0) ? "<" : ">"));
		}
	}

	/**
	 * a^c と b^c の比較結果を計算する
	 *
	 * @param a
	 * @param b
	 * @param c
	 * @return a^c と b^c の比較結果
	 */
	private static int compare(int a, int b, int c) {
		if (0 == (1 & c)) {
			return compare(Math.abs(a), Math.abs(b), c >> 1);
		} else {
			return Integer.compare(a, b);
		}
	}
}
