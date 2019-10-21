package abc063;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int[] h = new int[n];
			int max = IntStream.range(0, n).map(i -> h[i] = scanner.nextInt()).max().getAsInt();
			int high = (max + b - 1) / b, low = 0;
			while (high > low + 1) {
				int middle = (high + low) / 2;
				if (enough(middle, h, a, b)) {
					high = middle;
				} else {
					low = middle;
				}
			}
			System.out.println(high);
		}
	}

	/**
	 * @param t 爆発回数
	 * @param h 怪物のHPの配列
	 * @param a 爆発の個体破壊力
	 * @param b 爆発の全体破壊力
	 * @return t回の爆発ですべての怪物が倒せるかどうか
	 */
	private static boolean enough(final int t, final int[] h, final int a, final int b) {
		return Arrays.stream(h).mapToLong(hi -> ((hi - b * t) + (a - b) - 1) / (a - b)).map(i -> (i > 0) ? i : 0)
				.sum() <= t;
	}
}
