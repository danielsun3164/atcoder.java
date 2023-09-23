package abc.abc201_250.abc218;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc218/editorial/2638の解説の実装<br/>
 * https://atcoder.jp/contests/abc218/submissions/25760396 にも参考
 */
public class ProblemH別回答3 {

	/** 最大値 */
	private static final long INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), r = scanner.nextInt();
			r = Math.min(r, n - r);
			long[] a = new long[n - 1];
			IntStream.range(0, n - 1).forEach(i -> a[i] = scanner.nextLong());
			System.out.println(goldenSectionSearch(a, r, -INF, INF)[1]);
		}
	}

	/**
	 * 黄金分割探索を実装
	 *
	 * @param array 数値の配列
	 * @param r     赤いランプの数
	 * @param min   最小値
	 * @param max   最大値
	 * @return 計算結果
	 */
	private static long[] goldenSectionSearch(long[] array, long r, long min, long max) {
		long a = min - 1, x, b;
		{
			long s = 1L, t = 2L;
			while (t < max - min + 2) {
				long temp = t;
				t += s;
				s = temp;
			}
			x = a + t - s;
			b = a + t;
		}
		long fx = solve(array, x, r);
		while (a + b != (x << 1)) {
			long y = a + b - x, fy = solve(array, y, r);
			if ((max < y) || (fx < fy)) {
				b = a;
				a = y;
			} else {
				a = x;
				x = y;
				fx = fy;
			}
		}
		return new long[] { x, fx };
	}

	/**
	 * f(l) を計算する
	 *
	 * @param a aの配列
	 * @param l
	 * @param r 赤いランプの数
	 * @return f(l)
	 */
	private static long solve(long[] a, long l, long r) {
		long dpr = l, dpb = 0L;
		for (long ai : a) {
			long ndpr = Math.max(dpr, dpb + ai) + l, ndpb = Math.max(dpr + ai, dpb);
			dpr = ndpr;
			dpb = ndpb;
		}
		return Math.max(dpr, dpb) - l * r;
	}
}
