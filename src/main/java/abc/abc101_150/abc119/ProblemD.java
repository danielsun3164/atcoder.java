package abc.abc101_150.abc119;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), q = scanner.nextInt();
			long[] s = IntStream.range(0, a).mapToLong(i -> scanner.nextLong()).toArray();
			long[] t = IntStream.range(0, b).mapToLong(i -> scanner.nextLong()).toArray();
			IntStream.range(0, q).mapToLong(i -> {
				long x = scanner.nextLong();
				return nearest(x, s, t);
			}).forEach(System.out::println);
		}
	}

	/**
	 * @param x
	 * @param s
	 * @param t
	 * @return xとsの要素の一つ、tの要素の一つの最短距離
	 */
	private static long nearest(long x, long[] s, long[] t) {
		long s1, s2, t1, t2;
		int sIndex = Arrays.binarySearch(s, x);
		int tIndex = Arrays.binarySearch(t, x);
		if (sIndex >= 0) {
			s1 = s2 = s[sIndex];
		} else {
			if (sIndex == -1) {
				s1 = s2 = s[0];
			} else if (sIndex == -s.length - 1) {
				s1 = s2 = s[s.length - 1];
			} else {
				s1 = s[~sIndex - 1];
				s2 = s[~sIndex];
			}
		}
		if (tIndex >= 0) {
			t1 = t2 = t[tIndex];
		} else {
			if (tIndex == -1) {
				t1 = t2 = t[0];
			} else if (tIndex == -t.length - 1) {
				t1 = t2 = t[t.length - 1];
			} else {
				t1 = t[~tIndex - 1];
				t2 = t[~tIndex];
			}
		}
		return min(distance(x, s1, t1), distance(x, s1, t2), distance(x, s2, t1), distance(x, s2, t2));
	}

	/**
	 * @param x
	 * @param s
	 * @param t
	 * @return xとs、tとの最短距離
	 */
	private static long distance(long x, long s, long t) {
		return Math.abs(s - t) + min(Math.abs(s - x), Math.abs(t - x));
	}

	/**
	 * @param x 配列
	 * @return 配列の最小値
	 */
	private static long min(long... x) {
		return Arrays.stream(x).min().getAsLong();
	}
}
