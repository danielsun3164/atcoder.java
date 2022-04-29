package abc.abc201_250.abc215;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int k = scanner.nextInt();
			NavigableMap<Character, Integer> map = new TreeMap<>();
			for (char c : s) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			System.out.println(calc(map, k));
		}
	}

	/**
	 * 文字ごとの数から組み合わせた文字列のk番目(1-index)の文字列を計算する
	 *
	 * @param map 文字ごとの数
	 * @param k
	 * @return 文字ごとの数から組み合わせた文字列のk番目(1-index)の文字列
	 */
	private static String calc(NavigableMap<Character, Integer> map, int k) {
		if (1 == map.size()) {
			Entry<Character, Integer> entry = map.firstEntry();
			return String.valueOf(entry.getKey()).repeat(entry.getValue());
		}
		// ループ中に変更された例外に対応するため、mapのコピーを作る
		NavigableMap<Character, Integer> map2 = new TreeMap<>(map);
		for (char key : map.keySet()) {
			reduce(map2, key);
			int count = calcCount(map2);
			if (k <= count) {
				return key + calc(map2, k);
			} else {
				k -= count;
				map2.put(key, map2.getOrDefault(key, 0) + 1);
			}
		}
		return "";
	}

	/**
	 * 文字ごとの数から指定された文字cの数を一つ減らす
	 *
	 * @param map 文字ごとの数
	 * @param c   文字
	 */
	private static void reduce(NavigableMap<Character, Integer> map, char c) {
		int value = map.get(c);
		if (1 == value) {
			map.remove(c);
		} else {
			map.put(c, value - 1);
		}
	}

	/**
	 * 文字ごとの数から組み合わせた文字列の数を計算する
	 *
	 * @param map 文字ごとの数
	 * @return 組み合わせた文字列の数
	 */
	private static int calcCount(NavigableMap<Character, Integer> map) {
		Collection<Integer> values = map.values();
		int sum = values.stream().mapToInt(Integer::intValue).sum();
		int result = IntStream.rangeClosed(1, sum).reduce(1, (s, i) -> s * i);
		for (int value : values) {
			for (int j = 2; j <= value; j++) {
				result /= j;
			}
		}
		return result;
	}
}
