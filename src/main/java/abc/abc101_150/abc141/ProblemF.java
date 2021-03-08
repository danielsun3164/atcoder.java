package abc.abc101_150.abc141;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc141/submissions/7511879 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n];
			// すべてをXORした結果を計算する
			long xorSum = IntStream.range(0, n).mapToLong(i -> a[i] = scanner.nextLong()).reduce(0, (x, y) -> x ^ y);
			// aをa'へ変換
			IntStream.range(0, n).forEach(i -> a[i] &= ~xorSum);
			int rank = 0;
			for (int i = 59; i >= 0; i--) {
				int j;
				for (j = rank; j < n; j++) {
					if ((a[j] & (1L << i)) > 0L) {
						break;
					}
				}
				if (j == n) {
					continue;
				}
				if (j > rank) {
					a[rank] ^= a[j];
				}
				for (j = rank + 1; j < n; j++) {
					a[j] = Math.min(a[j], a[j] ^ a[rank]);
				}
				rank++;
			}
			long x = Arrays.stream(a).reduce(0L, (y, ai) -> Math.max(y, y ^ ai));

			System.out.println((x << 1) + xorSum);
		}
	}
}
