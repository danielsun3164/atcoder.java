package abc.abc151_200.abc159;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	/** 白チョコを表す文字 */
	private static final char WHITE = '1';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), k = scanner.nextInt();
			boolean[][] s = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> {
				char[] cs = scanner.next().toCharArray();
				IntStream.range(0, cs.length).forEach(j -> s[i][j] = (cs[j] == WHITE));
			});
			System.out.println(IntStream.range(0, (1 << (h - 1))).map(i -> {
				// 白チョコの数を格納する配列
				int[] counts = new int[Integer.bitCount(i) + 1];
				int result = Integer.bitCount(i);
				for (int j = 0; j < w; j++) {
					int[] now = calcNow(i, h, s, j);
					if (!check(now, k)) {
						return Integer.MAX_VALUE;
					}
					calcSum(counts, now);
					if (!check(counts, k)) {
						counts = now;
						result++;
					}
				}
				return result;
			}).min().getAsInt());
		}
	}

	/**
	 * チョコのj列目の白チョコの個数の配列を計算
	 *
	 * @param plan チョコを横に分割するプラン
	 * @param h    チョコの高さ
	 * @param s    チョコの配列
	 * @param j    チョコのj列目に対して計算
	 * @return チョコのj列目の白チョコの個数の配列
	 */
	private static int[] calcNow(final int plan, int h, boolean[][] s, int j) {
		int[] result = new int[Integer.bitCount(plan) + 1];
		Arrays.fill(result, 0);
		int index = 0;
		for (int i = 0; i < h; i++) {
			result[index] += (s[i][j]) ? 1 : 0;
			if (0 != ((1 << i) & plan)) {
				index++;
			}
		}
		return result;
	}

	/**
	 * 配列に最大値を超えたものが含まれないかを計算
	 *
	 * @param array 配列
	 * @param k     チョコの最大値
	 * @return 配列に最大値を超えたものが含まれないか
	 */
	private static boolean check(int[] array, int k) {
		return 0 == Arrays.stream(array).filter(ai -> ai > k).count();
	}

	/**
	 * 現在のチョコ数配列を合計用チョコ数配列に加算する
	 *
	 * @param counts 合計用チョコ数配列
	 * @param now    現在のチョコ数配列
	 */
	private static void calcSum(int[] counts, int[] now) {
		IntStream.range(0, Math.min(counts.length, now.length)).forEach(i -> counts[i] += now[i]);
	}
}
