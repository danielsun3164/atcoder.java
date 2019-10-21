package abc062;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 何分割するか */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long h = scanner.nextLong();
			long w = scanner.nextLong();
			long[] s = new long[N];
			System.out.println(Math.min(getResult(h, w, s, N), getResult(w, h, s, N)));
		}
	}

	/**
	 * https://atcoder.jp/contests/abc062/submissions/7236184 を参考に作成<br/>
	 * h,wとw,hの組合せで計算
	 * 
	 * @param h 高さ
	 * @param w 幅
	 * @param s 結果の配列
	 * @param n 何分割するか
	 * @return 結果の最大値と最小値の差分
	 */
	private static long getResult(final long h, final long w, final long[] s, int n) {
		if (1 == n) {
			s[N - n] = h * w;
			return Arrays.stream(s).max().getAsLong() - Arrays.stream(s).min().getAsLong();
		}
		if ((0 == (h % n)) || (0 == (w % n))) {
			IntStream.range(N - n, N).forEach(i -> s[i] = h * w / n);
			return Arrays.stream(s).max().getAsLong() - Arrays.stream(s).min().getAsLong();
		} else {
			return IntStream.rangeClosed(-(n - 1), (n - 1)).mapToLong(i -> {
				s[N - n] = (h / n + i) * w;
				return Math.min(getResult(h - h / n - i, w, s, n - 1), getResult(w, h - h / n - i, s, n - 1));
			}).min().getAsLong();
		}
	}
}
