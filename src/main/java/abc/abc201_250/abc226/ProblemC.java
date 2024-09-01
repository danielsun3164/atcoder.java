package abc.abc201_250.abc226;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] t = new long[n];
			int[] k = new int[n];
			int[][] a = new int[n][];
			IntStream.range(0, n).forEach(i -> {
				t[i] = scanner.nextLong();
				k[i] = scanner.nextInt();
				a[i] = IntStream.range(0, k[i]).map(j -> scanner.nextInt() - 1).toArray();
			});
			boolean[] learned = new boolean[n];
			Arrays.fill(learned, false);
			System.out.println(calc(t, k, a, learned, n - 1));
		}
	}

	/**
	 * 計算対象の技を習得するために必要な時間を計算する
	 *
	 * @param t       習得するための時間の配列
	 * @param k       習得するための前提技の数の配列
	 * @param a       習得するための前提技の配列
	 * @param learned 習得したかどうかの配列
	 * @param now     計算対象の技
	 * @return 計算対象の技を習得するために必要な時間
	 */
	private static long calc(long[] t, int[] k, int[][] a, boolean[] learned, int now) {
		long result = t[now];
		learned[now] = true;
		for (int ai : a[now]) {
			if (!learned[ai]) {
				result += calc(t, k, a, learned, ai);
			}
		}
		return result;
	}
}
