package abc.abc101_150.abc149;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * 解法 1(二分探索を使った解法)の実装
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long m = scanner.nextLong();
			Integer[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().boxed().toArray(Integer[]::new);
			int ok = a[0], ng = (a[n - 1] << 1) + 1;
			while (ng > ok + 1) {
				int med = (ok + ng) >> 1;
				if (count(n, a, med) < m) {
					ng = med;
				} else {
					ok = med;
				}
			}
			long[] sum = new long[n + 1];
			sum[0] = 0L;
			IntStream.range(0, n).forEach(i -> sum[i + 1] = sum[i] + a[i]);
			System.out.println(calc(n, a, sum, ok) - (count(n, a, ok) - m) * ok);
		}
	}

	/**
	 * a_i+a_j>=valueとなるi,jのペアの数を数える
	 *
	 * @param n     数字の数
	 * @param a     配列
	 * @param value 指定された値
	 * @return a_i+a_j>=valueとなるi,jのペアの数
	 */
	private static long count(int n, Integer[] a, int value) {
		return IntStream.range(0, n).mapToLong(i -> {
			// lower_bound
			int index = Arrays.binarySearch(a, value - a[i], (x, y) -> (Integer.compare(x, y) >= 0) ? 1 : -1);
			index = (index < 0) ? ~index : index;
			return n - index;
		}).sum();
	}

	/**
	 * a_i+a_j>=valueとなるa_i+a_jの合計を計算する
	 *
	 * @param n     数字の数
	 * @param a     配列
	 * @param sum   合計の配列
	 * @param value 指定された値
	 * @return a_i+a_j>=valueとなるa_i+a_jの合計
	 */
	private static long calc(int n, Integer[] a, long[] sum, int value) {
		return IntStream.range(0, n).mapToLong(i -> {
			// lower_bound
			int index = Arrays.binarySearch(a, value - a[i], (x, y) -> (Integer.compare(x, y) >= 0) ? 1 : -1);
			index = (index < 0) ? ~index : index;
			return (n - index) * (long) a[i] + sum[n] - sum[index];
		}).sum();
	}
}
