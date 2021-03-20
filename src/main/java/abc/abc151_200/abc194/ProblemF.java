package abc.abc151_200.abc194;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc194/submissions/20737566 にも参考
 */
public class ProblemF {

	/** あまりを計算する被除数 */
	private static final long MOD = 1_000_000_007;
	/** 16進数 */
	private static final int N = 16;
	/** 16進数の数字の文字表現 */
	private static final char[] NUMBERS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] n = scanner.next().toCharArray();
			int k = scanner.nextInt(), l = n.length;
			Set<Character> set = new HashSet<>();
			long[][] dp = new long[l + 1][N + 1];
			IntStream.rangeClosed(0, l).forEach(i -> Arrays.fill(dp[i], 0L));
			IntStream.range(0, l).forEach(i -> {
				IntStream.range(0, indexOf(n[i])).forEach(j -> {
					if ((j > 0) || (i > 0)) {
						if (set.contains(NUMBERS[j])) {
							dp[i + 1][set.size()]++;
						} else {
							dp[i + 1][set.size() + 1]++;
						}
					}
				});
				set.add(n[i]);
				if (i > 0) {
					dp[i + 1][1] += N - 1;
				}
				IntStream.rangeClosed(1, k).forEach(j -> {
					dp[i + 1][j] += dp[i][j] * j;
					dp[i + 1][j] += dp[i][j - 1] * (N - (j - 1));
					dp[i + 1][j] %= MOD;
				});
			});
			System.out.println((k == set.size()) ? (dp[l][k] + 1) % MOD : dp[l][k]);
		}
	}

	/**
	 * 文字cがNUMBERSの何番目かを返す
	 *
	 * @param c
	 * @return 文字cがNUMBERSの何番目か
	 */
	private static int indexOf(char c) {
		int index = Arrays.binarySearch(NUMBERS, c);
		return (index >= 0) ? index : ~index;
	}
}
