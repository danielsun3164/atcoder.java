package abc.abc044;

import java.util.Scanner;

/**
 * 解説通り実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long s = scanner.nextLong();
			if (n < s) {
				// https://atcoder.jp/contests/abc044/submissions/4095161 参考に追加
				System.out.println(-1);
			} else if (n == s) {
				System.out.println(n + 1);
			} else {
				int sqrtN = (int) Math.sqrt(n);
				for (int b = 2; b <= sqrtN; b++) {
					if (s == f(b, n)) {
						System.out.println(b);
						return;
					}
				}
				for (int p = sqrtN; p >= 1; p--) {
					long b = (n - s) / p + 1;
					if ((b > sqrtN) && (b > p) && (s == f(b, n))) {
						System.out.println(b);
						return;
					}
				}
				System.out.println(-1);
			}
		}
	}

	/**
	 * @param b
	 * @param n
	 * @return f(b,n)
	 */
	private static long f(long b, long n) {
		if (n < b) {
			return n;
		} else {
			return f(b, n / b) + n % b;
		}
	}
}
