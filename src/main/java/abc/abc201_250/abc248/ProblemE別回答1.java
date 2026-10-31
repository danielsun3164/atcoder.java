package abc.abc201_250.abc248;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc248/editorial/3813 の実装<br/>
 * https://atcoder.jp/contests/abc248/submissions/31045582 にも参考
 */
public class ProblemE別回答1 {

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
			Map<Line, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> IntStream.range(i + 1, n)
					.forEach(j -> map.merge(new Line(x[i], y[i], x[j], y[j]), 1, Integer::sum)));
			long threshold = (long) k * (k - 1) / 2;
			System.out.println(map.values().stream().filter(cnt -> cnt >= threshold).count());
		}
	}

	/**
	 * 分子と分母を表すクラス
	 */
	static class Fraction implements Comparable<Fraction> {
		/** 分子と分母 */
		long numerator, denominator;

		Fraction(long numerator) {
			this(numerator, 1);
		}

		Fraction(long numerator, long denominator) {
			if (denominator == 0) {
				throw new ArithmeticException("denominator is zero");
			}

			long g = gcd(numerator, denominator);
			if (denominator < 0) {
				g = -g;
			}
			this.numerator = numerator / g;
			this.denominator = denominator / g;
		}

		private static long gcd(long a, long b) {
			a = Math.abs(a);
			b = Math.abs(b);
			return (b == 0) ? a : gcd(b, a % b);
		}

		Fraction add(Fraction other) {
			return new Fraction(numerator * other.denominator + denominator * other.numerator,
					denominator * other.denominator);
		}

		Fraction subtract(Fraction other) {
			return new Fraction(numerator * other.denominator - denominator * other.numerator,
					denominator * other.denominator);
		}

		@Override
		public int compareTo(Fraction other) {
			return Long.compare(numerator * other.denominator, denominator * other.numerator);
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
	 * 直線を表すクラス
	 */
	static class Line {
		boolean vertical;
		Fraction slope, intercept;

		Line(long x1, long y1, long x2, long y2) {
			long x = x1 - x2;
			long y = y1 - y2;
			if (x == 0) {
				// 垂直な直線 x = x1
				vertical = true;
				slope = null;
				intercept = new Fraction(x1);
			} else {
				vertical = false;
				slope = new Fraction(y, x);
				intercept = new Fraction(y1).subtract(new Fraction(y * x1, x));
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Line other)) {
				return false;
			}
			if (vertical != other.vertical) {
				return false;
			}
			if (vertical) {
				return intercept.equals(other.intercept);
			}
			return slope.equals(other.slope) && intercept.equals(other.intercept);
		}

		@Override
		public int hashCode() {
			return Objects.hash(vertical, slope, intercept);
		}
	}
}
