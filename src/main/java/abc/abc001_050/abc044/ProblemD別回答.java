package abc.abc001_050.abc044;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 解説通り実装したソースコード
 *
 * https://atcoder.jp/contests/abc044/editorial/4962 の実装<br/>
 * https://atcoder.jp/contests/abc044/submissions/35365981 にも参考
 */
public class ProblemD別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), s = scanner.nextLong();
			if (n < s) {
				// https://atcoder.jp/contests/abc044/submissions/4095161 参考に追加
				System.out.println(-1);
			} else if (n == s) {
				System.out.println(n + 1);
			} else {
				long m = n - s, sqrtN = (long) Math.sqrt(m);
				NavigableSet<Long> set = new TreeSet<>();
				for (long d = 1L; d <= sqrtN; d++) {
					if (0L == m % d) {
						set.add(d);
						set.add(m / d);
					}
				}
				for (long d : set) {
					if (s == f(d + 1, n)) {
						System.out.println(d + 1);
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
