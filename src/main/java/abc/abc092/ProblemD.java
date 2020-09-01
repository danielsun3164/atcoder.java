package abc.abc092;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 */
public class ProblemD {

	/** 構築時に使う定数 */
	private static final int K = 50;
	/** 白いコマを表す文字 */
	private static final char WHITE = '.';
	/** 黒いコマを表す文字 */
	private static final char BLACK = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			// 2K × 2K のグリッドを用意する。
			char[][] s = new char[2 * K][2 * K];
			// 上から K 行以内にあるマスを全て黒く塗り、残りのマスをすべて白く塗る。
			IntStream.range(0, K).forEach(i -> Arrays.fill(s[i], BLACK));
			IntStream.range(K, 2 * K).forEach(i -> Arrays.fill(s[i], WHITE));
			// 上から K − 1 行以内のマスのうち A − 1 個のマスを上下左右斜めに隣り合わないように選び、それらの色を白に変える。
			fill(s, 1, a - 1, WHITE);
			fill(s, K + 1, b - 1, BLACK);
			System.out.println(2 * K + " " + 2 * K);
			IntStream.range(0, 2 * K).forEach(i -> System.out.println(s[i]));
		}
	}

	/**
	 * コマの配列にコマをcount個入れる
	 * 
	 * @param s     コマの配列
	 * @param i     入れる開始行数
	 * @param count 入れる個数
	 * @param koma  入れるコマ
	 */
	private static void fill(final char[][] s, int i, int count, final char koma) {
		int j = 1;
		while (count > 0) {
			s[i][j] = koma;
			j += 2;
			count--;
			if (j >= 2 * K - 1) {
				i += 2;
				j = 1;
			}
		}
	}
}
