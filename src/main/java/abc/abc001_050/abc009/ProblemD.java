package abc.abc001_050.abc009;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 32bitの1 */
	private static long ONE = 0xffffffffL;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt(), m = scanner.nextInt();
			long[] a = IntStream.range(0, k).mapToLong(i -> scanner.nextLong()).toArray();
			long[] c = IntStream.range(0, k).mapToLong(i -> scanner.nextLong()).toArray();
			if (m <= k) {
				System.out.println(a[m - 1]);
			} else {
				// ( a_k )
				// ...
				// ( a_1 )
				// の行列を表す配列
				long[][] ak = new long[k][1];
				IntStream.range(0, k).forEach(i -> ak[i][0] = a[k - i - 1]);
				// ( c_1 -> c_k )
				// ( 1 0 ... 0 0 )
				// ...
				// ( 0 0 ... 1 0 )
				// の行列を表す配列
				long[][] ck = new long[k][k];
				ck[0] = c.clone();
				IntStream.range(1, k)
						.forEach(i -> IntStream.range(0, k).forEach(j -> ck[i][j] = (j == i - 1) ? ONE : 0L));
				System.out.println(multipy(pow(ck, m - k), ak)[0][0]);
			}
		}
	}

	/**
	 * @param a
	 * @param b
	 * @return 行列a x 行列bの結果。ただし、掛け算はAND、足し算はXORで計算をする
	 */
	private static long[][] multipy(long[][] a, long[][] b) {
		if (a[0].length == b.length) {
			int m = a.length, n = b[0].length, p = b.length;
			long[][] result = new long[m][n];
			IntStream.range(0, m).forEach(i -> IntStream.range(0, n).forEach(j -> {
				// i,j の要素はaのi行目とbのj列目の要素の積の合計
				result[i][j] = 0;
				IntStream.range(0, p).forEach(k -> result[i][j] ^= a[i][k] & b[k][j]);
			}));
			return result;
		}
		return null;
	}

	/**
	 * @param a
	 * @param b
	 * @return 行列a の bべき乗。ただし、掛け算はAND、足し算はXORで計算をする
	 */
	private static long[][] pow(long[][] a, int b) {
		// 結果
		long[][] result = null;
		while (b > 0) {
			if (1 == (1 & b)) {
				if (null != result) {
					result = multipy(result, a);
				} else {
					result = a;
				}
			}
			a = multipy(a, a);
			b >>= 1;
		}
		return result;
	}
}
