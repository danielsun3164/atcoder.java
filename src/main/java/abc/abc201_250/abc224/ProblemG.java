package abc.abc201_250.abc224;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc224/editorial/2816 の実装<br/>
 * https://atcoder.jp/contests/abc224/submissions/33413636 にも参考
 */
public class ProblemG {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), s = scanner.nextLong(), t = scanner.nextLong(), a = scanner.nextLong(),
					b = scanner.nextLong();
			double answer = 1E20, m = Math.sqrt(2.0d * n * b / a);
			for (int i = -100; i <= 100; i++) {
				long x = ((long) m) + i;
				x = Math.max(x, 1L);
				x = Math.min(x, t);
				if (s <= t) {
					x = Math.min(x, t - s);
				}
				answer = Math.min(answer, a * (x - 1) / 2.0d + b * (double) n / x);
			}
			if (s <= t) {
				answer = Math.min(answer, (t - s) * (double) a);
			}
			System.out.println(answer);
		}
	}
}
