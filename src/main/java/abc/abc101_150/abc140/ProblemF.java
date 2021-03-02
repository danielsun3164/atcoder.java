package abc.abc101_150.abc140;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc140/submissions/15251028 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			TreeMap<Integer, Integer> map = new TreeMap<>();
			IntStream.range(0, 1 << n).forEach(i -> {
				int s = scanner.nextInt();
				map.put(s, map.getOrDefault(s, 0) + 1);
			});
			// 現在いるスライム一覧
			List<Integer> now = new ArrayList<>();
			now.add(map.lastKey());
			remove(map, map.lastKey());
			for (int i = 0; i < n; i++) {
				int size = now.size();
				for (int j = 0; j < size; j++) {
					// nowのj番目のスライムが増殖して、生成できる最大のスライムを取得する
					Integer max = map.lowerKey(now.get(j));
					if (null == max) {
						System.out.println("No");
						return;
					}
					remove(map, max);
					now.add(max);
				}
			}
			System.out.println("Yes");
		}
	}

	/**
	 * mapからkeyの値を−1をする。値が0になる場合、keyを削除する
	 *
	 * @param map
	 * @param key
	 */
	private static void remove(TreeMap<Integer, Integer> map, int key) {
		int value = map.get(key);
		if (1 == value) {
			map.remove(key);
		} else {
			map.put(key, value - 1);
		}
	}
}
