package abc091;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc091/submissions/5275478 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n], b = new int[n];
			int[] na = new int[n], nb = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			IntStream.range(0, n).forEach(i -> b[i] = scanner.nextInt());
			int answer = 0;
			for (int k = 0; k < 30; k++) {
				int mask = (1 << (k + 1)) - 1;
				for (int i = 0; i < n; i++) {
					na[i] = a[i] & mask;
					nb[i] = b[i] & mask;
				}
				Arrays.sort(nb);
				int count = 0;
				for (int i = 0; i < n; i++) {
					count += lowerBound(nb, (2 << k) - na[i]) - lowerBound(nb, (1 << k) - na[i]);
					count += n - lowerBound(nb, (3 << k) - na[i]);
					count &= 1;
				}
				if (1 == (count & 1)) {
					answer |= 1 << k;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * 配列aにおける値vのlowerBoundを計算する
	 * 
	 * @param a
	 * @param v
	 * @return 配列aにおける値vのlowerBound
	 */
	private static int lowerBound(int a[], int v) {
		int l = 0, r = a.length - 1;
		while (r - l >= 0) {
			int c = (l + r) / 2;
			if (v <= a[c]) {
				r = c - 1;
			} else {
				l = c + 1;
			}
		}
		return l;
	}
}
