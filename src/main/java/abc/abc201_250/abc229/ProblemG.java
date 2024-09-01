package abc.abc201_250.abc229;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc229/editorial/2963 の実装<br/>
 * https://atcoder.jp/contests/abc229/submissions/27486464 にも参考
 */
public class ProblemG {

	/** Yを表す文字 */
	private static final char Y = 'Y';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			long k = scanner.nextLong();
			int n = s.length;
			int[] a = IntStream.range(0, n).filter(i -> Y == s[i]).toArray();
			IntStream.range(0, a.length).forEach(i -> a[i] -= i);
			int ok = 0, ng = n + 1;
			while (ng > ok + 1) {
				int med = (ok + ng) >> 1;
				if (check(a, med, k)) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(ok);
		}
	}

	/**
	 * 配列aの値をk回以内の+1,-1操作をで、m個同じ数値にできるかを計算する
	 *
	 * @param a 配列
	 * @param m 結果の数値
	 * @param k 操作回数
	 * @return 配列aの値をk回以内の+1,-1操作をで、m個同じ数値にできるか
	 */
	private static boolean check(int[] a, int m, long k) {
		int n = a.length;
		if (n < m) {
			return false;
		}
		int l = m >> 1, r = m - l - 1;
		long[] s = new long[n + 1];
		s[0] = 0L;
		IntStream.range(0, n).forEach(i -> s[i + 1] = s[i] + a[i]);
		for (int i = l; i < n; i++) {
			if (i + r >= n) {
				break;
			}
			long sum = 0L;
			sum += (a[i] * (long) l) - (s[i] - s[i - l]);
			sum += (s[i + r + 1] - s[i + 1]) - a[i] * (long) r;
			if (sum <= k) {
				return true;
			}
		}
		return false;
	}
}
