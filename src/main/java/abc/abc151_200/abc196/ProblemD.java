package abc.abc151_200.abc196;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(dfs(0, 0, h, w, a, b, 0));
		}
	}

	/**
	 * 結果を計算する
	 *
	 * @param i      現在計算中の場所
	 * @param bit    i桁目が1は計算済みのビット表現
	 * @param h
	 * @param w
	 * @param a      2x1の枚数
	 * @param b      1x1の枚数
	 * @param answer 現在までの計算結果
	 * @return 結果
	 */
	private static int dfs(int i, int bit, final int h, final int w, int a, int b, int answer) {
		if (i == h * w) {
			return answer + 1;
		}
		if ((bit & (1 << i)) > 0) {
			// 現在の場所がすでに計算済の場合次の場所を計算する
			return dfs(i + 1, bit, h, w, a, b, answer);
		}
		if (b > 0) {
			// 現在の場所を1x1を置く場合の置き方を計算する
			answer = dfs(i + 1, bit | (1 << i), h, w, a, b - 1, answer);
		}
		if (a > 0) {
			if ((i % w < w - 1) && (0 == (bit & (1 << (i + 1))))) {
				// 現在の場所を2x1を横に置く場合の置き方を計算する
				answer = dfs(i + 1, bit | (1 << i) | (1 << (i + 1)), h, w, a - 1, b, answer);
			}
			if (i + w < h * w) {
				// 現在の場所を2x1を縦に置く場合の置き方を計算する
				answer = dfs(i + 1, bit | (1 << i) | 1 << (i + w), h, w, a - 1, b, answer);
			}
		}
		return answer;
	}
}
