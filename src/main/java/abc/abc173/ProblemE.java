package abc.abc173;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc173/submissions/15455890 を参考に実装したソースコード
 */
public class ProblemE {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).sorted().toArray();
			int left = 0, right = n - 1;
			long answer = (1 == (k & 1)) ? a[right--] : 1L;
			long sign = (answer < 0) ? -1 : 1;
			while (k > 1) {
				if (sign * a[left] * a[left + 1] >= sign * a[right] * a[right - 1]) {
					answer = answer * a[left++] % MOD;
					answer = answer * a[left++] % MOD;
				} else {
					answer = answer * a[right--] % MOD;
					answer = answer * a[right--] % MOD;
				}
				k -= 2;
			}
			System.out.println((answer + MOD) % MOD);
		}
	}
}
