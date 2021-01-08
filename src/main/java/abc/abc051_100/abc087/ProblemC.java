package abc.abc051_100.abc087;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] a = new int[2][n];
			IntStream.range(0, 2).forEach(i -> IntStream.range(0, n).forEach(j -> a[i][j] = scanner.nextInt()));
			System.out.println(getResult(0, 0, a, new HashMap<>()));
		}
	}

	/**
	 * @param i   現在の縦座標
	 * @param j   現在の横座標
	 * @param a   飴の数の配列
	 * @param map 計算結果を保存するマップ
	 * @return (i,j)の地点から終点までの結果の最大値
	 */
	private static int getResult(int i, int j, final int[][] a, Map<List<Integer>, Integer> map) {
		List<Integer> key = Arrays.asList(i, j);
		Integer result = map.get(key);
		if (null == result) {
			result = a[i][j];
			if (i < a.length - 1) {
				// 下に移動できる場合
				if (j < a[0].length - 1) {
					// 右に移動できる場合、双方向の結果の最大値を計算
					result += Math.max(getResult(i + 1, j, a, map), getResult(i, j + 1, a, map));
				} else {
					// 右に移動できない場合、下方向の結果を計算
					result += getResult(i + 1, j, a, map);
				}
			} else {
				// 下に移動できない場合
				if (j < a[0].length - 1) {
					// 右に移動できる場合、右方向の結果を計算
					result += getResult(i, j + 1, a, map);
				}
			}
		}
		return result;
	}
}
