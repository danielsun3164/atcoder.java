package abc.abc001_050.abc016;

import java.awt.geom.Line2D;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Line2Dを使用した実装
 */
public class ProblemD別回答 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Line2D line = new Line2D.Double(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(),
					scanner.nextDouble());
			int n = scanner.nextInt();
			double[] x = new double[n], y = new double[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextDouble();
				y[i] = scanner.nextDouble();
			});
			Line2D[] lines = new Line2D[n];
			lines[0] = new Line2D.Double(x[n - 1], y[n - 1], x[0], y[0]);
			IntStream.range(1, n).forEach(i -> lines[i] = new Line2D.Double(x[i - 1], y[i - 1], x[i], y[i]));
			System.out.println(IntStream.range(0, n).filter(i -> line.intersectsLine(lines[i])).count() / 2 + 1);
		}
	}
}
