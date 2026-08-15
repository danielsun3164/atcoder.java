package abc.abc201_250.abc240;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc240/editorial/3425 の実装
 */
public class ProblemF別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			long[] result = new long[t];
			IntStream.range(0, t).forEach(k -> {
				@SuppressWarnings("unused")
				int n = scanner.nextInt(), m = scanner.nextInt();
				long cv = 0L, cx = 0L, answer = Long.MIN_VALUE;
				for (int i = 0; i < n; i++) {
					int x = scanner.nextInt();
					long y = scanner.nextLong(), vl = cv + x, vr = cv + x * y;
					if (x != 0) {
						if ((vl >= 0L) && (vr <= 0L)) {
							long pt = -cv / x;
							answer = Math.max(answer, cx + sum(vl, cv + x * pt, pt));
						}
					}
					cv = vr;
					answer = Math.max(answer, cx + vl);
					cx += sum(vl, vr, y);
					answer = Math.max(answer, cx);
				}
				result[k] = answer;
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, t).forEach(i -> sb.append(result[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	private static long sum(long l, long r, long count) {
		return (l + r) * count / 2L;
	}
}
