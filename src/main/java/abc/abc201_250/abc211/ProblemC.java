package abc.abc201_250.abc211;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** チェック対象文字列 */
	private static final char[] CHOKUDAI = "chokudai".toCharArray();
	/** チェック対象文字列の長さ */
	private static final int N = CHOKUDAI.length;
	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;
	/** 文字ごとのインデックス */
	private static final Map<Character, Integer> MAP = new HashMap<>();
	static {
		IntStream.range(0, N).forEach(i -> MAP.put(CHOKUDAI[i], i));
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			long[][] dp = new long[N + 1][n + 1];
			IntStream.rangeClosed(0, N).forEach(i -> dp[i][0] = 0L);
			Arrays.fill(dp[0], 1L);
			IntStream.range(0, n).forEach(j -> {
				IntStream.range(0, N).forEach(i -> dp[i + 1][j + 1] = dp[i + 1][j]);
				Integer index = MAP.get(s[j]);
				if (null != index) {
					dp[index + 1][j + 1] = (dp[index + 1][j + 1] + dp[index][j]) % MOD;
				}
			});
			System.out.println(dp[N][n]);
		}
	}
}
