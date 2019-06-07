package abc016;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc016/submissions/4575025 を参考に作成
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Line line = new Line(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			int n = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			Line[] lines = new Line[n];
			lines[0] = new Line(x[n - 1], y[n - 1], x[0], y[0]);
			IntStream.range(1, n).forEach(i -> lines[i] = new Line(x[i - 1], y[i - 1], x[i], y[i]));
			System.out.println(IntStream.range(0, n).filter(i -> line.intersect(lines[i])).count() / 2 + 1);
		}
	}

	private static class Line {
		int startX;
		int startY;
		int endX;
		int endY;

		Line(int startX, int startY, int endX, int endY) {
			super();
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}

		/**
		 * @param line 指定された線
		 * @return 現在の線と指定された線が交わるかどうか
		 */
		boolean intersect(Line line) {
			long t1 = ((line.startY - startY) * (endX - startX) - (line.startX - startX) * (endY - startY));
			long t2 = ((line.endY - startY) * (endX - startX) - (line.endX - startX) * (endY - startY));
			long t3 = ((startY - line.startY) * (line.endX - line.startX)
					- (startX - line.startX) * (line.endY - line.startY));
			long t4 = ((endY - line.startY) * (line.endX - line.startX)
					- (endX - line.startX) * (line.endY - line.startY));
			return (t1 * t2 < 0) && (t3 * t4 < 0);
		}
	}

	// Line2Dを使用した実装
//	public static void main(String[] args) {
//		try (Scanner scanner = new Scanner(System.in)) {
//			Line2D line = new Line2D.Double(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(),
//					scanner.nextDouble());
//			int n = scanner.nextInt();
//			double[] x = new double[n], y = new double[n];
//			IntStream.range(0, n).forEach(i -> {
//				x[i] = scanner.nextDouble();
//				y[i] = scanner.nextDouble();
//			});
//			Line2D[] lines = new Line2D[n];
//			lines[0] = new Line2D.Double(x[n - 1], y[n - 1], x[0], y[0]);
//			IntStream.range(1, n).forEach(i -> lines[i] = new Line2D.Double(x[i - 1], y[i - 1], x[i], y[i]));
//			System.out.println(IntStream.range(0, n).filter(i -> line.intersectsLine(lines[i])).count() / 2 + 1);
//		}
//	}
}
