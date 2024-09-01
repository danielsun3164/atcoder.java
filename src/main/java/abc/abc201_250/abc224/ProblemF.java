package abc.abc201_250.abc224;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc223/editorial/2774 のセグメント木を利用した解き方の実装
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			long[] pow2 = new long[n + 1];
			pow2[0] = pow2[1] = 1L;
			IntStream.range(1, n).forEach(i -> pow2[i + 1] = pow2[i] * 2 % MOD);
			long answer = 0L, sum = 0L;
			for (int i = 0; i < n; i++) {
				int now = s[i] - '0';
				answer = (answer * 10 + sum * pow2[i] + now * pow2[i + 1]) % MOD;
				sum = (sum + now) % MOD;
			}
			System.out.println(answer);
		}
	}
}
