package abc.abc151_200.abc161;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 1桁の数字の上限値 と 最大数字の桁数 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			// dp[i][j]=(i+1)桁の数字の先頭がjのルンルン数の数
			int[][] dp = new int[N][N];
			IntStream.range(0, N).forEach(i -> Arrays.fill(dp[i], 0));
			// count[i]=1桁から(i+1)桁までのルンルン数の総数
			int[] count = new int[N];
			Arrays.fill(count, 0);
			// 結果の桁数
			int digit = 0;
			for (int i = 0; i < N; i++) {
				count[i] = (0 == i) ? 0 : count[i - 1];
				for (int j = 0; j < N; j++) {
					if (0 == i) {
						dp[i][j] = 1;
					} else {
						for (int l = Math.max(0, j - 1); l <= Math.min(9, j + 1); l++) {
							dp[i][j] += dp[i - 1][l];
						}
					}
					count[i] += (j > 0) ? dp[i][j] : 0;
				}
				if (count[i] >= k) {
					digit = i;
					break;
				}
			}
			int prev = N;
			k -= (digit > 0) ? count[digit - 1] : 0;
			StringBuilder sb = new StringBuilder();
			while (digit >= 0) {
				if (N == prev) {
					// 最初の桁の処理
					for (int i = 1; i < N; i++) {
						if (k > dp[digit][i]) {
							k -= dp[digit][i];
						} else {
							sb.append(i);
							prev = i;
							break;
						}
					}
				} else {
					// 2桁以降の処理、前の桁に依存する
					for (int i = Math.max(0, prev - 1); i <= Math.min(9, prev + 1); i++) {
						if (k > dp[digit][i]) {
							k -= dp[digit][i];
						} else {
							sb.append(i);
							prev = i;
							break;
						}
					}
				}
				digit--;
			}
			System.out.println(sb.toString());
		}
	}
}
