package abc.abc001_050.abc027;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			// 予定実施回数
			int depth = 0;
			for (int i = 0; i <= 63; i++) {
				if (0 == (n >> i)) {
					depth = i;
					break;
				}
			}
			System.out.println(calcResult(1L, n, depth, Player.TAKAHASHI));
		}
	}

	/**
	 * https://atcoder.jp/contests/abc027/submissions/4877563 を参考に作成
	 * 
	 * @param now    現在の値
	 * @param n      最大値
	 * @param depth  予定実施回数
	 * @param player 現在のプレヤー
	 * @return プレーした結果（勝者のプレヤー）
	 */
	private static Player calcResult(long now, final long n, int depth, Player player) {
		long next = (((1 == (depth & 1)) && (Player.TAKAHASHI == player))
				|| ((0 == (depth & 1)) && (Player.AOKI == player))) ? 2 * now + 1 : 2 * now;
		if (next > n) {
			return player.next();
		} else {
			return calcResult(next, n, depth, player.next());
		}
	}

	/**
	 * プレヤーを定義するenum
	 */
	private static enum Player {
		AOKI("Aoki"), TAKAHASHI("Takahashi");
		private String name;

		Player(String name) {
			this.name = name;
		}

		/**
		 * @return 次のプレヤー
		 */
		Player next() {
			if (this == AOKI) {
				return TAKAHASHI;
			} else {
				return AOKI;
			}
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
}
