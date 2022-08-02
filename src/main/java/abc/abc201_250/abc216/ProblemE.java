package abc.abc201_250.abc216;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			TreeMap<Long, Integer> map = new TreeMap<>();
			long sum = IntStream.range(0, n).mapToLong(i -> {
				long a = scanner.nextLong();
				map.put(a, map.getOrDefault(a, 0) + 1);
				return a;
			}).sum();
			if (k >= sum) {
				System.out.println(map.entrySet().stream()
						.mapToLong(entry -> entry.getKey() * (entry.getKey() + 1) / 2 * entry.getValue()).sum());
				return;
			}
			long answer = 0L;
			while (k > 0) {
				Entry<Long, Integer> lastEntry = map.pollLastEntry();
				long max = lastEntry.getKey();
				long nextKey = map.isEmpty() ? 0L : map.lastKey();
				int maxCount = lastEntry.getValue();
				if ((max - nextKey) * maxCount > k) {
					// ここで終了
					long count = k / maxCount;
					k -= count * maxCount;
					answer += (max + max - count + 1) * count / 2L * maxCount;
					answer += (max - count) * k;
					k = 0;
				} else {
					answer += (max + nextKey + 1) * (max - nextKey) / 2 * maxCount;
					k -= (max - nextKey) * maxCount;
					map.put(nextKey, map.get(nextKey) + maxCount);
				}
			}
			System.out.println(answer);
		}
	}
}
