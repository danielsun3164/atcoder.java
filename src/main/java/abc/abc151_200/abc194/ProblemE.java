package abc.abc151_200.abc194;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			Map<Integer, List<Integer>> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				List<Integer> list = map.get(a[i]);
				if (null == list) {
					list = new ArrayList<>();
					list.add(0);
					map.put(a[i], list);
				}
				list.add(i + 1);
			});
			map.entrySet().forEach(entry -> entry.getValue().add(n + 1));
			for (int i = 0;; i++) {
				if (ok(map, i, m)) {
					System.out.println(i);
					return;
				}
			}
		}
	}

	/**
	 * xのindexの差分がm以上のものが存在するかどうかを計算する
	 *
	 * @param map indexを保存するマップ
	 * @param x
	 * @param m
	 * @return xのindexの差分がm以上のものが存在するかどうか
	 */
	private static boolean ok(Map<Integer, List<Integer>> map, int x, int m) {
		List<Integer> list = map.get(x);
		if (null == list) {
			return true;
		}
		Integer pre = null;
		for (int j : list) {
			if (null != pre) {
				if (j - pre > m) {
					return true;
				}
			}
			pre = j;
		}
		return false;
	}
}
