package abc.abc151_200.abc176;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc176/submissions/16164166 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int n3 = n * 3;
			int[] a = new int[n3];
			IntStream.range(0, n3).forEach(i -> a[i] = scanner.nextInt() - 1);
			int[][] dp = new int[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(dp[i], -1));
			dp[a[0]][a[1]] = dp[a[1]][a[0]] = 0;
			int[] max = new int[n];
			Arrays.fill(max, -1);
			int maxOfMax = 0, answer = 0;
			for (int i = 2; i < n3; i += 3) {
				if (n3 - 1 == i) {
					maxOfMax = Math.max(maxOfMax, dp[a[i]][a[i]] + 1);
				} else {
					// 左から 3,4,5 番目の数字が等しいときは、必ずそれら 3 枚を取り除くことにします
					if ((a[i] == a[i + 1]) && (a[i] == a[i + 2])) {
						answer++;
						continue;
					}

					List<Data> updates = new ArrayList<>();
					for (int j = 0; j < 3; j++) {
						int t1 = i + j;
						// 3,4,5 番目の数字の一つを p、残りを左から q,r として、DP[i+1][q][r] を DP[i][p][p]+1 で最大化します
						if (-1 != dp[a[t1]][a[t1]]) {
							int t2 = i + ((j + 1) % 3), t3 = i + ((j + 2) % 3);
							updates.add(new Data(a[t2], a[t3], dp[a[t1]][a[t1]] + 1));
						}
					}
					for (int t1 = i; t1 < i + 3; t1++) {
						for (int t2 = t1 + 1; t2 < i + 3; t2++) {
							int t3 = 3 * (i + 1) - t1 - t2;
							if (a[t1] == a[t2]) {
								// 3,4,5 番目の数字に等しい数字のペアがあるとき、その値を p、残りの一つの値を q 、k を 1 以上 N 以下の任意の整数として、DP[i+1][k][q] を
								// DP[i][p][k]+1 や DP[i][k][p]+1 で最大化します
								for (int k = 0; k < n; k++) {
									if (-1 != dp[k][a[t1]]) {
										updates.add(new Data(k, a[t3], dp[k][a[t1]] + 1));
									}
								}
							}
							// 3,4,5 番目の数字を左から p,q,r 、k,l を 1 以上 N 以下の任意の整数として、DP[i+1][p][q] や DP[i+1][p][r] や
							// DP[i+1][q][r] を DP[i][k][l] の最大値で最大化します
							updates.add(new Data(a[t1], a[t2], maxOfMax));
						}
						// DP[i+1][k][q] を DP[i][p][k]+1 や DP[i][k][p]+1 で最大化します
						for (int k = 0; k < n; k++) {
							updates.add(new Data(k, a[t1], max[k]));
						}
					}
					for (Data data : updates) {
						dp[data.i][data.j] = dp[data.j][data.i] = Math.max(dp[data.i][data.j], data.dp);
						max[data.i] = Math.max(max[data.i], dp[data.i][data.j]);
						max[data.j] = Math.max(max[data.j], dp[data.j][data.i]);
						maxOfMax = Math.max(dp[data.i][data.j], maxOfMax);
					}
				}
			}
			System.out.println(maxOfMax + answer);
		}
	}

	/**
	 * i,j,dpを表すクラス
	 */
	private static class Data {
		int i;
		int j;
		int dp;

		Data(int i, int j, int dp) {
			super();
			this.i = i;
			this.j = j;
			this.dp = dp;
		}
	}
}
