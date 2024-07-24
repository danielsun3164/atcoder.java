package abc.abc201_250.abc230;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc230/submissions/27657533 を参考に作成
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] s = new long[n + 1];
			s[0] = 0L;
			IntStream.range(0, n).forEach(i -> s[i + 1] = s[i] + scanner.nextLong());
			long sum = 0L;
			Map<Long, Long> dp = new HashMap<>();
			for (int i = 1; i <= n; i++) {
				long pre = dp.getOrDefault(s[i], 0L);
				dp.put(s[i], (sum + 1) % MOD);
				sum = (sum + sum + 1 - pre + MOD) % MOD;
			}
			System.out.println(dp.get(s[n]));
		}
	}
}
