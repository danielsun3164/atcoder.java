package abc.abc151_200.abc182;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc182/submissions/18039449 に参考してに実装したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long x = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			@SuppressWarnings("unchecked")
			Map<Long, Long>[] dp = new Map[n];
			IntStream.range(0, n).forEach(i -> dp[i] = new HashMap<>());
			System.out.println(dfs(n, a, dp, n - 1, -x));
		}
	}

	/**
	 * dp[current][value]を計算する
	 *
	 * valueの正の方をYとすると、上の不等式からYとY - A_iの二つ</br>
	 * Y = 0の時のみ1つ</br>
	 * dp[i][Y] = dp[i-1][Y%A_i] + dp[i-1][Y%A_i-A_i]
	 *
	 * @param n       コインの種類数
	 * @param a       それぞれコインの金額の配列
	 * @param dp      計算結果を保存するマップ
	 * @param current 現在計算中のコイン
	 * @param value   計算目標の金額
	 * @return dp[current][value]
	 */
	private static long dfs(final int n, final long[] a, final Map<Long, Long>[] dp, int current, long value) {
		if (current < 0) {
			return 0L;
		}
		if (dp[current].containsKey(value)) {
			return dp[current].get(value);
		}
		long answer = 0L, sign = (value >= 0L) ? 1 : -1;
		long absValue = Math.abs(value);
		if (0 == absValue % a[current]) {
			answer = 1L;
		} else {
			long mod = absValue % a[current];
			// 今のコイン最大何枚使えるか
			long max = (current + 1 < n) ? a[current + 1] / a[current] : Long.MAX_VALUE;
			answer = dfs(n, a, dp, current - 1, sign * mod);
			if (max > absValue / a[current] + 1) {
				answer += dfs(n, a, dp, current - 1, sign * (mod - a[current]));
			}
		}
		dp[current].put(value, answer);
		return answer;
	}
}
