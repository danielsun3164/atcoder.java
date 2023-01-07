package abc.abc001_050.abc003;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt(), c = scanner.nextInt();
			int x = scanner.nextInt(), y = scanner.nextInt();
			int d = scanner.nextInt(), l = scanner.nextInt();
			long[] factoral = new long[x * y + 1], revFactoral = new long[x * y + 1];
			factoral[0] = 1L;
			IntStream.rangeClosed(1, x * y).forEach(i -> factoral[i] = factoral[i - 1] * i % MOD);
			revFactoral[x * y] = powMod(factoral[x * y], MOD - 2);
			IntStream.rangeClosed(1, x * y).map(i -> x * y - i)
					.forEach(i -> revFactoral[i] = revFactoral[i + 1] * (i + 1) % MOD);
			// r*cの中でx*yを配置するパターン数
			long xy = (r - x + 1) * (c - y + 1) % MOD;
			System.out.println(xy * getResult(x, y, d, l, factoral, revFactoral) % MOD);
		}
	}

	/**
	 * x*yのエリアの中でd個のデスクとl個サーバーラックを配置するパターン数を計算する
	 *
	 * @param x           行数
	 * @param y           列数
	 * @param d           デスク数
	 * @param l           サーバーラック数
	 * @param factoral    階乗の配列
	 * @param revFactoral 階乗^-1の配列
	 * @return x*yのエリアの中でd個のデスクとl個サーバーラックを配置するパターン数
	 */
	private static long getResult(final int x, final int y, final int d, final int l, final long[] factoral,
			final long[] revFactoral) {
		long result = p(x, y, d, l, factoral, revFactoral);
		// 1辺がくっついていないパターン
		result = (result - 2 * p(x - 1, y, d, l, factoral, revFactoral) % MOD
				- 2 * p(x, y - 1, d, l, factoral, revFactoral) % MOD + MOD) % MOD;
		// 2辺がくっついていないパターン
		result = (result + 4 * p(x - 1, y - 1, d, l, factoral, revFactoral)) % MOD;
		result = (result + p(x - 2, y, d, l, factoral, revFactoral) + p(x, y - 2, d, l, factoral, revFactoral)) % MOD;
		// 3辺がくっついていないパターン
		result = (result - 2 * p(x - 2, y - 1, d, l, factoral, revFactoral) % MOD
				- 2 * p(x - 1, y - 2, d, l, factoral, revFactoral) % MOD + MOD) % MOD;
		// 4辺がくっついていないパターン
		result = (result + p(x - 2, y - 2, d, l, factoral, revFactoral)) % MOD;
		return result;
	}

	/**
	 * x*yのエリアの中でd個のデスクとl個サーバーラックを無条件で配置するパターン数を計算する
	 *
	 * @param x           行数
	 * @param y           列数
	 * @param d           デスク数
	 * @param l           サーバーラック数
	 * @param factoral    階乗の配列
	 * @param revFactoral 階乗^-1の配列
	 * @return x*yのエリアの中でd個のデスクとl個サーバーラックを無条件で配置するパターン数
	 */
	private static long p(final int x, final int y, final int d, final int l, final long[] factoral,
			final long[] revFactoral) {
		if ((x > 0) && (y > 0) && (x * y >= (d + l))) {
			// x*y_C_d * x*y-d_C_l
			return factoral[x * y] * revFactoral[d] % MOD * revFactoral[x * y - d] % MOD * factoral[x * y - d] % MOD
					* revFactoral[l] % MOD * revFactoral[x * y - d - l] % MOD;
		}
		return 0L;
	}

	/**
	 * nのmべき乗 mod MOD を計算する
	 *
	 * @param n
	 * @param m
	 * @return nのmべき乗 mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (m & 1)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
