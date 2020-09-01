package abc.abc025;

import java.util.Scanner;

public class ProblemB {

	private static final String EAST = "East";
	private static final String WEST = "West";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				String s = scanner.next();
				int d = scanner.nextInt();
				if (WEST.equals(s)) {
					sum -= calc(a, b, d);
				} else {
					sum += calc(a, b, d);
				}
			}
			if (sum > 0) {
				System.out.print(EAST + " ");
			}
			if (sum < 0) {
				System.out.print(WEST + " ");
			}
			System.out.println(Math.abs(sum));
		}
	}

	/**
	 * @param a
	 * @param b
	 * @param d
	 * @return d<aの場合、aを返す。d>bの場合、bを返す。それ以外の場合ではdを返す。
	 */
	private static int calc(int a, int b, int d) {
		if (d < a) {
			return a;
		}
		if (d > b) {
			return b;
		}
		return d;
	}
}
