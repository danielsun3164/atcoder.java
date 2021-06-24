package abc.abc101_150.abc147;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int[][] x = new int[n][], y = new int[n][];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				x[i] = new int[a[i]];
				y[i] = new int[a[i]];
				IntStream.range(0, a[i]).forEach(j -> {
					x[i][j] = scanner.nextInt() - 1;
					y[i][j] = scanner.nextInt();
				});
			});
			System.out.println(IntStream.range(1, 1 << n).filter(bit -> ok(n, a, x, y, bit)).map(Integer::bitCount)
					.max().orElse(0));
		}
	}

	/**
	 * 2進数の状態が達成できるかどうかを計算する
	 *
	 * @param n   人数
	 * @param a   それぞれの人の証言数の配列
	 * @param x   それぞれの証言対象の人の配列
	 * @param y   それぞれの証言結果の人の配列
	 * @param bit 現在の処理状態の2進数表現
	 * @return 2進数の状態が達成できるかどうか
	 */
	private static boolean ok(int n, int[] a, int[][] x, int[][] y, int bit) {
		int[] now = new int[n];
		IntStream.range(0, n).forEach(i -> now[i] = (1 & (bit >> i)));
		for (int i = 0; i < n; i++) {
			if (1 == now[i]) {
				for (int j = 0; j < a[i]; j++) {
					if (now[x[i][j]] != y[i][j]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
