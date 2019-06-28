package abc030;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 一部はabc013の問題Dを参考に実装したソースコード<br/>
 * 一部は解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = scanner.nextInt() - 1;
			BigInteger k = scanner.nextBigInteger();
			int[] b = new int[n];
			IntStream.range(0, n).forEach(i -> b[i] = scanner.nextInt() - 1);
			// https://atcoder.jp/contests/abc030/submissions/4441487 を参考にcとtを計算
			int c = 0, t = 0;
			int i1 = a, i2 = a;
			do {
				i1 = b[i1];
				i2 = b[b[i2]];
				c++;
			} while (i1 != i2);
			int i3 = a;
			while (i1 != i3) {
				i1 = b[i1];
				i3 = b[i3];
				t++;
			}
			int newK = 0;
			if (k.compareTo(BigInteger.valueOf(t)) <= 0) {
				newK = k.intValue();
			} else {
				// (k-t) mod c + t 回分を計算
				newK = k.subtract(BigInteger.valueOf(t)).mod(BigInteger.valueOf(c)).add(BigInteger.valueOf(t))
						.intValue();
			}
			if (newK == 0) {
				newK = t + c;
			}
			int[] result = pow(b, newK);
			System.out.println(result[a] + 1);
		}
	}

	/**
	 * @param t 変換配列
	 * @param k 回数
	 * @return tをd回変換する配列
	 */
	private static int[] pow(int[] t, int k) {
		// 結果
		int[] result = null;
		while (k > 0) {
			if (1 == (k & 1)) {
				result = multipy(result, t);
			}
			t = multipy(t, t);
			k >>= 1;
		}
		return result;
	}

	/**
	 * @param a t_aの配列
	 * @param b t_bの配列
	 * @return t_a[t_b]の配列
	 */
	private static int[] multipy(int[] a, int[] b) {
		if (null == a) {
			return b;
		}
		int[] result = new int[a.length];
		IntStream.range(0, a.length).forEach(i -> result[i] = a[b[i]]);
		return result;
	}
}
