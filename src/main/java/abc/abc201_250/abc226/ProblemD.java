package abc.abc201_250.abc226;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			Set<Data> set = new HashSet<>();
			IntStream.range(0, n).forEach(i -> IntStream.range(i + 1, n).forEach(j -> {
				long dx = x[i] - x[j], dy = y[i] - y[j];
				long g = gcd(dx, dy);
				set.add(new Data(dx / g, dy / g));
				set.add(new Data(-dx / g, -dy / g));
			}));
			System.out.println(set.size());
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
		return (0L == b) ? a : gcd(b, a % b);
	}

	private static class Data {
		long x, y;

		Data(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Data data) {
				return (x == data.x) && (y == data.y);
			}
			return false;
		}
	}
}
