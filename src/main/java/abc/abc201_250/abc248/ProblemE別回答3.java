package abc.abc201_250.abc248;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc248/editorial/3805 の実装<br/>
 * https://atcoder.jp/contests/abc248/submissions/30999281 にも参考
 */
public class ProblemE別回答3 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			if (1 == k) {
				System.out.println("Infinity");
				return;
			}
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			int[] cnt = new int[n + 1];
			IntStream.range(0, n).forEach(i -> {
				Map<Direction, Integer> memo = new HashMap<>();
				IntStream.range(0, n).forEach(j -> {
					long dx = x[j] - x[i], dy = y[j] - y[i];
					if ((0 != dx) || (0 != dy)) {
						long g = gcd(Math.abs(dx), Math.abs(dy));
						dx /= g;
						dy /= g;
						if (dx < 0 || (dx == 0 && dy < 0)) {
							dx = -dx;
							dy = -dy;
						}
						memo.merge(new Direction(dx, dy), 1, Integer::sum);
					}
				});
				memo.values().forEach(v -> cnt[v + 1]++);
			});
			System.out.println(IntStream.rangeClosed(k, n).map(i -> cnt[i] / i).sum());
		}
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
	 * 方向ベクトルを表すクラスです。
	 *
	 * <p>
	 * 方向ベクトルの各成分は最大公約数で約分され、符号も統一されます。 これにより、同じ直線方向を表すベクトルを同じキーとして扱えます。
	 * </p>
	 */
	static class Direction {
		long dx, dy;

		Direction(long dx, long dy) {
			this.dx = dx;
			this.dy = dy;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Direction other)) {
				return false;
			}
			return dx == other.dx && dy == other.dy;
		}

		@Override
		public int hashCode() {
			return Objects.hash(dx, dy);
		}
	}
}
