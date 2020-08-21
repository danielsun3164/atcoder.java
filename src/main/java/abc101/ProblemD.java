package abc101;

import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc101/submissions/15815216 を参考に作成したソースコード
 */
public class ProblemD {

	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			long a = 0, b = 1;
			for (int i = 0; i < k; i++) {
				if (((9 == (a / b) % TEN)) && (f(a + b) > f(a + TEN * b))) {
					b *= TEN;
				}
				a += b;
				System.out.println(a);
			}
		}
	}

	/**
	 * n/s(n)を計算する
	 * 
	 * @param n
	 * @return n/s(n)
	 */
	private static double f(long n) {
		long sum = 0, now = n;
		while (now > 0) {
			sum += now % TEN;
			now /= TEN;
		}
		return ((double) n) / sum;
	}
}
