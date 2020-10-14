package other.hhkb2020;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード（解法2）
 */
public class ProblemF別回答 {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Range[] ranges = new Range[n + 1];
			IntStream.range(0, n).forEach(i -> ranges[i] = new Range(scanner.nextInt(), scanner.nextInt()));
			int maxL = IntStream.range(0, n).map(i -> ranges[i].l).max().getAsInt();
			// r_i-l_i の総乗
			long prod = IntStream.range(0, n).mapToLong(i -> ranges[i].r - ranges[i].l).reduce(1L,
					(ans, next) -> ans * next % MOD);
			long prodAll = prod;
			ranges[n] = new Range(-1, maxL);
			Arrays.sort(ranges, (a, b) -> (a.r == b.r) ? Integer.compare(b.l, a.l) : Integer.compare(b.r, a.r));
			long answer = maxL * prodAll % MOD;
			Range prev = null;
			// 積分のための式の表現
			long[] p = { 1L };
			for (Range range : ranges) {
				if (range.r < maxL) {
					break;
				}
				if (null != prev) {
					long tmp = integral(p, range.r, prev.r);
					answer = (answer + (prev.r - range.r) * prodAll % MOD - tmp * prod % MOD + MOD) % MOD;
				}
				if (range.l >= 0) {
					prod = prod * powMod(range.r - range.l, MOD - 2) % MOD;
					p = multiply(p, range.l);
				}
				prev = range;
			}
			System.out.println(LongStream.rangeClosed(2, n + 1).reduce(answer, (ans, next) -> ans * next % MOD));
		}
	}

	/**
	 * @param n
	 * @param m
	 * @return n^m mod MOD
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

	/**
	 * pで表す多項式を(x-l)にかける
	 * 
	 * @param p 多項式
	 * @param l
	 * @return pで表す多項式を(x-l)にかけた結果
	 */
	private static long[] multiply(long[] p, int l) {
		long[] np = new long[p.length + 1];
		for (int j = 0; j < p.length; j++) {
			np[j + 1] = p[j];
			np[j] = (np[j] - p[j] * l % MOD + MOD) % MOD;
		}
		return np;
	}

	/**
	 * pで表す多項式の積分を計算する
	 * 
	 * @param p
	 * @param l
	 * @param r
	 * @return pで表す多項式のlからrの積分
	 */
	private static long integral(long[] p, int l, int r) {
		long result = 0L, x = 1L, y = 1L;
		for (int j = 0; j < p.length; j++) {
			x = x * l % MOD;
			y = y * r % MOD;
			long co = p[j] * powMod(j + 1, MOD - 2) % MOD;
			result = (result + co * (y - x) % MOD + MOD) % MOD;
		}
		return result;
	}

	/**
	 * l,r を保存するクラス
	 */
	private static class Range {
		int l, r;

		Range(int l, int r) {
			super();
			this.l = l;
			this.r = r;
		}
	}
}
