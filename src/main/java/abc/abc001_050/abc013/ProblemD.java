package abc.abc001_050.abc013;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), d = scanner.nextInt();
			int[] a = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			// 1回分阿弥陀くじを計算
			int[] t = IntStream.rangeClosed(1, n).toArray();
			for (int i = m - 1; i >= 0; i--) {
				int to = a[i];
				int temp = t[to];
				t[to] = t[to - 1];
				t[to - 1] = temp;
			}
			// d回分を計算
			int[] result = pow(t, d);
			Arrays.stream(result).forEach(System.out::println);
		}
	}

	/**
	 * @param t
	 * @param d
	 * @return T_dの配列。
	 */
	private static int[] pow(int[] t, int d) {
		// 結果
		int[] result = null;
		// 一つ前の結果
		int[] prevResult = null;
		for (int i = 0; i <= Math.ceil(Math.log(d) / Math.log(2)); i++) {
			if (null == prevResult) {
				prevResult = t;
			} else {
				prevResult = multipy(prevResult, prevResult);
			}
			if ((d & (0x1 << i)) != 0) {
				if (null != result) {
					result = multipy(result, prevResult);
				} else {
					result = prevResult;
				}
			}
		}
		return result;
	}

	/**
	 * @param a t_aの配列
	 * @param b t_bの配列
	 * @return t_a[t_b]の配列
	 */
	private static int[] multipy(int[] a, int[] b) {
		return IntStream.rangeClosed(1, a.length).map(i -> a[b[i - 1] - 1]).toArray();
	}
}
