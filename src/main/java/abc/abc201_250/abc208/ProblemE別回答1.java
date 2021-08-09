package abc.abc201_250.abc208;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc208/submissions/23938991 にも参考
 */
public class ProblemE別回答1 {

	/** 10進数の計算 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] n = scanner.next().toCharArray();
			long k = scanner.nextLong(), INF = k + 1;
			@SuppressWarnings("unchecked")
			Map<Long, Long>[] map = new Map[2];
			IntStream.range(0, 2).forEach(i -> map[i] = new HashMap<>());
			IntStream.range(0, n.length).forEach(i -> {
				int digit = n[i] - '0';
				@SuppressWarnings("unchecked")
				Map<Long, Long>[] next = new Map[2];
				IntStream.range(0, 2).forEach(b -> {
					next[b] = new HashMap<>();
					int je = (b > 0) ? digit + 1 : N;
					map[b].entrySet().stream().forEach(entry -> {
						IntStream.range(0, je).forEach(j -> {
							long key = Math.min(INF, entry.getKey() * j);
							Map<Long, Long> nex = next[((1 == b) && (digit == j)) ? 1 : 0];
							nex.put(key, nex.getOrDefault(key, 0L) + entry.getValue());
						});
					});
				});
				int je = (0 == i) ? digit + 1 : N;
				LongStream.range(1, je).forEach(j -> {
					Map<Long, Long> nex = next[((0 == i) && (digit == j)) ? 1 : 0];
					nex.put(j, nex.getOrDefault(j, 0L) + 1);
				});
				set(map, next);
			});
			System.out
					.println(
							IntStream
									.range(0, 2).mapToLong(b -> map[b].entrySet().stream()
											.filter(entry -> entry.getKey() <= k).mapToLong(Map.Entry::getValue).sum())
									.sum());
		}
	}

	/**
	 * map中身をnextとする
	 *
	 * @param map
	 * @param next
	 */
	private static void set(Map<Long, Long>[] map, Map<Long, Long>[] next) {
		IntStream.range(0, map.length).forEach(i -> map[i] = next[i]);
	}
}
