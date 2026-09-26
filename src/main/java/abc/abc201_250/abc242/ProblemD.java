package abc.abc201_250.abc242;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	private static final int[][] MAP = { { 1, 2 }, { 2, 0 }, { 0, 1 } };
	private static final int[][] MAP2 = { { 0, 1, 2 }, { 1, 2, 0 }, { 2, 0, 1 } };
	private static final char A = 'A';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int[] sn = new int[s.length];
			IntStream.range(0, s.length).forEach(i -> sn[i] = s[i] - A);
			int q = scanner.nextInt();
			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				long t = scanner.nextLong(), k = scanner.nextLong() - 1;
				sb.append((char) (calc(sn, t, k) + 'A')).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * s^tのk文字目を計算する
	 *
	 * @param sn sを表す配列
	 * @param t
	 * @param k
	 * @return s^tのk文字目
	 */
	private static int calc(int[] sn, long t, long k) {
		if (0 == t) {
			return sn[(int) k];
		}
		if (0 == k) {
			return MAP2[sn[0]][(int) (t % 3)];
		}
		return MAP[calc(sn, t - 1, k / 2)][(int) (1 & k)];
	}
}
