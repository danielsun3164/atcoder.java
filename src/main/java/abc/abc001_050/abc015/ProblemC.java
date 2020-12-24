package abc.abc001_050.abc015;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[][] t = new int[n][k];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, k).forEach(j -> t[i][j] = scanner.nextInt()));
			if (getResult(0, t, 0)) {
				System.out.println("Found");
			} else {
				System.out.println("Nothing");
			}
		}
	}

	/**
	 * @param n      n行目を計算
	 * @param t      回答の選択肢の一覧配列
	 * @param result 計算途中の結果
	 * @return 結果の中にバッグが含まれているかどうか
	 */
	private static boolean getResult(int n, int[][] t, int result) {
		if (t.length == n) {
			if (0 == result) {
				// 結果が0の状況を見つかった
				return true;
			} else {
				return false;
			}
		} else {
			for (int i : t[n]) {
				if (getResult(n + 1, t, result ^ i)) {
					return true;
				}
			}
			return false;
		}
	}
}
