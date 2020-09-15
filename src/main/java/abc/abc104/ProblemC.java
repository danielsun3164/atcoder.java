package abc.abc104;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int d = scanner.nextInt(), g = scanner.nextInt();
			Score[] s = IntStream.range(0, d)
					.mapToObj(i -> new Score((i + 1) * 100, scanner.nextInt(), scanner.nextInt())).sorted()
					.toArray(Score[]::new);
			System.out.println(IntStream.range(1, 1 << d).map(i -> getProblemNo(i, s, g)).min().getAsInt());
		}
	}

	/**
	 * 目標スコアが達成させるための解く問題数を計算する
	 * 
	 * @param mask 使用する問題の2進数表現
	 * @param s    問題数とスコア数の配列
	 * @param g    目標スコア
	 * @return 目標スコアが達成させるための解く問題数
	 */
	private static int getProblemNo(int mask, Score[] s, int g) {
		int result = 0;
		for (int i = 0; i < s.length; i++) {
			if ((mask & (1 << i)) > 0) {
				if (g > s[i].max) {
					result += s[i].count;
					g -= s[i].max;
				} else {
					int index = Arrays.binarySearch(s[i].scores, g);
					if (index < 0) {
						index = ~index;
					}
					result += index + 1;
					return result;
				}
			}
		}
		// 達成できない場合
		return Integer.MAX_VALUE;
	}

	/**
	 * 問題数とスコアを表すクラス
	 */
	private static class Score implements Comparable<Score> {
		/** 問題数 */
		int count;
		/** スコアの配列 */
		int[] scores;
		/** 完成したときのスコア数 */
		int max;

		/**
		 * コンストラクタ
		 * 
		 * @param n 1問あたりのスコア
		 * @param p 問題数
		 * @param c ボーナススコア
		 */
		Score(int n, int p, int c) {
			scores = new int[count = p];
			IntStream.range(0, p - 1).forEach(i -> scores[i] = (i + 1) * n);
			scores[p - 1] = max = p * n + c;
		}

		@Override
		public int compareTo(Score score) {
			// 問題を完了させたときのスコア数/問題数 で降順でソート
			return Double.compare(((double) score.max) / score.count, ((double) this.max) / this.count);
		}
	}
}
