package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem028別回答 {

	/** xとyの最大値 */
	private static final int N = 1000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			CumulativeSum2D cs = new CumulativeSum2D(N + 1, N + 1);
			IntStream.range(0, n).forEach(
					i -> cs.add(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), 1));
			cs.build();
			int[] counts = new int[n + 1];
			Arrays.fill(counts, 0);
			IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> counts[cs.get(i, j)]++));
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(1, n).forEach(i -> sb.append(counts[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 二次元累積和<br/>
	 * https://github.com/NyaanNyaan/library/blob/master/data-structure-2d/2d-cumulative-sum.hpp を参考に作成
	 *
	 * TLE対策のため、IntStreamのかわりにfor文を使用する
	 */
	private static class CumulativeSum2D {

		final int[][] data;

		CumulativeSum2D(int h, int w) {
			data = new int[h + 2][w + 2];
			IntStream.range(0, h + 2).forEach(i -> Arrays.fill(data[i], 0));
		}

		void add(int x, int y, int value) {
			if (((x + 1) < data.length) && ((y + 1) < data[0].length)) {
				data[x + 1][y + 1] += value;
			}
		}

		void add(int x1, int y1, int x2, int y2, int value) {
			add(x1, y1, value);
			add(x1, y2, -value);
			add(x2, y1, -value);
			add(x2, y2, value);
		}

		void build() {
			for (int i = 1; i < data.length; i++) {
				for (int j = 1; j < data[i].length; j++) {
					data[i][j] += data[i][j - 1] + data[i - 1][j] - data[i - 1][j - 1];
				}
			}
		}

		/**
		 * imos (x,y) を取得
		 *
		 * @param x
		 * @param y
		 * @return (x,y)
		 */
		int get(int x, int y) {
			return data[x + 1][y + 1];
		}

		/**
		 * [(x1,y1)~(x2,y2))の範囲の合計値を計算する
		 *
		 * @param x1
		 * @param y1
		 * @param x2
		 * @param y2
		 * @return [(x1,y1)~(x2,y2))の範囲の合計値
		 */
		@SuppressWarnings("unused")
		int query(int x1, int y1, int x2, int y2) {
			return data[x2][y2] - data[x1][y2] - data[x2][y1] + data[x1][y1];
		}
	}
}
