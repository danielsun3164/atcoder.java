package abc.abc001_050.abc024;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通り実装したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// n
			scanner.nextInt();
			int d = scanner.nextInt(), k = scanner.nextInt();
			// 移動可能な町の一覧
			int[][] lr = new int[d][2];
			IntStream.range(0, d).forEach(i -> {
				lr[i][0] = scanner.nextInt();
				lr[i][1] = scanner.nextInt();
			});
			int[] result = new int[k];
			IntStream.range(0, k).forEach(i -> {
				// 移動の始点
				int s = scanner.nextInt();
				// 移動の終点
				int t = scanner.nextInt();
				result[i] = getResult(s, t, lr);
			});
			Arrays.stream(result).forEach(System.out::println);
		}
	}

	/**
	 * @param s  移動の始点
	 * @param t  移動の終点
	 * @param lr 移動可能の一覧、[i][0]はi+1日目に移動可能な最小値、[i][1]はi+1日目に移動可能な最大値
	 * @return 始点sから終点tにたどり着くのは何日目か
	 */
	private static int getResult(int s, int t, int[][] lr) {
		for (int i = 0; i < lr.length; i++) {
			int[] range = lr[i];
			if (s < t) {
				// 小さいところから大きいところへ移動
				// 移動可能なら、最大値まで移動
				if (s >= range[0]) {
					if (t <= range[1]) {
						return i + 1;
					} else {
						s = Math.max(s, range[1]);
					}
				}
			} else {
				// 大きいところから小さいところへ移動
				// 移動可能なら、最小値まで移動
				if (s <= range[1]) {
					if (t >= range[0]) {
						return i + 1;
					} else {
						s = Math.min(s, range[0]);
					}
				}
			}
		}
		return 0;
	}
}
