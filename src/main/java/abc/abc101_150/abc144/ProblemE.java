package abc.abc101_150.abc144;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).boxed().sorted((x, y) -> y.compareTo(x))
					.mapToInt(Integer::intValue).toArray();
			int[] f = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			long sumA = Arrays.stream(a).mapToLong(ai -> ai).sum();
			if (sumA <= k) {
				System.out.println(0);
			} else {
				long ng = 0, ok = Arrays.stream(a).max().getAsInt() * (long) Arrays.stream(f).max().getAsInt();
				while (ok - ng > 1L) {
					long med = (ok + ng) / 2L;
					if (isOk(a, f, k, med)) {
						ok = med;
					} else {
						ng = med;
					}
				}
				System.out.println(ok);
			}
		}
	}

	/**
	 * aとfの要素の積の最大値がk回の操作でx以内にできるかを計算する
	 *
	 * @param a
	 * @param f
	 * @param k
	 * @param x
	 * @return aとfの要素の積の最大値がk回の操作でx以内にできるか
	 */
	private static boolean isOk(int[] a, int[] f, long k, long x) {
		return IntStream.range(0, a.length).mapToLong(i -> Math.max(0L, a[i] - x / f[i])).sum() <= k;
	}
}
