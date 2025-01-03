package abc.abc201_250.abc220;

import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc220/submissions/26111021 にも参考
 */
public class ProblemG {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Point[] points = IntStream.range(0, n)
					.mapToObj(i -> new Point(scanner.nextLong(), scanner.nextLong(), scanner.nextLong()))
					.toArray(Point[]::new);
			Data[] datas = IntStream.range(0, n)
					.mapToObj(i -> IntStream.range(i + 1, n).mapToObj(j -> calc(points[i], points[j])))
					.flatMap(stream -> stream).sorted((a, b) -> a.line.compareTo(b.line)).toArray(Data[]::new);
			Data zero = new Data(new Line(0L, 0L, 0L), 0L, 0L, -INF);
			Data prev = zero;
			long answer = -1;
			for (int i = 0; i < datas.length; i++) {
				if ((i > 0) && !datas[i].line.equals(datas[i - 1].line)) {
					prev = zero;
				}
				if ((prev.x == datas[i].x) && (prev.y == datas[i].y)) {
					if (prev.sumc < datas[i].sumc) {
						prev = datas[i];
					}
				} else {
					answer = Math.max(answer, prev.sumc + datas[i].sumc);
					if (prev.sumc < datas[i].sumc) {
						prev = datas[i];
					}
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0L == a) ? b : gcd(b % a, a);
	}

	/**
	 * 点aと点bをつなぐ線を計算する
	 *
	 * @param a
	 * @param b
	 * @return 点aと点bをつなぐ線
	 */
	private static Data calc(Point a, Point b) {
		return new Data(
				norm(new Line((b.x - a.x) << 1, (b.y - a.y) << 1, a.x * a.x + a.y * a.y - b.x * b.x - b.y * b.y)),
				a.x + b.x, a.y + b.y, a.c + b.c);
	}

	/**
	 * 線のa,b,cを一般化処理を行う
	 *
	 * @param line 線
	 * @return 一般化処理した線
	 */
	private static Line norm(Line line) {
		long g = gcd(gcd(Math.abs(line.a), Math.abs(line.b)), Math.abs(line.c));
		line.a /= g;
		line.b /= g;
		line.c /= g;
		if (0L == line.a) {
			if (line.b < 0L) {
				line.a = -line.a;
				line.b = -line.b;
				line.c = -line.c;
			}
		} else {
			if (line.a < 0L) {
				line.a = -line.a;
				line.b = -line.b;
				line.c = -line.c;
			}
		}
		return line;
	}

	/**
	 * 線を表すクラス
	 *
	 * ax + by + c = 0 で表す
	 */
	private static class Line implements Comparable<Line> {
		long a, b, c;

		Line(long a, long b, long c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Line o) {
			if (a == o.a) {
				if (b == o.b) {
					return Long.compare(c, o.c);
				}
				return Long.compare(b, o.b);
			}
			return Long.compare(a, o.a);
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Line line) {
				return (a == line.a) && (b == line.b) && (c == line.c);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(a, b, c);
		}
	}

	/**
	 * 点を表すクラス
	 */
	private static class Point {
		long x, y, c;

		Point(long x, long y, long c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	/**
	 * 線と点の組み合わせを表すクラス
	 */
	private static class Data {
		Line line;
		long x, y, sumc;

		Data(Line line, long x, long y, long sumc) {
			this.line = line;
			this.x = x;
			this.y = y;
			this.sumc = sumc;
		}
	}
}
