package other.zone2021;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	/** 数値の種類 */
	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] a = new int[n][N];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, N).forEach(j -> a[i][j] = scanner.nextInt()));
			int left = 0, right = 1_000_000_001;
			while (right > (left + 1)) {
				int med = (left + right) >> 1;
				if (ok(a, med)) {
					left = med;
				} else {
					right = med;
				}
			}
			System.out.println(left);
		}
	}

	/**
	 * 計算結果がvalue以上かどうかを判定する
	 *
	 * @param a     データの一覧
	 * @param value チェック対象の値
	 * @return 計算結果がvalue以上かどうか
	 */
	private static boolean ok(int[][] a, int value) {
		Set<Integer> set = new HashSet<>();
		for (int[] aa : a) {
			int bit = 0;
			for (int i = 0; i < N; i++) {
				if (aa[i] >= value) {
					bit |= (1 << i);
				}
			}
			set.add(bit);
		}
		for (int x : set) {
			for (int y : set) {
				for (int z : set) {
					if (((1 << N) - 1) == (x | y | z)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
