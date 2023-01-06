package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://github.com/E869120/kyopro_educational_90/blob/main/sol/005-03.cpp にも参考
 */
public class Problem005 {

	/** 2^62 > 10^18 */
	private static final int N = 62;
	/** mod対象 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int b = scanner.nextInt(), k = scanner.nextInt();
			int[] c = IntStream.range(0, k).map(i -> scanner.nextInt()).toArray();
			// power10[i]は10^(2^i) mod b
			long[] power10 = new long[N];
			power10[0] = 10 % b;
			IntStream.range(1, N).forEach(i -> power10[i] = (power10[i - 1] * power10[i - 1]) % b);
			// dp[i][j]は10^(2^(i-1)) mod b がjの数
			long[][] dp = new long[N + 1][b];
			IntStream.range(0, N + 1).forEach(i -> Arrays.fill(dp[i], 0L));
			// answer[i][j]はnのbitに併せてi桁計算した結果
			long[][] answer = new long[N + 1][b];
			IntStream.range(0, N + 1).forEach(i -> Arrays.fill(answer[i], 0L));
			answer[0][0] = 1L;
			IntStream.range(0, k).forEach(i -> dp[0][c[i] % b]++);
			IntStream.range(0, N).forEach(i -> IntStream.range(0, b).forEach(j -> {
				IntStream.range(0, b).forEach(l -> {
					int next = (int) (((j * power10[i]) + l) % b);
					dp[i + 1][next] = (dp[i + 1][next] + ((dp[i][j] * dp[i][l]) % MOD)) % MOD;
					if ((n & (1L << i)) > 0L) {
						answer[i + 1][next] = (answer[i + 1][next] + ((answer[i][j] * dp[i][l]) % MOD)) % MOD;
					}
				});
				if (0L == (n & (1L << i))) {
					answer[i + 1][j] = answer[i][j];
				}
			}));
			System.out.println(answer[N][0]);
		}
	}
}
