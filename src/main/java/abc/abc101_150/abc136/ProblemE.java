package abc.abc101_150.abc136;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc136/submissions/17432004 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] a = new int[n];
			int sum = IntStream.range(0, n).map(i -> a[i] = scanner.nextInt()).sum();
			List<Integer> list = getDivisionList(sum);
			for (int i : list) {
				if (ok(a, k, i)) {
					System.out.println(i);
					return;
				}
			}
		}
	}

	/**
	 * 数字nの約数一覧を取得する
	 * 
	 * @param n
	 * @return 数字nの約数一覧
	 */
	private static List<Integer> getDivisionList(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i * i <= n; i++) {
			if (0 == n % i) {
				list.add(i);
				if (n / i != i) {
					list.add(n / i);
				}
			}
		}
		// 大きいから小さい順でソート
		list.sort(Comparator.reverseOrder());
		return list;
	}

	/**
	 * aのすべての要素をk回以内操作し、nの倍数が成立するかどうかを判定する
	 * 
	 * @param a
	 * @param k
	 * @param n
	 * @return aのすべての要素をk回以内操作し、nの倍数が成立するかどうか
	 */
	private static boolean ok(int[] a, int k, int n) {
		SortedMap<Integer, Integer> map = new TreeMap<>();
		int count = 0;
		for (int ai : a) {
			int remander = ai % n;
			if (remander > 0) {
				map.put(remander, map.getOrDefault(remander, 0) + 1);
			}
		}
		while (!map.isEmpty() && count <= k) {
			int max = map.lastKey();
			remove(map, max);
			int need = n - max, sum = 0;
			while (sum < need) {
				int min = map.firstKey();
				sum += min;
				remove(map, min);
			}
			if (sum > need) {
				map.put(sum - need, map.getOrDefault(sum - need, 0) + 1);
			}
			count += need;
		}
		return count <= k;
	}

	/**
	 * mapからkeyの要素を一つ削除する
	 * 
	 * @param map
	 * @param key
	 */
	private static void remove(Map<Integer, Integer> map, int key) {
		int value = map.get(key);
		if (value > 1) {
			map.put(key, value - 1);
		} else {
			map.remove(key);
		}
	}
}
