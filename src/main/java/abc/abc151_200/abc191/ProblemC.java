package abc.abc151_200.abc191;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	/** X座標の差分一覧 */
	private static final int[] XS = { 0, 0, 1, 1 };
	/** Y座標の差分一覧 */
	private static final int[] YS = { 0, 1, 0, 1 };
	/** 黒のマスを表す文字 */
	private static final char BLACK = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] s = new char[h][];
			IntStream.range(0, h).forEach(i -> s[i] = scanner.next().toCharArray());
			System.out.println(IntStream.range(0, h - 1).map(i -> (int) IntStream.range(0, w - 1)
					.map(j -> count(i, j, s)).filter(count -> 1 == (1 & count)).count()).sum());
		}
	}

	/**
	 * sのn,mの4つの範囲に黒のマスの数を数える
	 * 
	 * @param n
	 * @param m
	 * @param s マスを表す配列
	 * @return sのn,mの4つの範囲に黒のマスの数
	 */
	private static int count(int n, int m, char[][] s) {
		return (int) IntStream.range(0, XS.length).filter(i -> BLACK == s[n + XS[i]][m + YS[i]]).count();
	}
}
