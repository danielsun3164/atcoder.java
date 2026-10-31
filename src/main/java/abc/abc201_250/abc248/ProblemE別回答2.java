package abc.abc201_250.abc248;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://blog.hamayanhamayan.com/entry/2022/04/16/232237 の実装
 */
public class ProblemE別回答2 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			if (1 == k) {
				System.out.println("Infinity");
				return;
			}
			Map<Line, Integer> count = new HashMap<>();
			IntStream.range(0, n).forEach(i -> IntStream.range(i + 1, n)
					.forEach(j -> count.merge(getParameter(x[i], y[i], x[j], y[j]), 1, Integer::sum)));
			Map<Integer, Integer> rcomb = new HashMap<>();
			IntStream.rangeClosed(k, n).forEach(i -> rcomb.put(i * (i - 1) / 2, 1));
			System.out.println(count.values().stream().mapToLong(ci -> rcomb.getOrDefault(ci, 0)).sum());
		}
	}

	/**
	 * 2点を通る直線の傾きと切片を求めます。
	 *
	 * <p>
	 * 直線を y = ax + b と表し、傾き a と切片 b をそれぞれ既約分数に 正規化して返します。垂直な直線については、傾きを分母 0 の分数として 表現します。
	 * </p>
	 *
	 * @param xa 1点目のx座標
	 * @param ya 1点目のy座標
	 * @param xb 2点目のx座標
	 * @param yb 2点目のy座標
	 * @return 傾きと切片を保持するLineオブジェクト
	 */
	static Line getParameter(long xa, long ya, long xb, long yb) {
		long dx = xa - xb, dy = ya - yb;

		// 傾きを正規化する
		if (dx < 0) {
			dx = -dx;
			dy = -dy;
		}

		if (dx == 0) {
			dy = 1;
		} else {
			long g = gcd(Math.abs(dy), dx);
			dy /= g;
			dx /= g;
		}

		// b = (ya * dx - dy * xa) / dx
		long bup = ya * dx - dy * xa, bdown = dx;
		return new Line(new Fraction(dy, dx, true), new Fraction(bup, bdown, false));
	}

	/**
	 * 2つの整数の最大公約数を求めます。
	 *
	 * @param a 1つ目の整数
	 * @param b 2つ目の整数
	 * @return 最大公約数
	 */
	static long gcd(long a, long b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	/**
	 * 既約分数を表すクラスです。
	 *
	 * <p>
	 * 分子と分母を最大公約数で約分し、分母が負の場合は分子と分母の符号を 反転して、分母が正になるように正規化します。傾きを表す場合は、 分母が0の分数も扱います。
	 * </p>
	 *
	 * <p>
	 * 分子と分母が正規化されているため、equals()とhashCode()によって 同じ値を持つ分数を同一のキーとして扱えます。
	 * </p>
	 */
	static class Fraction {
		long numerator, denominator;

		Fraction(long numerator, long denominator, boolean slope) {
			if (denominator < 0) {
				numerator = -numerator;
				denominator = -denominator;
			}
			if (denominator == 0) {
				if (slope) {
					numerator = 1;
				}
			} else {
				long g = gcd(Math.abs(numerator), denominator);
				numerator /= g;
				denominator /= g;
			}
			this.numerator = numerator;
			this.denominator = denominator;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Fraction other)) {
				return false;
			}
			return numerator == other.numerator && denominator == other.denominator;
		}

		@Override
		public int hashCode() {
			return Objects.hash(numerator, denominator);
		}
	}

	/**
	 * 直線を傾きと切片によって表すクラスです。
	 *
	 * <p>
	 * 傾きと切片はFraction型で保持し、分数の正規化によって同じ直線が 同じパラメータの組になるようにします。これにより、equals()と hashCode()を利用して、同一直線をMapのキーとして集計できます。
	 * </p>
	 *
	 * <p>
	 * 垂直な直線は傾きの分母が0のFractionで表現します。
	 * </p>
	 */
	static class Line {
		Fraction slope, intercept;

		Line(Fraction slope, Fraction intercept) {
			this.slope = slope;
			this.intercept = intercept;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Line other)) {
				return false;
			}
			return slope.equals(other.slope) && intercept.equals(other.intercept);
		}

		@Override
		public int hashCode() {
			return Objects.hash(slope, intercept);
		}
	}
}
