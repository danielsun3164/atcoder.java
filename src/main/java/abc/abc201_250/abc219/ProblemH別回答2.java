package abc.abc201_250.abc219;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc219/editorial/2662 解法の実装<br/>
 * https://atcoder.jp/contests/abc219/submissions/25912977 にも参考
 */
public class ProblemH別回答2 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt() + 1;
			Data[] datas = new Data[n];
			IntStream.range(0, n - 1).forEach(i -> datas[i] = new Data(scanner.nextLong(), scanner.nextLong()));
			datas[n - 1] = new Data(0L, 0L);
			Arrays.sort(datas);
			int start = IntStream.range(0, n).filter(i -> (0L == datas[i].x) && (0L == datas[i].a)).findFirst()
					.getAsInt();
			long[][][][] dp = new long[n + 1][n + 1][2][n + 1];
			IntStream.range(0, n + 1).forEach(l -> IntStream.range(l, n + 1)
					.forEach(r -> IntStream.range(0, 2).forEach(f -> Arrays.fill(dp[l][r][f], -INF))));
			Arrays.fill(dp[start][start + 1][0], 0L);
			IntStream.range(1, n).forEach(w -> IntStream.range(0, n - w + 1).forEach(l -> {
				int r = l + w;
				IntStream.range(0, 2)
						.forEach(f -> IntStream.range(0, n + 1).filter(c -> INF != dp[l][r][f][c]).forEach(c -> {
							long crr = dp[l][r][f][c], pos = (1 == f) ? datas[r - 1].x : datas[l].x;
							// 左へ
							if (0 != l) {
								dp[l - 1][r][0][c] = Math.max(dp[l - 1][r][0][c], crr - (pos - datas[l - 1].x) * c);
								if (c > 0) {
									dp[l - 1][r][0][c - 1] = Math.max(dp[l - 1][r][0][c - 1],
											crr - (pos - datas[l - 1].x) * c + datas[l - 1].a);
								}
							}
							// 右へ
							if (r != n) {
								dp[l][r + 1][1][c] = Math.max(dp[l][r + 1][1][c], crr - (datas[r].x - pos) * c);
								if (c > 0) {
									dp[l][r + 1][1][c - 1] = Math.max(dp[l][r + 1][1][c - 1],
											crr - (datas[r].x - pos) * c + datas[r].a);
								}
							}
						}));
			}));
			System.out.println(IntStream.range(0, n)
					.mapToLong(l -> IntStream.range(l, n + 1)
							.mapToLong(r -> IntStream.range(0, 2).mapToLong(f -> dp[l][r][f][0]).max().getAsLong())
							.max().getAsLong())
					.max().getAsLong());
		}
	}

	/**
	 * x, aを格納するクラス
	 */
	private static class Data implements Comparable<Data> {
		long x, a;

		Data(long x, long a) {
			super();
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
