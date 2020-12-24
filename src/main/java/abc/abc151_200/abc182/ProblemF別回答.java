package abc.abc151_200.abc182;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc182/submissions/18165477 に参考してに実装したソースコード
 */
public class ProblemF別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long x = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			byte[] type = new byte[n];
			long[] b = new long[n];
			for (int i = n - 1; i >= 0; i--) {
				b[i] = x / a[i];
				x %= a[i];
				if (0 == b[i]) {
					type[i] = 0x3;
				} else if ((i < n - 1) && (b[i] == a[i + 1] / a[i] - 1)) {
					type[i] = 0x2;
				} else {
					type[i] = 0x1;
				}
			}
			long t0 = 1L, t1 = 0L;
			for (int i = 0; i < n - 1; i++) {
				if (0x1 == type[i]) {
					t0 = t0 + t1;
					t1 = t0;
				} else if (0x2 == type[i]) {
					t1 = t0 + t1;
				} else {
					t0 = t0 + t1;
				}
			}
			System.out.println(t0 + t1);
		}
	}
}
