package abc.abc151_200.abc188;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), c = scanner.nextInt();
			TreeMap<Integer, Long> map = new TreeMap<>();
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt(), b = scanner.nextInt(), v = scanner.nextInt();
				map.put(a, map.getOrDefault(a, 0L) + v);
				map.put(b + 1, map.getOrDefault(b + 1, 0L) - v);
			});
			Entry<Integer, Long> pre = null;
			long answer = 0L, value = 0L;
			for (Entry<Integer, Long> entry : map.entrySet()) {
				if (null != pre) {
					answer += (entry.getKey() - pre.getKey()) * ((value > c) ? c : value);
				}
				pre = entry;
				value += entry.getValue();
			}
			System.out.println(answer);
		}
	}
}
