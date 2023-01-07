package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem060 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] p = lis(a), q = reverse(lis(reverse(a)));
			System.out.println(IntStream.range(0, n).map(i -> p[i] + q[i] - 1).max().getAsInt());
		}
	}

	/**
	 * 入力配列の最長増加部分列(LIS)の長さの配列を計算する
	 *
	 * @param a 配列
	 * @return 入力配列の最長増加部分列(LIS)の長さの配列
	 */
	private static int[] lis(int[] a) {
		int n = a.length;
		int[] p = new int[n];
		Integer[] lis = new Integer[n];
		Arrays.fill(p, 0);
		Arrays.fill(lis, Integer.MAX_VALUE >> 1);
		IntStream.range(0, n).forEach(i -> {
			int index = ~Arrays.binarySearch(lis, a[i], (x, y) -> (x.compareTo(y) >= 0) ? 1 : -1);
			lis[index] = a[i];
			p[i] = index + 1;
		});
		return p;
	}

	/**
	 * 入力配列の逆順の配列を計算する
	 *
	 * @param a 配列
	 * @return 入力配列の逆順の配列
	 */
	private static int[] reverse(int[] a) {
		int n = a.length;
		return IntStream.range(0, n).map(i -> a[n - 1 - i]).toArray();
	}
}
