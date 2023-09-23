package abc.abc201_250.abc220;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc220/editorial/2685 解法の実装<br/>
 * https://atcoder.jp/contests/abc220/submissions/26111051 にも参考
 */
public class ProblemH {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			boolean[][] edges = new boolean[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(edges[i], false));
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a][b] = edges[b][a] = true;
			});
			int halfN = n >> 1;
			long[] dp = new long[1 << halfN];
			IntStream.range(1, 1 << halfN).forEach(i -> {
				int pos = IntStream.range(0, halfN).filter(j -> 1 == ((i >> j) & 1)).findFirst().getAsInt();
				int count = 0;
				for (int j = 0; j < n; j++) {
					if (edges[j][pos]) {
						if (j <= halfN - 1) {
							if (0 == ((i >> j) & 1)) {
								count++;
							}
						} else {
							count++;
						}
					}
				}
				dp[i] = dp[i - (1 << pos)] ^ (count & 1);
			});
			long[] ep = new long[1 << halfN];
			{
				long[] ee = new long[halfN];
				Arrays.fill(ee, 0L);
				IntStream.range(0, halfN).forEach(i -> IntStream.range(halfN, n).filter(j -> edges[i][j])
						.forEach(j -> ee[i] += 1 << (j - halfN)));
				IntStream.range(0, (1 << halfN) - 1).map(i -> (1 << halfN) - 2 - i).forEach(i -> {
					if (halfN - 1 == Integer.bitCount(i)) {
						for (int j = 0; j < halfN; j++) {
							if (0 == ((i >> j) & 1)) {
								ep[i] = ee[j];
								break;
							}
						}
					} else {
						for (int j = 0; j < halfN; j++) {
							if (0 == ((i >> j) & 1)) {
								ep[i] = ep[i + (1 << j)] ^ ee[j];
								break;
							}
						}
					}
				});
			}

			List<Long> fpcnt = new ArrayList<>();
			long[][] a = new long[1][];
			{
				long[] b = new long[1 << (n - halfN)];
				Arrays.fill(b, 0L);
				long sum = IntStream.range(1, 1 << (n - halfN)).filter(i -> {
					int pos = IntStream.range(0, n - halfN).filter(j -> 1 == ((i >> j) & 1)).findFirst().getAsInt();
					b[i] = b[i - (1 << pos)];
					IntStream.range(0, n - halfN).filter(j -> edges[pos + halfN][j + halfN] && (0 == ((i >> j) & 1)))
							.forEach(j -> b[i] ^= 1);
					return (b[i] != 0L);
				}).count();
				a[0] = b;
				fpcnt.add(sum);

			}

			while (a[0].length > 1) {
				int ah = a.length, aw = a[0].length;
				long[][] c = new long[ah << 1][aw >> 1];
				for (int i = 0; i < ah; i++) {
					long sum = 0L;
					for (int j = 0; j < aw; j++) {
						long value = (1 == (j & 1)) ? ah - a[i][j] : a[i][j];
						c[i][j >> 1] += a[i][j];
						c[i + ah][j >> 1] += value;
						sum += value;
					}
					fpcnt.add(sum);
				}
				a = c;
			}
			long all = 1 << (n - halfN);
			System.out.println(IntStream.range(0, 1 << halfN)
					.mapToLong(i -> (0L != dp[i]) ? fpcnt.get((int) ep[i]) : all - fpcnt.get((int) ep[i])).sum());
		}
	}
}
