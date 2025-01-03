package abc.abc201_250.abc219;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc219/editorial/2601 解法の実装
 */
public class ProblemH {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), d = 0;
			long answer = 0L;
			List<Data> dataList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				long x = scanner.nextLong(), a = scanner.nextLong();
				if (0L == x) {
					d++;
					answer += a;
				} else {
					dataList.add(new Data(x, a));
				}
			}
			dataList.add(new Data(0, 0L));
			int nn = n + 1 - d;
			Collections.sort(dataList);
			int i0 = IntStream.range(0, nn).map(i -> nn - 1 - i).filter(i -> 0L == dataList.get(i).a).findFirst()
					.getAsInt();
			long[][][] dp = new long[nn][2][nn], dp2 = new long[nn][2][nn];
			IntStream.range(0, nn).forEach(i -> IntStream.range(0, 2).forEach(j -> {
				Arrays.fill(dp[i][j], -INF);
				Arrays.fill(dp2[i][j], -INF);
				dp[i][j][0] = 0L;
			}));
			IntStream.range(0, nn - 1).map(j -> nn - 2 - j).forEach(j -> {
				IntStream.range(0, nn - j).forEach(i -> IntStream.range(1, nn - j).forEach(k -> {
					if (i > 0) {
						dp2[i][0][k] = Math.max(
								Math.max(dp2[i][0][k],
										dp[i - 1][0][k] - k * (dataList.get(i).x - dataList.get(i - 1).x)),
								dp[i - 1][0][k - 1] + dataList.get(i - 1).a
										- k * (dataList.get(i).x - dataList.get(i - 1).x));
						dp2[i][1][k] = Math.max(
								Math.max(dp2[i][1][k],
										dp[i - 1][0][k] - k * (dataList.get(i + j).x - dataList.get(i - 1).x)),
								dp[i - 1][0][k - 1] + dataList.get(i - 1).a
										- k * (dataList.get(i + j).x - dataList.get(i - 1).x));
					}
					if ((i + j) < (nn - 1)) {
						dp2[i][0][k] = Math.max(
								Math.max(dp2[i][0][k],
										dp[i][1][k] - k * (dataList.get(i + j + 1).x - dataList.get(i).x)),
								dp[i][1][k - 1] + dataList.get(i + j + 1).a
										- k * (dataList.get(i + j + 1).x - dataList.get(i).x));
						dp2[i][1][k] = Math.max(
								Math.max(dp2[i][1][k],
										dp[i][1][k] - k * (dataList.get(i + j + 1).x - dataList.get(i + j).x)),
								dp[i][1][k - 1] + dataList.get(i + j + 1).a
										- k * (dataList.get(i + j + 1).x - dataList.get(i + j).x));
					}
				}));
				IntStream.range(0, nn - j).forEach(i -> IntStream.range(0, 2).forEach(ii -> {
					System.arraycopy(dp2[i][ii], 1, dp[i][ii], 1, nn - j - 1);
					Arrays.fill(dp2[i][ii], 1, nn - j, -INF);
				}));
			});
			System.out.println(answer
					+ IntStream.range(0, nn).mapToLong(k -> Math.max(dp[i0][0][k], dp[i0][1][k])).max().getAsLong());
		}
	}

	/**
	 * x, aを格納するクラス
	 */
	private static class Data implements Comparable<Data> {
		long x, a;

		Data(long x, long a) {
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(Data o) {
			if (x == o.x) {
				return Long.compare(a, o.a);
			}
			return Long.compare(x, o.x);
		}
	}
}
