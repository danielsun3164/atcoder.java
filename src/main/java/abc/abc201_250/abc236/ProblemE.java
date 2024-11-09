package abc.abc201_250.abc236;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc236/editorial/3279 の倍数誤差の実装<br/>
 * https://atcoder.jp/contests/abc236/submissions/28703971 にも参考
 */
public class ProblemE {

	/** 誤差の倍率 */
	private static final long N = 10_000L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long min = Arrays.stream(a).min().getAsLong(), max = Arrays.stream(a).max().getAsLong();
			long ok = min * N - 1, ng = max * N + 1;
			while (ng - ok > 1L) {
				long med = (ok + ng) >> 1;
				if (calc(Arrays.stream(a).map(ai -> ai * N - med).toArray()) >= 0L) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(ok / (double) N);
			ok = min - 1;
			ng = max + 1;
			while (ng - ok > 1L) {
				long med = (ok + ng) >> 1;
				if (calc(Arrays.stream(a).map(ai -> (ai >= med) ? 1 : -1).toArray()) > 0L) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(ok);
		}
	}

	/**
	 * 決められた選び方で、配列から選んだ数の合計の最大値を計算する
	 *
	 * @param b 配列
	 * @return 決められた選び方で、配列から選んだ数の合計の最大値
	 */
	private static long calc(long[] b) {
		long s = 0L, t = 0L;
		for (long bi : b) {
			long u = Math.max(s, t) + bi;
			s = t;
			t = u;
		}
		return Math.max(s, t);
	}
}
