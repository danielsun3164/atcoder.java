package abc.abc201_250.abc241;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/3472 の解法1の実装
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			long[] a = new long[n], sum = new long[n + 1];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextLong());
			Arrays.fill(sum, 0L);
			int[] pre = new int[n];
			Arrays.fill(pre, -1);
			pre[0] = 0;
			int s = 0, t = 0;
			for (int i = 0; i < n; i++) {
				sum[i + 1] = sum[i] + a[(int) (sum[i] % n)];
				if (-1 != pre[(int) (sum[i + 1] % n)]) {
					s = pre[(int) (sum[i + 1] % n)];
					t = i + 1;
					break;
				}
				pre[(int) (sum[i + 1] % n)] = i + 1;
			}
			long answer;
			if (k <= s) {
				answer = sum[(int) k];
			} else {
				int p = t - s;
				long x = sum[t] - sum[s];
				long d = (k - s - 1) / p, b = (k - s - 1) % p;
				answer = sum[(int) (s + b + 1)] + d * x;
			}
			System.out.println(answer);
		}
	}
}
