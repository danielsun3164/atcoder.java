package abc.abc201_250.abc214;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 最大値 */
	private static final int MAX = 1_000_000_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			while (t > 0) {
				t--;
				int n = scanner.nextInt();
				TreeMap<Integer, List<Integer>> map = new TreeMap<>();
				for (int i = 0; i < n; i++) {
					int l = scanner.nextInt() - 1, r = scanner.nextInt() - 1;
					List<Integer> list = map.get(l);
					if (null == list) {
						list = new ArrayList<>();
						map.put(l, list);
					}
					list.add(r);
				}
				map.put(MAX + 7, Collections.emptyList());
				int i = map.firstKey();
				Queue<Integer> que = new PriorityQueue<>();
				boolean answer = true;
				while (i <= MAX) {
					if (map.containsKey(i)) {
						que.addAll(map.get(i));
					}
					que.poll();
					if (que.isEmpty()) {
						i = map.ceilingKey(i + 1);
					} else {
						if (que.peek() <= i) {
							answer = false;
							break;
						}
						i++;
					}
				}
				sb.append((answer && que.isEmpty()) ? "Yes" : "No").append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
