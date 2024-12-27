package abc.abc201_250.abc236;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc236/editorial/3279 の小数誤差の実装<br/>
 * https://atcoder.jp/contests/abc236/submissions/28703951 にも参考
 */
public class ProblemE別回答 {

	/** 誤差 */
	private static final double EPS = 1E-4d;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int min = Arrays.stream(a).min().getAsInt(), max = Arrays.stream(a).max().getAsInt();
			{
				double ok = Math.max(min - 1, 1.0d), ng = max + 1;
				while (ng - ok > EPS) {
					double med = Math.sqrt(ok * ng);
					if (calc(Arrays.stream(a).mapToDouble(ai -> ai - med).toArray()) >= 0.0d) {
						ok = med;
					} else {
						ng = med;
					}
				}
				System.out.println(ok);
			}
			{
				int ok = min - 1, ng = max + 1;
				while (ng - ok > 1) {
					int med = (ok + ng) >> 1;
					if (calc(Arrays.stream(a).map(ai -> (ai >= med) ? 1 : -1).toArray()) > 0) {
						ok = med;
					} else {
						ng = med;
					}
				}
				System.out.println(ok);
			}
		}
	}

	/**
	 * 決められた選び方で、配列から選んだ数の合計の最大値を計算する
	 *
	 * @param b 配列
	 * @return 決められた選び方で、配列から選んだ数の合計の最大値
	 */
	private static double calc(double[] b) {
		double s = 0.0d, t = 0.0d;
		for (double bi : b) {
			double u = Math.max(s, t) + bi;
			s = t;
			t = u;
		}
		return Math.max(s, t);
	}

	/**
	 * 決められた選び方で、配列から選んだ数の合計の最大値を計算する
	 *
	 * @param b 配列
	 * @return 決められた選び方で、配列から選んだ数の合計の最大値
	 */
	private static int calc(int[] b) {
		int s = 0, t = 0;
		for (int bi : b) {
			int u = Math.max(s, t) + bi;
			s = t;
			t = u;
		}
		return Math.max(s, t);
	}
}
