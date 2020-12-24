package abc.abc151_200.abc184;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long r1 = scanner.nextLong(), c1 = scanner.nextLong();
			long r2 = scanner.nextLong(), c2 = scanner.nextLong();
			if ((r1 == r2) && (c1 == c2)) {
				System.out.println(0);
			} else if (check1(r1, c1, r2, c2)) {
				System.out.println(1);
			} else if (check2(r1, c1, r2, c2)) {
				System.out.println(2);
			} else {
				System.out.println(3);
			}
		}
	}

	/**
	 * 1回の移動で実現可能かどうかをチェックする
	 * 
	 * @param r1 開始座標X座標
	 * @param c1 開始座標Y座標
	 * @param r2 終了座標X座標
	 * @param c2 終了座標Y座標
	 * @return 1回の移動で実現可能かどうか
	 */
	private static boolean check1(final long r1, final long c1, final long r2, final long c2) {
		return (Math.abs(r1 - c1) == Math.abs(r2 - c2)) || (Math.abs(r1 + c1) == Math.abs(r2 + c2))
				|| (Math.abs(r1 - r2) + Math.abs(c1 - c2) <= 3L);
	}

	/**
	 * 2回の移動で実現可能かどうかをチェックする
	 * 
	 * @param r1 開始座標X座標
	 * @param c1 開始座標Y座標
	 * @param r2 終了座標X座標
	 * @param c2 終了座標Y座標
	 * @return 2回の移動で実現可能かどうか
	 */
	private static boolean check2(final long r1, final long c1, final long r2, final long c2) {
		return (0L == (1L & (r1 + c1 + r2 + c2))) || (Math.abs(r1 - r2) + Math.abs(c1 - c2) <= 6)
				|| (Math.abs((r1 + c1) - (r2 + c2)) <= 3) || (Math.abs((r1 - c1) - (r2 - c2)) <= 3);
	}
}
