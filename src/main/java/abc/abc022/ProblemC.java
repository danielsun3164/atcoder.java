package abc.abc022;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc022/submissions/4593274 を参考に作成
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			// d[i][j]はiからjへの最短距離
			long[][] d = new long[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(d[i], Integer.MAX_VALUE));
			// i==jのとき距離は0
			IntStream.range(0, n).forEach(i -> d[i][i] = 0);
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1;
				int v = scanner.nextInt() - 1;
				int l = scanner.nextInt();
				d[u][v] = d[v][u] = l;
			});
			// ノード0以外の最短距離を計算
			IntStream.range(1, n).forEach(k -> IntStream.range(1, n)
					.forEach(i -> IntStream.range(1, n).forEach(j -> d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]))));
			// ノード0からの最短距離を計算
			long result = IntStream.range(1, n).mapToLong(i -> IntStream.range(1, n).filter(j -> j != i)
					.mapToLong(j -> d[i][j] + d[0][i] + d[0][j]).min().getAsLong()).min().getAsLong();
			System.out.println((result < Integer.MAX_VALUE) ? result : -1);
		}
	}
}
