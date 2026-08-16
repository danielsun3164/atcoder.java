package abc.abc201_250.abc228;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc228/editorial/2946 の解説の実装<br/>
 * https://atcoder.jp/contests/abc228/submissions/27341071 にも参考
 */
public class ProblemH {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt();
			Data[] ac = IntStream.range(0, n).mapToObj(i -> new Data(scanner.nextLong(), scanner.nextLong()))
					.sorted((p, q) -> (p.a == q.a) ? Long.compare(p.c, q.c) : Long.compare(p.a, q.a))
					.toArray(Data[]::new);
			ConvexHullTrick cht = new ConvexHullTrick();
			long sumC = 0L, subT = 0L, last = 0L;
			for (Data data : ac) {
				cht.addLine(new Line(-sumC, last));
				sumC += data.c;
				subT += data.a * data.c;
				last = cht.getMin(data.a) + sumC * data.a + x;
			}
			System.out.println(last - subT);
		}
	}

	/**
	 * floor(x/y) を計算する
	 *
	 * @param x
	 * @param y
	 * @return floor(x/y)
	 */
	private static long floorDiv(long x, long y) {
		return x / y - ((((x ^ y) < 0L) && (0 != x % y)) ? 1L : 0L);
	}

	/**
	 * a,cを格納するクラス
	 */
	private static class Data {
		long a, c;

		Data(long a, long c) {
			this.a = a;
			this.c = c;
		}
	}

	/**
	 * ax+bの線を表すクラス
	 */
	private static class Line {
		long a, b;

		Line(long a, long b) {
			this.a = a;
			this.b = b;
		}

		/**
		 * ax+bを計算する
		 *
		 * @param x
		 * @return ax+b
		 */
		long eval(long x) {
			return a * x + b;
		}
	}

	private static class ConvexHullTrick {
		Deque<Line> lines = new ArrayDeque<>();

		/**
		 * ax+bの線を追加する
		 *
		 * @param line ax+bの線
		 */
		void addLine(Line line) {
			while (lines.size() >= 2) {
				Line m = lines.pollLast(), n = lines.peekLast();
				lines.addLast(m);
				if (floorDiv(m.b - n.b, n.a - m.a) < floorDiv(line.b - m.b, m.a - line.a)) {
					break;
				}
				lines.pollLast();
			}
			lines.addLast(line);
		}

		/**
		 * min_{f(x)∈F} f(p) を計算する
		 *
		 * @param p
		 * @return min_{f(x)∈F} f(p)
		 */
		long getMin(long p) {
			while ((lines.size() >= 2) && eval(p)) {
				lines.pollFirst();
			}
			return lines.peekFirst().eval(p);
		}

		private boolean eval(long x) {
			Line m = lines.pollFirst(), n = lines.peekFirst();
			lines.addFirst(m);
			return m.eval(x) > n.eval(x);
		}
	}
}
