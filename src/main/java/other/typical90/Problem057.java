package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem057 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[][] d = new int[n][m];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(d[i], 0);
				int t = scanner.nextInt();
				IntStream.range(0, t).forEach(j -> {
					int x = scanner.nextInt() - 1;
					d[i][x] = 1;
				});
			});
			int[] s = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			int[] zeros = new int[m];
			Arrays.fill(zeros, 0);
			int pos = 0;
			for (int i = 0; i < m; i++) {
				boolean found = false;
				for (int j = pos; j < n; j++) {
					if (1 == d[j][i]) {
						if (j != pos) {
							swap(d, j, pos);
						}
						found = true;
						break;
					}
				}
				if (found) {
					for (int j = 0; j < n; j++) {
						if ((j != pos) && (1 == d[j][i])) {
							for (int k = 1; k < m; k++) {
								d[j][k] ^= d[pos][k];
							}
						}
					}
					if (1 == s[i]) {
						for (int j = i; j < m; j++) {
							s[j] ^= d[pos][j];
						}
					}
					pos++;
				}
			}
			System.out.println(Arrays.equals(s, zeros)
					? IntStream.range(pos, n).mapToLong(i -> i).reduce(1L, (t, i) -> t * 2L % MOD)
					: 0L);
		}
	}

	/**
	 * 配列のi番目のものとj番目のものを交換する
	 *
	 * @param d 配列
	 * @param i
	 * @param j
	 */
	private static void swap(int[][] d, int i, int j) {
		int[] temp = d[i];
		d[i] = d[j];
		d[j] = temp;
	}
}
