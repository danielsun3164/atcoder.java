package abc040;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			System.out.println(getResult(0, a, new HashMap<Integer, Integer>()));
		}
	}

	/**
	 * @param start 開始位置
	 * @param a     柱のデータの配列
	 * @param map   柱の処理結果のマップ
	 * @return startから開始する場合の最小コスト
	 */
	private static int getResult(int start, final int[] a, Map<Integer, Integer> map) {
		Integer result = map.get(start);
		if (null == result) {
			int n = a.length;
			if (start == n - 1) {
				result = 0;
				map.put(start, result);
			} else if (start == n - 2) {
				result = Math.abs(a[n - 1] - a[start]) + getResult(start + 1, a, map);
				map.put(start, result);
			} else {
				result = Math.min(Math.abs(a[start + 1] - a[start]) + getResult(start + 1, a, map),
						Math.abs(a[start + 2] - a[start]) + getResult(start + 2, a, map));
				map.put(start, result);
			}
		}
		return result;
	}
}
