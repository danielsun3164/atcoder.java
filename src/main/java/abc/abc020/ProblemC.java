package abc.abc020;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 配列の縦の長さ */
	private static int h;
	/** 配列の横の長さ */
	private static int w;
	/** 目標時間数 */
	private static int t;
	/** コマの配置情報、白がtrue、黒がfalse */
	private static boolean[][] komas;
	/** 計算結果を格納する配列 */
	private static int[][] results;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			h = scanner.nextInt();
			w = scanner.nextInt();
			t = scanner.nextInt();
			int startX = 0, startY = 0, endX = 0, endY = 0;
			komas = new boolean[h][w];
			results = new int[h][w];
			for (int i = 0; i < h; i++) {
				char[] s = scanner.next().toCharArray();
				for (int j = 0; j < w; j++) {
					komas[i][j] = (s[j] != '#');
					if ('S' == s[j]) {
						startX = i;
						startY = j;
					}
					if ('G' == s[j]) {
						endX = i;
						endY = j;
					}
				}
			}
			System.out.println(getResults(1, t, startX, startY, endX, endY));
		}
	}

	/**
	 * start〜endの間で処理可能な最大なコストを返す
	 * 
	 * <pre>
	 * startは必ず処理可能、endは必ず処理できない
	 * </pre>
	 * 
	 * @param start
	 * @param end
	 * @param startX 起点のX座標
	 * @param startY 起点のY座標
	 * @param endX   終点のX座標
	 * @param endY   終点のY座標
	 * @return start〜endの間で処理可能な最大なコスト
	 */
	private static int getResults(int start, int end, final int startX, final int startY, final int endX,
			final int endY) {
		if (1 == end - start) {
			return start;
		}
		// resultsを初期化
		IntStream.range(0, h).forEach(i -> Arrays.fill(results[i], Integer.MAX_VALUE));
		results[startX][startY] = 0;
		int middle = (start + end) / 2;
		if (calcResults(startX, startY, endX, endY, middle)) {
			return getResults(middle, end, startX, startY, endX, endY);
		} else {
			return getResults(start, middle, startX, startY, endX, endY);
		}
	}

	/**
	 * 起点から終点までのルートが存在するか計算する
	 * 
	 * @param startX 起点のX座標
	 * @param startY 起点のY座標
	 * @param endX   終点のX座標
	 * @param endY   終点のY座標
	 * @param k      黒のコスのコスト
	 * @return 起点から終点までのルートが存在するか
	 */
	private static boolean calcResults(int startX, int startY, int endX, int endY, final int k) {
		// 終点に辿りついたとき、終了
		if ((startX == endX) && (startY == endY)) {
			return true;
		}
		int now = results[startX][startY];
		// 上のコマを計算
		if (startX > 0) {
			if (calcNowResult(startX - 1, startY, endX, endY, k, now)) {
				return true;
			}
		}
		// 左のコマを計算
		if (startY > 0) {
			if (calcNowResult(startX, startY - 1, endX, endY, k, now)) {
				return true;
			}
		}
		// 下のコマを計算
		if (startX + 1 < h) {
			if (calcNowResult(startX + 1, startY, endX, endY, k, now)) {
				return true;
			}
		}
		// 右のコマを計算
		if (startY + 1 < w) {
			if (calcNowResult(startX, startY + 1, endX, endY, k, now)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 現在のコマの結果を計算
	 * 
	 * @param newX 新しい起点のX座標
	 * @param newY 新しい起点のY座標
	 * @param endX 終点のX座標
	 * @param endY 終点のY座標
	 * @param k    黒のコスのコスト
	 * @param now  コストの初期値
	 * @return 現在のコマで計算した場合の結果
	 */
	private static boolean calcNowResult(int newX, int newY, int endX, int endY, final int k, int now) {
		if (komas[newX][newY]) {
			now++;
		} else {
			now += k;
		}
		if (now > t) {
			// 上限時間数を超えた場合、終了
			return false;
		}
		if (now < results[newX][newY]) {
			results[newX][newY] = now;
			return calcResults(newX, newY, endX, endY, k);
		}
		return false;
	}
}
