package abc.abc025;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	/** 盤面のサイズ */
	private static final int SIZE = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[][] b = new int[SIZE - 1][SIZE];
			int bSum = IntStream.range(0, SIZE - 1)
					.map(i -> IntStream.range(0, SIZE).map(j -> b[i][j] = scanner.nextInt()).sum()).sum();
			int[][] c = new int[SIZE][SIZE - 1];
			int cSum = IntStream.range(0, SIZE)
					.map(i -> IntStream.range(0, SIZE - 1).map(j -> c[i][j] = scanner.nextInt()).sum()).sum();
			Koma[][] board = new Koma[SIZE][SIZE];
			IntStream.range(0, SIZE).forEach(i -> Arrays.fill(board[i], Koma.EMPTY));
			int score = eval(board, 1, b, c);
			System.out.println(score);
			System.out.println(bSum + cSum - score);
		}
	}

	/**
	 * https://atcoder.jp/contests/abc025/submissions/2840879 を参考に作成
	 * 
	 * @param board 盤面の状態
	 * @param turn  何番目
	 * @param b
	 * @param c
	 * @return 直大くんの最大スコア
	 */
	private static int eval(Koma[][] board, int turn, final int[][] b, final int[][] c) {
		if (SIZE * SIZE + 1 == turn) {
			return getNaotaResult(board, b, c);
		}
		// 奇数番目は直大くん、偶数番目は直子さん
		int score = (1 == (turn & 1)) ? 0 : Integer.MAX_VALUE;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (Koma.EMPTY == board[i][j]) {
					// 奇数番目は直大くん、偶数番目は直子さん
					board[i][j] = (1 == (turn & 1)) ? Koma.NAOTA : Koma.NAOKO;
					score = (1 == (turn & 1)) ? Math.max(score, eval(board, turn + 1, b, c))
							: Math.min(score, eval(board, turn + 1, b, c));
					board[i][j] = Koma.EMPTY;
				}
			}
		}
		return score;
	}

	/**
	 * @param board 盤面の状態
	 * @param b
	 * @param c
	 * @return 直大くんのスコア
	 */
	private static int getNaotaResult(final Koma[][] board, final int[][] b, final int[][] c) {
		int result = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if ((i < SIZE - 1) && (board[i][j] == board[i + 1][j])) {
					result += b[i][j];
				}
				if ((j < SIZE - 1) && (board[i][j] == board[i][j + 1])) {
					result += c[i][j];
				}
			}
		}
		return result;
	}

	/** コマの定義クラス */
	private enum Koma {
		EMPTY, NAOTA, NAOKO;
	}
}
