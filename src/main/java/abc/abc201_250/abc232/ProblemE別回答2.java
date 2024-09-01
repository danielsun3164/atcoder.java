package abc.abc201_250.abc232;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * 行列累乗 の実装<br/>
 * https://atcoder.jp/contests/abc232/submissions/47816537 にも参考
 */
public class ProblemE別回答2 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 2 */
	private static final int N = 2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), k = scanner.nextInt(), x1 = scanner.nextInt(),
					y1 = scanner.nextInt(), x2 = scanner.nextInt(), y2 = scanner.nextInt();
			long[] row = new long[] { h - 1, 1L }, col = new long[] { w - 1, 1L };
			long[][] a = new long[N * N][N * N];
			IntStream.range(0, N * N).forEach(i -> Arrays.fill(a[i], 0L));
			IntStream.range(0, N).forEach(x -> IntStream.range(0, N).forEach(y -> {
				IntStream.range(0, N).forEach(nx -> a[(nx << 1) + y][(x << 1)
						+ y] = (a[(nx << 1) + y][(x << 1) + y] + row[nx] - ((x == nx) ? 1 : 0)) % MOD);
				IntStream.range(0, N).forEach(ny -> a[(x << 1) + ny][(x << 1)
						+ y] = (a[(x << 1) + ny][(x << 1) + y] + col[ny] - ((y == ny) ? 1 : 0)) % MOD);
			}));
			long[][] b = new long[N * N][1];
			b[((x1 == x2) ? N : 0) + ((y1 == y2) ? 1 : 0)][0] = 1L;
			System.out.println(multiply(powMod(a, k), b)[N + 1][0]);
		}
	}

	/**
	 * 行列aとbの積を計算する
	 *
	 * @param a
	 * @param b
	 * @return 行列aとbの積
	 */
	private static long[][] multiply(long[][] a, long[][] b) {
		int n = a.length, m = b[0].length, q = a[0].length;
		long[][] result = new long[n][m];
		IntStream.range(0, n).forEach(i -> Arrays.fill(result[i], 0L));
		IntStream.range(0, n).forEach(i -> IntStream.range(0, m).forEach(j -> IntStream.range(0, q)
				.forEach(k -> result[i][j] = (result[i][j] + a[i][k] * b[k][j] % MOD) % MOD)));
		return result;
	}

	/**
	 * 行列aのn乗を計算する
	 *
	 * @param a
	 * @param n
	 * @return 行列aのn乗
	 */
	private static long[][] powMod(long[][] a, long n) {
		int m = a.length;
		long[][] result = new long[m][m];
		for (int i = 0; i < m; i++) {
			Arrays.fill(result[i], 0L);
			result[i][i] = 1L;
		}
		while (n > 0) {
			if (1L == (1L & n)) {
				result = multiply(result, a);
			}
			n >>= 1;
			a = multiply(a, a);
		}
		return result;
	}
}
