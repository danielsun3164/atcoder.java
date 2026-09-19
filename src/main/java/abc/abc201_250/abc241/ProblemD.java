package abc.abc201_250.abc241;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			NavigableMap<Long, Integer> map = new TreeMap<>();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int t = scanner.nextInt();
				long x = scanner.nextLong();
				if (1 == t) {
					map.put(x, map.getOrDefault(x, 0) + 1);
				} else {
					int k = scanner.nextInt();
					sb.append((2 == t) ? lower(map, x, k) : upper(map, x, k)).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * x以下のk番目大きい値を取得する
	 *
	 * @param map 値を格納するマップ
	 * @param x
	 * @param k
	 * @return x以下のk番目大きい値、存在しない場合は-1
	 */
	private static long lower(NavigableMap<Long, Integer> map, long x, int k) {
		Entry<Long, Integer> entry = map.floorEntry(x);
		if (null == entry) {
			return -1L;
		}
		if (entry.getValue() >= k) {
			return entry.getKey();
		}
		return lower(map, entry.getKey() - 1, k - entry.getValue());
	}

	/**
	 * x以上のk番目小さい値を取得する
	 *
	 * @param map 値を格納するマップ
	 * @param x
	 * @param k
	 * @return x以上のk番目小さい値、存在しない場合は-1
	 */
	private static long upper(NavigableMap<Long, Integer> map, long x, int k) {
		Entry<Long, Integer> entry = map.ceilingEntry(x);
		if (null == entry) {
			return -1L;
		}
		if (entry.getValue() >= k) {
			return entry.getKey();
		}
		return upper(map, entry.getKey() + 1, k - entry.getValue());
	}
}
