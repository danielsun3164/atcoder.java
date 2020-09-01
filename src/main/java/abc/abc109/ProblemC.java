package abc.abc109;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int gcd = 0;
			for (int i = 0; i < n; i++) {
				int x = scanner.nextInt();
				if (x != k) {
					if (0 == gcd) {
						gcd = Math.abs(x - k);
					} else {
						gcd = gcd(gcd, Math.abs(x - k));
					}
				}
			}
			System.out.println(gcd);
		}
	}

	/**
	 * mとnの最大公約数を返す
	 * 
	 * @param m
	 * @param n
	 * @return mとnの最大公約数
	 */
	private static int gcd(int m, int n) {
		if (0 == n) {
			return m;
		}
		return gcd(n, m % n);
	}
}
