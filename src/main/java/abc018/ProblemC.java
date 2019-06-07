package abc018;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			int k = scanner.nextInt();
			scanner.nextLine();
			boolean[][] s = new boolean[r][c];
			IntStream.range(0, r).forEach(i -> {
				char[] chars = scanner.nextLine().toCharArray();
				IntStream.range(0, c).forEach(j -> s[i][j] = (chars[j] == 'o'));
			});
			int[][][] count = calcCount(r, c, s);
			System.out.println(IntStream.range(0, r)
					.map(i -> (int) IntStream.range(0, c).filter(j -> check(count, i, j, r, c, k)).count()).sum());
		}
	}

	/**
	 * @param count 縦に連続の白のマスの数の配列
	 * @param i
	 * @param j
	 * @param r     配列の行数
	 * @param c     配列の列数
	 * @param k
	 * @return i,jのところでサイズがkを緑に塗られるかどうか
	 */
	private static boolean check(int[][][] count, int i, int j, int r, int c, int k) {
		if ((i >= k - 1) && (j >= k - 1) && ((i + k - 1) < r) && ((j + k - 1) < c)) {
			for (int l = 0; l < k; l++) {
				if ((count[i][j - l][0] < k - l) || (count[i][j + l][0] < k - l) || (count[i][j - l][1] < k - l)
						|| (count[i][j + l][1] < k - l)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * @param r
	 * @param c
	 * @param s
	 * @return 縦の連続する白のコマの数を計算。[][][0]は上のコマの数、[][][1]は下のコマの数
	 */
	private static int[][][] calcCount(int r, int c, boolean[][] s) {
		int[][][] count = new int[r][c][2];
		IntStream.range(0, c).forEach(j -> {
			int start = 0;
			boolean found = false;
			int i;
			for (i = 0; i < r; i++) {
				if (s[i][j]) {
					if (!found) {
						found = true;
						start = i;
					}
				} else {
					count[i][j][0] = count[i][j][1] = 0;
					if (found) {
						found = false;
						for (int l = start; l < i; l++) {
							count[l][j][0] = l - start + 1;
							count[l][j][1] = i - l;
						}
					}
				}
			}
			if (found) {
				for (int l = start; l < i; l++) {
					count[l][j][0] = l - start + 1;
					count[l][j][1] = i - l;
				}
			}
		});
		return count;
	}
}
