package abc.abc201_250.abc226;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc226/editorial/2894 の実装<br/>
 * https://atcoder.jp/contests/abc226/submissions/27050643 にも参考
 */
public class ProblemG {

	/** 数字の数 */
	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (t-- > 0) {
				long[] a = new long[N + 1], b = new long[N + 1];
				a[0] = b[0] = 0L;
				IntStream.rangeClosed(1, N).forEach(i -> a[i] = scanner.nextLong());
				IntStream.rangeClosed(1, N).forEach(i -> b[i] = scanner.nextLong());
				IntStream.range(0, N).map(i -> N - i).forEach(i -> {
					long x = Math.min(a[i], b[i]);
					a[i] -= x;
					b[i] -= x;
					IntStream.rangeClosed(0, N - i).map(j -> N - j).forEach(j -> {
						long y = Math.min(a[i], b[j]);
						a[i] -= y;
						b[j] -= y;
						b[j - i] += y;
					});
				});
				sb.append((IntStream.rangeClosed(1, N).filter(i -> a[i] > 0).count() > 0L) ? "No" : "Yes")
						.append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
