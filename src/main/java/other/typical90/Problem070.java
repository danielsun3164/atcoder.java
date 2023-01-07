package other.typical90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem070 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			System.out.println(calc(x) + calc(y));
		}
	}

	/**
	 * 座標の一覧に対してのマンハッタン距離の総和の最小値を計算する
	 *
	 * @param x 座標の一覧
	 * @return マンハッタン距離の総和の最小値
	 */
	private static long calc(long[] x) {
		List<Long> list = new ArrayList<>();
		int n = x.length;
		long sum = Arrays.stream(x).sum();
		// 平均値
		list.add(sum / n);
		if (0L != sum % n) {
			list.add(sum / n + 1);
		}
		Arrays.sort(x);
		// 中央値
		list.add(x[n / 2]);
		if (0 == (n & 1)) {
			list.add(x[n / 2 - 1]);
		}
		return list.stream().mapToLong(li -> calcDiff(x, li)).min().getAsLong();
	}

	/**
	 * 座標の一覧に対してのマンハッタン距離の総和を計算する
	 *
	 * @param x    座標の一覧
	 * @param base 基準となる点の座標
	 * @return マンハッタン距離の総和の最小値
	 */
	private static long calcDiff(long[] x, long base) {
		return Arrays.stream(x).map(xi -> Math.abs(xi - base)).sum();
	}
}
