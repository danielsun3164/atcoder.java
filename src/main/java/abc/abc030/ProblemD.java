package abc.abc030;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 一部はabc013の問題Dを参考に実装したソースコード<br/>
 * 一部は解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt() - 1;
			BigInteger k = scanner.nextBigInteger();
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			int[] count = new int[n];
			Arrays.fill(count, -1);
			count[a] = 0;
			int c = 0, t = 0;
			int now = a;
			for (int i = 1; i <= n; i++) {
				now = b[now];
				if (count[now] >= 0) {
					t = count[now];
					c = i - count[now];
				} else {
					count[now] = i;
				}
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
		return IntStream.range(0, a.length).map(i -> a[b[i]]).toArray();
	}
}
