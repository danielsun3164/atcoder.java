package abc.abc201_250.abc228;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc228/editorial/2944 の解法1の実装<br/>
 * https://atcoder.jp/contests/abc228/submissions/27341496 にも参考
 */
public class ProblemD {

	/** 2^20 */
	private static final int N = 1 << 20;
	/** マスク */
	private static final int MASK = N - 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			Map<Integer, Long> map = new HashMap<>();
			NavigableMap<Integer, Integer> interval = new TreeMap<>();
			interval.put(N, 0);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int t = scanner.nextInt();
				long x = scanner.nextLong();
				if (1 == t) {
					int key = (int) (x & MASK);
					Entry<Integer, Integer> entry = interval.higherEntry(key);
					if (null == entry) {
						key = 0;
						entry = interval.firstEntry();
					}
					if (entry.getValue() <= key) {
						map.put(key, x);
						int l1 = entry.getValue(), r1 = key, l2 = key + 1, r2 = entry.getKey();
						interval.remove(entry.getKey());
						if (l1 != r1) {
							interval.put(r1, l1);
						}
						if (l2 != r2) {
							interval.put(r2, l2);
						}
					} else {
						map.put(entry.getValue(), x);
						if (entry.getKey().equals(entry.getValue() + 1)) {
							interval.remove(entry.getKey());
						} else {
							interval.put(entry.getKey(), entry.getValue() + 1);
						}
					}
				} else {
					sb.append(map.getOrDefault((int) (x & MASK), -1L)).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
