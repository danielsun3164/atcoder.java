package other.past201912open;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemG {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] a = new int[n - 1][n];
			IntStream.range(0, n - 1).forEach(i -> IntStream.range(i + 1, n).forEach(j -> a[i][j] = scanner.nextInt()));
			int base = (2 == n) ? 2 : 3;
			System.out
					.println(IntStream.range(0, pow(base, n - 1)).map(i -> getResult(n, a, base, i)).max().getAsInt());
		}
	}

	/**
	 * mのn乗を計算する
	 * 
	 * @param m
	 * @param n
	 * @return mのn乗
	 */
	private static int pow(int m, int n) {
		int result = 1;
		while (n > 0) {
			if (1 == (n & 1)) {
				result *= m;
			}
			n >>= 1;
			m *= m;
		}
		return result;
	}

	/**
	 * 結果を計算して返す
	 * 
	 * @param n     数字の数
	 * @param a     幸福度の配列
	 * @param base  グループの数
	 * @param index 配分計画
	 * @return 計算した結果
	 */
	private static int getResult(final int n, final int[][] a, final int base, int index) {
		return Arrays.stream(getLists(n, base, index)).mapToInt(list -> getResult(n, a, list)).sum();
	}

	/**
	 * indexを配分計画を表す配列に変換
	 * 
	 * @param n     数字の数
	 * @param base  グループ数
	 * @param index 配分計画
	 * @return indexを配分計画を表す配列に変換
	 */
	private static List<Integer>[] getLists(final int n, final int base, int index) {
		@SuppressWarnings("unchecked")
		List<Integer>[] result = new List[base];
		IntStream.range(0, base).forEach(i -> result[i] = new ArrayList<>());
		for (int i = 0; i < n; i++) {
			result[index % base].add(i);
			index /= base;
		}
		return result;
	}

	/**
	 * 一つのグループの幸福度を計算
	 * 
	 * @param n    数字の数
	 * @param a    幸福度の配列
	 * @param list 一つのグループの数字一覧
	 * @return 一つのグループの幸福度
	 */
	private static int getResult(final int n, final int[][] a, List<Integer> list) {
		return IntStream.range(0, list.size() - 1)
				.map(i -> IntStream.range(i + 1, list.size()).map(j -> a[list.get(i)][list.get(j)]).sum()).sum();
	}
}
