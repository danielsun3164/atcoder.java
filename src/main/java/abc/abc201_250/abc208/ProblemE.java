package abc.abc201_250.abc208;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 10進数の計算 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] n = scanner.next().toCharArray();
			long k = scanner.nextInt(), INF = k + 1;
			Map<Long, Long> map = new HashMap<>();
			long eq = 1L;
			for (int i = 0; i < n.length; i++) {
				int digit = n[i] - '0';
				Map<Long, Long> next = new HashMap<>();
				// less -> less
				map.entrySet().stream().forEach(entry -> {
					IntStream.range(0, N).forEach(d -> {
						long key = Math.min(INF, entry.getKey() * d);
						next.put(key, next.getOrDefault(key, 0L) + entry.getValue());
					});
				});
				// equal -> less
				for (int d = 0; d < digit; d++) {
					if ((0 != i) || (0 != d)) {
						long key = Math.min(INF, eq * d);
						next.put(key, next.getOrDefault(key, 0L) + 1);
					}
				}
				// equal -> equal
				eq = Math.min(INF, eq * digit);
				// 1...9
				if (0 != i) {
					IntStream.range(1, N).forEach(d -> {
						long key = Math.min(INF, d);
						next.put(key, next.getOrDefault(key, 0L) + 1);
					});
				}
				map = next;
			}
			System.out.println(
					map.entrySet().stream().filter(entry -> entry.getKey() <= k).mapToLong(Map.Entry::getValue).sum()
							+ ((eq <= k) ? 1 : 0));
		}
	}
}
