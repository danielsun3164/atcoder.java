package other.typical90;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Problem009 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			System.out.println(Math.toDegrees(IntStream.range(0, n).mapToDouble(i -> {
				NavigableSet<Double> set = new TreeSet<>();
				IntStream.range(0, n).filter(j -> j != i).forEach(j -> set.add(Math.atan2(y[j] - y[i], x[j] - x[i])));
				return set.stream().mapToDouble(value -> {
					double symmetric = (value < 0) ? value + Math.PI : value - Math.PI;
					double max = Double.MIN_VALUE;
					Double ceiling = set.ceiling(symmetric);
					if (null != ceiling) {
						double diff = Math.abs(ceiling - value);
						if (diff > Math.PI) {
							diff = (Math.PI * 2.0d) - diff;
						}
						max = Math.max(max, diff);
					}
					Double floor = set.floor(symmetric);
					if (null != floor) {
						double diff = Math.abs(floor - value);
						if (diff > Math.PI) {
							diff = (Math.PI * 2.0d) - diff;
						}
						max = Math.max(max, diff);
					}
					return max;
				}).max().getAsDouble();
			}).max().getAsDouble()));
		}
	}
}
