package abc.abc129;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long l = scanner.nextLong(), a = scanner.nextLong(), b = scanner.nextLong(), m = scanner.nextLong();
			// 等差数列の要素は全て 10^18 未満のため、オーバーフローしない
			long max = a + b * (l - 1);
			long[][] x = new long[][] { { 0L, safeMod(a, m), 1L } };
			long[] d = numbersOfDigits(a, b, max);
			for (int i = digits(a); i <= digits(max); i++) {
				long[][] t = new long[][] { { powMod(10L, i, m), 0L, 0L }, { 1L, 1L, 0L }, { 0L, safeMod(b, m), 1L } };
				x = multiply(x, powMod(t, d[i] - d[i - 1], m), m);
			}
			System.out.println(x[0][0]);
		}
	}

	/**
	 * 数字nの10進数の桁数
	 * 
	 * @param n 入力数字
	 * @return 数字nの10進数の桁数を計算する
	 */
	private static int digits(long n) {
		int x = 0;
		while (n > 0) {
			x++;
			n /= 10;
		}
		return x;
	}

	/**
	 * 各桁の数字の数を計算する
	 * 
	 * @param min 数列の最小値
	 * @param d   数列の差
	 * @param max 数列の最大値
	 * @return i番目の要素はi桁以下の数字の数の配列
	 */
	private static long[] numbersOfDigits(long min, long d, long max) {
		long[] result = new long[digits(max) + 1];
		Arrays.fill(result, 0L);
		IntStream.rangeClosed(digits(min), digits(max))
				.forEach(i -> result[i] = (Math.min(max, nines(i)) - min) / d + 1L);
		return result;
	}

	/**
	 * digit桁の9の数字を返す
	 * 
	 * @param digit
	 * @return digit桁の9の数字
	 */
	private static long nines(int digit) {
		long result = 0L;
		for (int i = 0; i < digit; i++) {
			result = result * 10L + 9L;
		}
		return result;
	}

	/**
	 * 行列aと行列bの掛け算を計算する。ただし、結果にはmod mをする。
	 * 
	 * @param a
	 * @param b
	 * @param m
	 * @return 計算結果の行列
	 */
	private static long[][] multiply(long[][] a, long[][] b, long m) {
		long[][] result = new long[a.length][b[0].length];
		IntStream.range(0, result.length).forEach(i -> Arrays.fill(result[i], 0L));
		IntStream.range(0, result.length).forEach(i -> IntStream.range(0, result[i].length).forEach(j -> IntStream
				.range(0, b.length).forEach(k -> result[i][j] = safeMod(result[i][j] + a[i][k] * b[k][j], m))));
		return result;
	}

	/**
	 * 行列aのbべき乗を計算する。ただし、結果にはmod mをする。
	 * 
	 * @param a
	 * @param b
	 * @param m
	 * @return 計算結果の行列
	 */
	private static long[][] powMod(long[][] a, long b, long m) {
		long[][] result = new long[a.length][a.length];
		for (int i = 0; i < result.length; i++) {
			Arrays.fill(result[i], 0L);
			result[i][i] = 1L;
		}
		while (b > 0) {
			if (1 == (b & 1)) {
				result = multiply(result, a, m);
			}
			a = multiply(a, a, m);
			b >>= 1;
		}
		return result;
	}

	/**
	 * x^n mod m
	 * 
	 * @param x
	 * @param n
	 * @param m
	 * @return x^n mod m を計算する
	 */
	static long powMod(long x, long n, long m) {
		if (!((0L <= n) || (1L <= m))) {
			throw new IllegalArgumentException("n is " + n + ", m is " + m);
		}
		if (1L == m) {
			return 0L;
		}
		long r = 1L, y = safeMod(x, m);
		while (n > 0L) {
			if (1L == (n & 1L)) {
				r = safeMod(r * y, m);
			}
			y = safeMod(y * y, m);
			n >>= 1;
		}
		return r;
	}

	/**
	 * x mod m を安全に計算する
	 * 
	 * @param x
	 * @param m
	 * @return x mod m
	 */
	private static long safeMod(long x, long m) {
		x %= m;
		if (x < 0) {
			x += m;
		}
		return x;
	}
}
