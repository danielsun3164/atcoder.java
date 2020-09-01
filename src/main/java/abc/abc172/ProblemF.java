package abc.abc172;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc172/submissions/14756172 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long a1 = scanner.nextLong(), a2 = scanner.nextLong();
			long s = a1 + a2, x = 0L;
			for (int i = 2; i < n; i++) {
				long ai = scanner.nextLong();
				x ^= ai;
			}
			long d = (s - x);
			// https://atcoder.jp/contests/abc172/submissions/14756172 に書かれた条件
			if ((d & 1) > 0) {
				System.out.println(-1);
				return;
			}
			d >>= 1;
			if ((d < 0) || (0 != (d & x)) || (d > a1)) {
				System.out.println(-1);
				return;
			}
			long y = 0L;
			for (int i = 62; i >= 0; i--) {
				if ((x & (1L << i)) > 0) {
					if ((d ^ (y | (1L << i))) <= a1) {
						y |= (1L << i);
					}
				}
			}
			System.out.println((0 == (d ^ y)) ? -1 : (a1 - (d ^ y)));
		}
	}
}
