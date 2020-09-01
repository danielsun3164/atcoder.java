package abc.abc177;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc177/submissions/16388865 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int[] a = new int[h], b = new int[h];
			IntStream.range(0, h).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt();
			});
			SortedMap<Integer, Integer> currToOrigin = new TreeMap<>();
			IntStream.range(0, w).forEach(j -> currToOrigin.put(j, j));
			int[] gaps = new int[w], results = new int[h];
			gaps[0] = w;
			Arrays.fill(results, -1);
			int minGapIndex = 0, maxGapIndex = 0;
			for (int i = 0; (i < h) && !currToOrigin.isEmpty(); i++) {
				int left = a[i], right = b[i];
				SortedMap<Integer, Integer> subMap = currToOrigin.subMap(left, right);
				if (!subMap.isEmpty()) {
					int maxOrigin = subMap.get(subMap.lastKey());
					subMap.forEach((key, value) -> gaps[key - value]--);
					subMap.clear();
					if ((right < w) && !currToOrigin.containsKey(right)) {
						currToOrigin.put(right, maxOrigin);
						gaps[right - maxOrigin]++;
						maxGapIndex = Math.max(maxGapIndex, right - maxOrigin);
					}
					while ((minGapIndex <= maxGapIndex) && (0 == gaps[minGapIndex])) {
						minGapIndex++;
					}
				}
				results[i] = (minGapIndex <= maxGapIndex) ? minGapIndex + i + 1 : -1;
			}
			Arrays.stream(results).forEach(System.out::println);
		}
	}
}
